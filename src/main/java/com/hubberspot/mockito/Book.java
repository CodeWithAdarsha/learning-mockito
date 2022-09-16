package com.hubberspot.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private String bookId;
  private String title;
  private int price;
  private LocalDate publishedDate;
}
