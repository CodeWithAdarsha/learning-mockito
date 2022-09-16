package com.hubberspot.mockito.test_doubles.stub;

import com.hubberspot.mockito.Book;

import java.util.List;

public interface BookRepository {
  List<Book> findNewBooks(int days);
}
