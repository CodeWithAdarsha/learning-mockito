package com.hubberspot.mockito.annotations.support;

import com.hubberspot.mockito.Book;

import java.util.List;

public interface BookRepository {
  List<Book> findNewBooks(int days);
}
