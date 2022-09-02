package com.hubberspot.mockito.bdd.behavior_verification;

import com.hubberspot.mockito.Book;

public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void updatePrice(String bookId, int updatedPrice) {
    Book book = bookRepository.findBookById(bookId);
    book.setPrice(updatedPrice);
    bookRepository.save(book);
  }
}
