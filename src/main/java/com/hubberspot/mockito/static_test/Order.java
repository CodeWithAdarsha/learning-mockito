package com.hubberspot.mockito.static_test;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

  private String productName;
  private Long amount;
  private String id;
  private LocalDateTime creationDate;
}
