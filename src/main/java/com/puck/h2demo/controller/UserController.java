package com.puck.h2demo.controller;

import com.puck.h2demo.model.User;
import com.puck.h2demo.service.IUserService;
import com.puck.h2demo.util.Constants;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Created by burak on 2019-05-19 */
@RestController
@RequestMapping(Constants.CONTROLLER_PREFIX)
@Api(value = Constants.CONTROLLER_API_VALUE_USER)
@Slf4j
public class UserController {

  private final IUserService userService;

  @Autowired
  UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_GET_DUMMY_USER)
  @ResponseBody
  public User getDummyUser() {
    return userService.getDummyUser();
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_GENERATE_DUMMY_USER)
  @ResponseBody
  public User generateDummyUser() {
    return userService.generateDummyUser();
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_USERS_BASE)
  @ResponseBody
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_GENERATE_DUMMY_USER_LIST)
  @ResponseBody
  public List<User> generateDummyUserList(@PathVariable int number) {
    return userService.generateDummyUsers(number);
  }
}
