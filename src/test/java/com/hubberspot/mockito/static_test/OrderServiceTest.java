package com.hubberspot.mockito.static_test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

  private final OrderServiceStatic cut = new OrderServiceStatic();
  private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
  private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2020, 1, 1, 12, 0);

  @Test
  void shouldIncludeRandomOrderIdWhenNoParentOrderExists() {

    try (var mockedUuid = Mockito.mockStatic(UUID.class)) {
      mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

      Order result = cut.createOrder("MacBook Pro", 2L, null);

      assertEquals("8d8b30e3-de52-4f1c-a71c-9905a8043dac", result.getId());
    }
  }

  @Test
  void shouldIncludeCurrentTimeWhenCreatingANewOrder() {
    try (var mockedLocalDateTime = Mockito.mockStatic(LocalDateTime.class)) {
      mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

      Order result = cut.createOrder("MacBook Pro", 2L, "42");
      assertEquals(defaultLocalDateTime, result.getCreationDate());
    }
  }
}
