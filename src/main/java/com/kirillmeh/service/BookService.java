package com.kirillmeh.service;


import com.kirillmeh.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);
    Book save(Book book);

    void delete(Book book);

    Book update(Book book, Long id);


}
