package com.hubberspot.mockito.test_doubles.dummy;

import com.hubberspot.mockito.Book;

import java.util.Collection;

public interface BookRepository {
  void save(Book book);

  Collection<Book> findAll();
}
