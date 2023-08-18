package com.walmart.exercise.repository;

import com.walmart.exercise.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(Long isbn);

    Book findBookByAutorName(String autorName);

    @Query("select b from books b where date > :date")
    List<Book> findBookByDate(Date date);

}
