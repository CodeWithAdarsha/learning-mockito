package com.hubberspot.mockito.voiding;

public class UserService {
  private IDatabase databaseImpl;

  public void addUser(ActivityModel model) {
    System.out.println("calling add user");
    if (model.getId() == null) {
      throw new RuntimeException("age too low");
    }
    databaseImpl.updateUser(model);
  }
}
