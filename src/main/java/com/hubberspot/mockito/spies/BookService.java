package com.hubberspot.mockito.spies;

import com.hubberspot.mockito.Book;

public class BookService {

  public Book findBook(String bookId) {
    throw new RuntimeException("Method not implemented");
  }

  public int getAppliedDiscount(Book book, int discountRate) {
    int price = book.getPrice();
    return price - (price * discountRate / 100);
  }
}
