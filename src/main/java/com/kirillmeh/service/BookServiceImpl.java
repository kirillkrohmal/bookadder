package com.kirillmeh.service;

import com.kirillmeh.model.Book;
import com.kirillmeh.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book update(Book book, Long id) {
        Book entity = bookRepository.findById(id);

        if(book.getAuthor() != null) entity.setAuthor(book.getAuthor());
        if(book.getDescription() != null) bookRepository.findById (id);
        if(book.getIsbn() != null) bookRepository.findById (id);
        if(book.getTitle() != null) bookRepository.findById (id);
        if(book.getImageData() != null) bookRepository.findById (id);
        if(book.getImageStr() != null) bookRepository.findById (id);
        if(book.getYear() != 0) bookRepository.findById (id);

        entity.setReadAlready (book.isReadAlready());

        return bookRepository.save(book);
    }
}
