package com.puck.h2demo.service.impl;

import com.puck.h2demo.dao.IH2Dao;
import com.puck.h2demo.model.User;
import com.puck.h2demo.service.IH2Service;
import com.puck.h2demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by burak on 2019-05-19
 */
@Service
public class H2Service implements IH2Service {

	private IH2Dao ih2Dao;
	private IUserService userService;

	@Autowired
	H2Service(IH2Dao ih2Dao, IUserService userService) {
		this.ih2Dao = ih2Dao;
		this.userService = userService;
	}

	@Override
	public void createUsersTable() {
		// language=H2
		String sql =
				"CREATE TABLE IF NOT EXISTS USERS(\n"
						+ "ID NUMBER(20) PRIMARY KEY ,\n"
						+ "NAME VARCHAR2(50),\n"
						+ "SURNAME VARCHAR2(50),\n"
						+ "BIRTHDATE DATE\n"
						+ ");"
						+ "CREATE SEQUENCE IF NOT EXISTS SEQ_USERS";
		ih2Dao.executeSql(sql);
	}

	@Override
	public void dropUsersTable() {
		// language=H2
		String sql = "DROP TABLE IF EXISTS USERS;" + " DROP SEQUENCE IF EXISTS SEQ_USERS";
		ih2Dao.executeSql(sql);
	}

	@Override
	public void insertUsersTable(int num) {

		List<User> users = userService.generateDummyUsers(num);

		for (User user : users) {
			// language=H2
			String sql =
					"INSERT INTO USERS (ID, NAME , SURNAME , BIRTHDATE ) VALUES (SEQ_USERS.nextVal, ?,?,?); ";
			Object[] params = new Object[] { user.getName(), user.getSurname(), user.getBirthDate() };
			ih2Dao.update(sql, params);
		}
	}
}
