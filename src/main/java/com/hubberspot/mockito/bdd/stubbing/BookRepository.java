package com.hubberspot.mockito.bdd.stubbing;

import com.hubberspot.mockito.Book;

import java.util.List;

public interface BookRepository {
  List<Book> findNewBooks(int days);
}
