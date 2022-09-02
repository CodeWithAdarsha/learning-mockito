package com.hubberspot.mockito.voiding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock IDatabase iDatabase;

  @InjectMocks UserService userService;

  @Captor private ArgumentCaptor<ActivityModel> argumentCaptor;

  @BeforeEach
  void logger() {
    System.out.println("Starting ...");
  }

  @Test
  void testUpdateNameUsingWithDoNothingVerify() {
    // If we just want to completely ignore the void method call, we can use doNothing().
    ActivityModel model = getActivityModel();
    Mockito.doNothing().when(iDatabase).updateUser(Mockito.any());
    userService.addUser(getActivityModel());
    Mockito.verify(iDatabase, Mockito.times(1)).updateUser(model);
  }

  private ActivityModel getActivityModel() {
    ActivityModel model = new ActivityModel("1", "Chess");
    return model;
  }

  @Test
  public void testUpdateNameUsingArgumentCaptor() {
    Mockito.doNothing().when(iDatabase).updateUser(argumentCaptor.capture());
    userService.addUser(getActivityModel());
    Assertions.assertEquals("1", argumentCaptor.getValue().getId());
  }

  @Test
  public void testUpdateNameUsingDoAnswer() {
    // If we do not want to call real method, however need to perform some runtime operation
    // doAnswer is used.
    Mockito.doAnswer(
            invocation -> {
              var model = (ActivityModel) invocation.getArgument(0);
              model.setName("Chess");
              model.setId("1");
              System.out.println(
                  "called for id: " + model.getId() + " and name: " + model.getName());

              Assertions.assertEquals("Chess", model.getName());
              Assertions.assertEquals("1", model.getId());

              return model;
            })
        .when(iDatabase)
        .updateUser(Mockito.any());

    userService.addUser(getActivityModel());
    Mockito.verify(iDatabase, Mockito.times(1)).updateUser(getActivityModel());
  }

  @Test
  public void testUpdateNameThrowExceptionWhenIdNull() {
    ActivityModel model = new ActivityModel(null, "Chess");
    assertThrows(RuntimeException.class, () -> userService.addUser(model));
    Mockito.verify(iDatabase, Mockito.never())
        .updateUser(Mockito.any()); // We never call repository when exeception calls
    Mockito.verifyNoMoreInteractions(Mockito.mock(UserService.class));
  }

  @Test
  @Disabled
  public void testUpdateNameCallRealRepositoryMethod() {
    // Sometimes it is necessary to call the real method from mocked object, in such case we need to
    // use doCallRealMethod(), because doNothig() is the default behavior.
    Mockito.doCallRealMethod().when(iDatabase).updateUser(Mockito.any());

    userService.addUser(getActivityModel());

    Mockito.verify(iDatabase, Mockito.times(1)).updateUser(getActivityModel());
  }
}
