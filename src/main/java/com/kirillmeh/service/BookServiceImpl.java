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
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
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
        Book entity = bookRepository.findById (id).orElse(null);

        if(book.getAuthor() != null) entity.setAuthor (book.getAuthor());
        if(book.getDescription() != null) entity.setDescription (book.getDescription());
        if(book.getIsbn() != null) entity.setIsbn (book.getIsbn());
        if(book.getTitle() != null) entity.setTitle (book.getTitle());
        if(book.getImageData() != null) entity.setImageData (book.getImageData());
        if(book.getImageStr() != null) entity.setImageStr (book.getImageStr());
        if(book.getYear() != 0) entity.setYear (book.getYear());

        entity.setReadAlready (book.isReadAlready());

        return bookRepository.save(book);
    }
}
