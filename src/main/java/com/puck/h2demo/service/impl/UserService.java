package com.puck.h2demo.service.impl;

import com.puck.h2demo.dao.IUserDao;
import com.puck.h2demo.exception.CustomException;
import com.puck.h2demo.model.User;
import com.puck.h2demo.restclient.JsonServerUserClient;
import com.puck.h2demo.service.IDummyService;
import com.puck.h2demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by burak on 2019-05-19
 */
@Service
public class UserService implements IUserService {

	private final IUserDao userDao;
	private final JsonServerUserClient jsonServerUserClient;
	private final IDummyService dummyService;

	@Autowired
	UserService(
			IUserDao userDao, JsonServerUserClient jsonServerUserClient, IDummyService dummyService) {
		this.userDao = userDao;
		this.jsonServerUserClient = jsonServerUserClient;
		this.dummyService = dummyService;
	}

	@Override
	public User getDummyUser() {
		return dummyService.getDummyUser();
	}

	@Override
	public User generateDummyUser() {
		return dummyService.generateDummyUser();
	}

	@Override
	public List<User> getUsers() {
		List<User> users;
		try {
			users = jsonServerUserClient.getUsers();
			if (CollectionUtils.isEmpty(users)) {
				throw new CustomException("");
			}
			//		users.stream().filter(user -> )
		} catch (Exception e) {
			try {
				users = userDao.getUsers();
			} catch (Exception ex) {
				users = dummyService.getDummyUserList();
			}
		}

		return users;
	}

	@Override
	public List<User> generateDummyUsers(int numberOfUsers) {
		return dummyService.generateDummyUsers(numberOfUsers);
	}
}
