package com.walmart.exercise.service;

import com.walmart.exercise.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {


    public List<Book> getBook();


    public Book getBookByIsbn(Long isbn);


    public Book saveBook(Book book);

    public Book getBookByAutorName(String autorName);

    public List<Book> getBookByDate(Date date);

}
