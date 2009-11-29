package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.User;
import org.jobs.persistence.dao.impl.DaoImpl.Sort;

public interface UserDao extends Dao<User> {

	List<User> getAll();

	User findUserByLogin(String login);

	User get(Long id);

	List<User> getAllBySort(String sort, Sort s);
}