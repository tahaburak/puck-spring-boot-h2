package com.puck.h2demo.dao.impl;

import com.puck.h2demo.dao.IH2Dao;
import com.puck.h2demo.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burak on 2019-05-19
 */
@Service
public class H2Dao extends NamedParameterJdbcDaoSupport implements IH2Dao {

	public H2Dao(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void executeSql(String sql) {
		if (getJdbcTemplate() != null) {
			getJdbcTemplate().execute(sql);
		}
	}

	@Override
	public void update(String sql, Object[] params) {
		if (getJdbcTemplate() != null) {
			getJdbcTemplate().update(sql, params);
		}
	}

	@Override
	public List<User> queryList(String sql) {
		if (getJdbcTemplate() != null) {
			return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(User.class));
		} else {
			return new ArrayList<>();
		}
	}
}
