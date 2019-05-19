package com.puck.h2demo.service;

import com.puck.h2demo.model.User;

import java.util.List;

/**
 * Created by burak on 2019-05-19
 */
public interface IUserService {
	User getDummyUser();

	User generateDummyUser();

	List<User> getUsers();

	List<User> generateDummyUsers(int numberOfUsers);
}
