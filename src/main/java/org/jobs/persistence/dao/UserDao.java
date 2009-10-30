package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.User;

//@Transactional(readOnly=false)
public interface UserDao extends Dao<User> {

	public List<User> getAll();

	public User findUserByLogin(String login);

        User get(Long id);
}