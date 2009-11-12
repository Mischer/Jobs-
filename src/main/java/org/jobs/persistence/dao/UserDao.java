package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.User;

public interface UserDao extends Dao<User> {

	List<User> getAll();

	User findUserByLogin(String login);

	User get(Long id);
}