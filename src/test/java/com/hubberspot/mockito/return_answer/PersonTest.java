package com.hubberspot.mockito.return_answer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonTest {

  @Mock Person person;

  @Test
  void testChangePersonResponse_ThenReturn() {
    // Person person = Mockito.mock(Person.class);
    when(person.talk(Mockito.anyString())).thenReturn("Welcome back");
    assertEquals("Welcome back", person.talk("Hi"));
  }

  @Test
  void testChangePersonResponse_WithWhenAndThenReturn() {
    // When the talk(String input) method is called with "any()" String we return Good morning.
    when(person.talk("Good morning")).thenReturn("Good morning to you to");

    // Check that the return value is Good morning when we call talk() with "any String"
    assertEquals("Good morning to you to", person.talk("Good morning"));
  }

  @Test
  void testChangePersonResponse_ThenAnswer() {
    // Return a value based on the first parameter
    when(person.talk(any()))
        .thenAnswer(
            input ->
                "Good afternoon".equals(input.getArgument(0))
                    ? "Good afternoon to you to"
                    : "Something else");

    // Written out example of the lambda above
    when(person.talk(any()))
        .thenAnswer(
            input -> {
              // get the first argument passed to to person.talk(String input)
              // in this case we only have one parameter and it is on place 0
              var firstMethodArgument = input.getArgument(0);

              // Decide what to return
              if ("Good afternoon".equals(firstMethodArgument)) {
                return "Good afternoon to you to";
              } else {
                return "Something else";
              }
            });

    assertEquals("Good afternoon to you to", person.talk("Good afternoon"));
    assertEquals("Something else", person.talk("Good evening"));
  }
}
