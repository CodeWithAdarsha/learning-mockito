package com.hubberspot.mockito.argument_captor;

import com.hubberspot.mockito.Book;

public interface BookRepository {
  void save(Book book);

  Book findBookById(String bookId);
}
