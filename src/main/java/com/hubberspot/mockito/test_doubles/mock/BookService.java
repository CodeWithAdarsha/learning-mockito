package com.hubberspot.mockito.test_doubles.mock;

import com.hubberspot.mockito.Book;

public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void addBook(Book book) {
    if (book.getPrice() > 400) {
      return;
    }
    bookRepository.save(book);
  }
}
