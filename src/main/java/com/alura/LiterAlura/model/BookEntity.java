package com.alura.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private PersonEntity author;
    private String language;
    private Integer downloadCount;

    public BookEntity() {
    }


//    public BookEntity(Optional<Book> searchedBook) {
//        this.title = searchedBook.get().title();
//        this.author = searchedBook.get().author().stream()
//                .map(PersonEntity::new).toList().get(0);
//        this.language = searchedBook.get().languages().get(0);
//        this.downloadCount = searchedBook.get().downloadCount();
//    }

    public BookEntity(Book dataBook) {
        this.title = dataBook.title();
        this.author = dataBook.author().stream()
                .map(PersonEntity::new).toList().get(0);
        this.language = dataBook.languages().get(0);
        this.downloadCount = dataBook.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PersonEntity getAuthor() {
        return author;
    }

    public void setAuthor(PersonEntity author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}
