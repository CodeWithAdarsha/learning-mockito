package com.hubberspot.mockito.spies;

import com.hubberspot.mockito.Book;

public class BookManager {

  private final BookService bookService;

  public BookManager(BookService bookService) {
    this.bookService = bookService;
  }

  public int applyDiscountOnBook(String bookId, int discountRate) {
    Book book = bookService.findBook(bookId); // We need to Mock
    return bookService.getAppliedDiscount(book, discountRate);
  }
}
