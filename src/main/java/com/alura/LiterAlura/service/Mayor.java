package com.alura.LiterAlura.service;

import com.alura.LiterAlura.model.*;
import com.alura.LiterAlura.repository.IBookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Mayor {
    private Scanner keyboard = new Scanner(System.in);
    private APIConsumption apiConsumption = new APIConsumption();
    private final String URL_BASE = "https://gutendex.com/books/";
    private DataConverterImpl dataConverter = new DataConverterImpl();
    private IBookRepository bookRepository;

    public Mayor(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Search Book by title
                    2 - List registered book
                    3 - List registered authors
                    4 - List living authors
                    5 - List authors by lenguage                  
                                  
                    0 - Exit
                    """;
            System.out.println(menu);
            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    listBook();
                    break;
                case 3:
                    listRegisteredAuthors();
                    break;
                case 4:
                    listLivingAuthors();
                    break;
                case 5:
                    listAuthorsByLenguage();
                    break;
                case 0:
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

    }

    private void searchBook() {
        System.out.println("Write the name of the book you want to search: ");
        var input = keyboard.nextLine();
        var json = apiConsumption.consumeAPI(URL_BASE + "?search=" + input.replace(" ", "+"));
        System.out.println(json);
        DataLibrary data = dataConverter.convertData(json, DataLibrary.class);

        Optional<Book> searchedBook = data.books().stream()
                .filter(book -> book.title().toUpperCase().contains(input.toUpperCase()))
                .findFirst();

        if (searchedBook.isPresent()) {
            Book book = searchedBook.get();
            if (bookRepository.existsByTitle(book.title())){
                System.out.println("The book is registered in the Database!");
            } else {
                System.out.println("The book was found.");
                System.out.printf("""
                            ----- BOOK -----
                            Title: %s
                            Author: %s
                            Languages: %s
                            Download Count: %d
                            ----------------
                            %n""", searchedBook.get().title(), searchedBook.get().author().get(0).name(),
                        searchedBook.get().languages().get(0), searchedBook.get().downloadCount());
                bookRepository.save(new BookEntity(book));
            }

        } else {
            System.out.println("The book was not found.");
        }
    }

    private void listBook() {
        List<BookEntity> books= bookRepository.findAll();
        books.forEach(b -> System.out.printf("""
                            ----- BOOK -----
                            Title: %s
                            Author: %s
                            Languages: %s
                            Download Count: %d
                            ----------------
                            %n""", b.getTitle(), b.getAuthor().getName(), b.getLanguage(), b.getDownloadCount()));
    }

    private void listRegisteredAuthors() {
        bookRepository.listRegisteredAuthors().forEach(
                a -> System.out.printf("""
                            ----- AUTHOR -----
                            Name : %s
                            Birth Year: %d
                            Death Year: %d
                            Books: %s
                            ----------------
                            %n""", a.getName(), a.getBirthYear(), a.getDeathYear(), a.getBooks().stream().map(BookEntity::getTitle).collect(Collectors.joining(", "))));
    }

    private void listLivingAuthors() {
        System.out.println("Write the year you want to search.");
        var year = keyboard.nextInt();
        keyboard.nextLine();
        bookRepository.listLivingAuthors(year).forEach(
                a -> System.out.printf("""
                            ----- AUTHOR -----
                            Name : %s
                            Birth Year: %d
                            Death Year: %d
                            Books: %s
                            ----------------
                            %n""", a.getName(), a.getBirthYear(), a.getDeathYear(), a.getBooks().stream().map(BookEntity::getTitle).collect(Collectors.joining(", ")))
        );
    }

    private void listAuthorsByLenguage() {
        System.out.println("""
                Enter the lenguage to search for the books:             
                [es] Español             
                [en] Inglés             
                [fr] Frances             
                [pt] Portugués             
                """);

        var input = keyboard.nextLine();
        bookRepository.findByLanguageContainsIgnoreCase(input).forEach(b -> System.out.printf("""
                            ----- BOOK -----
                            Title: %s
                            Author: %s
                            Languages: %s
                            Download Count: %d
                            ----------------
                            %n""", b.getTitle(), b.getAuthor().getName(),
                b.getLanguage(), b.getDownloadCount()));
    }
}
