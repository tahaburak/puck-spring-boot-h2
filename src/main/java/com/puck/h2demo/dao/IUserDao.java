package com.puck.h2demo.dao;

import com.puck.h2demo.model.User;

import java.util.List;

/** Created by burak on 2019-05-19 */
public interface IUserDao {
  List<User> getUsers();
}
