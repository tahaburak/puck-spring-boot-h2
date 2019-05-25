package com.puck.h2demo.service;

/** Created by burak on 2019-05-19 */
public interface IH2Service {
  void createUsersTable();

  void dropUsersTable();

  void insertUsersTable(int num);
}
