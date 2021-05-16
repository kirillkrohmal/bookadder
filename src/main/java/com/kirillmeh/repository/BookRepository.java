package com.kirillmeh.repository;

import com.kirillmeh.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {



}
