package com.walmart.exercise.service;

import com.walmart.exercise.entity.Book;
import com.walmart.exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(Long isbn) {
        return bookRepository.findByIsbn(isbn);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Book saveBook(Book book) {

        if(!book.getDate().after(new Date())){
            return bookRepository.save(book);
        }else{
            throw new RuntimeException("The date should not be greatter that today");
        }
    }

    @Override
    public Book getBookByAutorName(String autorName) {
        return bookRepository.findBookByAutorName(autorName);
    }

    @Override
    public List<Book> getBookByDate(Date date) {
        return bookRepository.findBookByDate(date);
    }
}
