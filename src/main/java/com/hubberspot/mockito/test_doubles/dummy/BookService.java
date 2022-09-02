package com.hubberspot.mockito.test_doubles.dummy;

import com.hubberspot.mockito.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BookService {

  private BookRepository bookRepository;

  public void addBook(Book book) {
    bookRepository.save(book);
  }

  public int findNumberOfBooks() {
    return bookRepository.findAll().size();
  }

  // Other methods which use EmailService
}
