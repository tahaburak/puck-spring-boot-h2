package com.puck.h2demo.util;

/** Created by burak on 2019-05-19 */
public class Constants {
  private Constants() {
    //
  }

  public static final String CONTROLLER_PREFIX = "";

  public static final String CONTROLLER_API_VALUE_BASE = "Base Controller";
  public static final String CONTROLLER_API_VALUE_USER = "User Controller";
  public static final String CONTROLLER_API_VALUE_H2 = "H2 Controller";

  public static final String REQUEST_MAP_VALUE_PING = "/ping";

  public static final String REQUEST_MAP_VALUE_USERS_BASE = "/users";
  public static final String REQUEST_MAP_VALUE_GET_DUMMY_USER =
      REQUEST_MAP_VALUE_USERS_BASE + "/dummy";
  public static final String REQUEST_MAP_VALUE_GENERATE_DUMMY_USER =
      REQUEST_MAP_VALUE_USERS_BASE + "/new";
  public static final String REQUEST_MAP_VALUE_GENERATE_DUMMY_USER_LIST =
      REQUEST_MAP_VALUE_USERS_BASE + "/newList/{number}";

  private static final String REQUEST_MAP_VALUE_H2_BASE = "/h2";
  public static final String REQUEST_MAP_VALUE_CREATE_USERS_TABLE =
      REQUEST_MAP_VALUE_H2_BASE + "/create/users";
  public static final String REQUEST_MAP_VALUE_DROP_USERS_TABLE =
      REQUEST_MAP_VALUE_H2_BASE + "/drop/users";
  public static final String REQUEST_MAP_VALUE_INSERT_USERS_TABLE =
      REQUEST_MAP_VALUE_H2_BASE + "/insert/users/{number}";
  public static final String REQUEST_MAP_VALUE_REFRESH_USERS_TABLE =
      REQUEST_MAP_VALUE_H2_BASE + "/refresh/users";

  public static final Integer DEFAULT_DUMMY_USER_LIST_SIZE = 10;

  private static final String JSON_SERVER_BASE_URL = "http://localhost:3000";
  public static final String JSON_SERVER_USERS = JSON_SERVER_BASE_URL + "/users";
}
