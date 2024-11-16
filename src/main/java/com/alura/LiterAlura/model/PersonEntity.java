package com.alura.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<BookEntity> books;

    public PersonEntity() {
    }

    public PersonEntity(Person a) {
        this.name = a.name();
        this.birthYear = a.birthYear();
        this.deathYear = a.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        books.forEach(b -> b.setAuthor(this));
        this.books = books;
    }
}
