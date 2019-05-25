package com.puck.h2demo.controller;

import com.puck.h2demo.service.IH2Service;
import com.puck.h2demo.util.Constants;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** Created by burak on 2019-05-19 */
@RestController
@RequestMapping(Constants.CONTROLLER_PREFIX)
@Api(value = Constants.CONTROLLER_API_VALUE_H2)
@Slf4j
public class H2Controller {
  private final IH2Service ih2Service;

  @Autowired
  H2Controller(IH2Service ih2Service) {
    this.ih2Service = ih2Service;
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_CREATE_USERS_TABLE)
  @ResponseBody
  public void createUsersTable() {
    ih2Service.createUsersTable();
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_DROP_USERS_TABLE)
  @ResponseBody
  public void dropUsersTable() {
    ih2Service.dropUsersTable();
  }

  @GetMapping(value = Constants.REQUEST_MAP_VALUE_INSERT_USERS_TABLE)
  @ResponseBody
  public void insertUsersTable(@PathVariable int number) {
    ih2Service.insertUsersTable(number);
  }

  @PostMapping(value = Constants.REQUEST_MAP_VALUE_REFRESH_USERS_TABLE)
  @ResponseBody
  public void refreshUsersTable() {
    ih2Service.dropUsersTable();
    ih2Service.createUsersTable();
    ih2Service.insertUsersTable(0);
  }
}
