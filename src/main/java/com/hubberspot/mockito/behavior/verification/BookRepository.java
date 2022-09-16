package com.hubberspot.mockito.behavior.verification;

import com.hubberspot.mockito.Book;

public interface BookRepository {
  void save(Book book);

  Book findBookById(String bookId);
}
