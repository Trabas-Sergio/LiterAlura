package com.alura.LiterAlura.repository;

import com.alura.LiterAlura.model.Book;
import com.alura.LiterAlura.model.BookEntity;
import com.alura.LiterAlura.model.Person;
import com.alura.LiterAlura.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT DISTINCT b.author FROM BookEntity b WHERE b.author IS NOT NULL")
    List<PersonEntity> listRegisteredAuthors();

    boolean existsByTitle(String title);

    @Query("SELECT a FROM BookEntity b JOIN b.author a WHERE a.birthYear <= :year AND a.deathYear >= :year")
    List<PersonEntity> listLivingAuthors(Integer year);

    List<BookEntity> findByLanguageContainsIgnoreCase(String lenguage);
}
