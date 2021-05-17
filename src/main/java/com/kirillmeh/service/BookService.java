package com.kirillmeh.service;


import com.kirillmeh.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookService {
    List<Book> findAll();

    Book findById(Long id);
    Book save(Book book);

    void delete(Book book);

    Book update(Book book, Long id);

    Page<Book> search(String term, int printYear, Pageable pageable);
    Page<Book> search(String term, int printYear, boolean readAlReady, Pageable pageable);
}
