package com.hubberspot.mockito.annotations.support;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {
  private String bookId;
  private String title;
  private int price;
  private LocalDate publishedDate;

  public Book(String bookId, String title, int price, LocalDate publishedDate) {
    this.bookId = bookId;
    this.title = title;
    this.price = price;
    this.publishedDate = publishedDate;
  }
}
