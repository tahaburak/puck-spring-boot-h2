package com.puck.h2demo.dao.impl;

import com.puck.h2demo.dao.IH2Dao;
import com.puck.h2demo.dao.IUserDao;
import com.puck.h2demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/** Created by burak on 2019-05-19 */
@Component
public class UserDao implements IUserDao {

  private IH2Dao ih2Dao;

  @Autowired
  UserDao(IH2Dao ih2Dao) {
    this.ih2Dao = ih2Dao;
  }

  @Override
  public List<User> getUsers() {
    // language=H2
    String sql = "SELECT * FROM USERS";
    return ih2Dao.queryList(sql);
  }
}
