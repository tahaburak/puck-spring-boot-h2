package com.puck.h2demo.service;

import com.puck.h2demo.model.User;

import java.util.List;

/** Created by burak on 2019-05-19 */
public interface IDummyService {
  User generateDummyUser();

  User getDummyUser();

  List<User> getDummyUserList();

  List<User> generateDummyUsers(int numberOfUsers);
}
