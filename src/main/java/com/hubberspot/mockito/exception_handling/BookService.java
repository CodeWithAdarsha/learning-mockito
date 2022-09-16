package com.hubberspot.mockito.exception_handling;

import com.hubberspot.mockito.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void getTotalPriceOfBooks() {
    List<Book> books;
    try {
      books = bookRepository.findAllBooks();
    } catch (SQLException e) {
      // log exception
      throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
    }
    int totalPrice = 0;
    for (Book book : books) {
      totalPrice = totalPrice + book.getPrice();
    }
  }

  public void addBook(Book book) {
    try {
      bookRepository.save(book);
    } catch (SQLException e) {
      // log exception
      throw new DatabaseWriteException("Unable to write in database due to - " + e.getMessage());
    }
  }
}
