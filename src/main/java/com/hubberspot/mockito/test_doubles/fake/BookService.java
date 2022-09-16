package com.hubberspot.mockito.test_doubles.fake;

import com.hubberspot.mockito.Book;

public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void addBook(Book book) {
    bookRepository.save(book);
  }

  public int findNumberOfBooks() {
    return bookRepository.findAll().size();
  }
}
