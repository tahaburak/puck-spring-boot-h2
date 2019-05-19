package com.puck.h2demo.service.impl;

import com.github.javafaker.Faker;
import com.puck.h2demo.model.User;
import com.puck.h2demo.service.IDummyService;
import com.puck.h2demo.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by burak on 2019-05-19
 */
@Service
public class DummyService implements IDummyService {

	private User dummyUser;
	private List<User> dummyUsers;
	private Faker faker;

	@PostConstruct
	private void fill() {
		this.dummyUser = generateDummyUser();
		this.dummyUsers = generateDummyUsers(Constants.DEFAULT_DUMMY_USER_LIST_SIZE);
		this.faker = generateFaker();
	}

	private Faker generateFaker() {
		return new Faker(new Locale("en"));
	}

	@Override
	public User generateDummyUser() {
		faker = generateFaker();
		return generateDummyUser(faker);
	}

	private User generateDummyUser(Faker faker) {
		return User.builder()
				.name(faker.name().firstName())
				.surname(faker.name().lastName())
				.birthDate(faker.date().birthday())
				.build();
	}

	@Override
	public User getDummyUser() {
		return this.dummyUser;
	}

	@Override
	public List<User> getDummyUserList() {
		return this.dummyUsers;
	}

	@Override
	public List<User> generateDummyUsers(int numberOfUsers) {
		List<User> users = new ArrayList<>();
		int number = numberOfUsers > 0 ? numberOfUsers : Constants.DEFAULT_DUMMY_USER_LIST_SIZE;

		for (int i = 0; i < number; i++) {
			faker = generateFaker();
			users.add(generateDummyUser(faker));
		}
		return users;
	}
}
