package org.jobs.ws.bean;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.Role;
import org.jobs.persistence.bean.User;
import org.jobs.persistence.dao.GroupDao;
import org.jobs.persistence.dao.RoleDao;
import org.jobs.persistence.dao.UserDao;

@WebService(serviceName = "UserManager", endpointInterface = "org.jobs.ws.bean.UsersManager")
@SuppressWarnings("unused")
public class UsersManagerBean implements UsersManager {

	private static Logger log = Logger.getLogger(UsersManagerBean.class);

	private UserDao userDao;
	private RoleDao roleDao;
	private GroupDao groupDao;

	@WebMethod(exclude = true)
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@WebMethod(exclude = true)
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@WebMethod(exclude = true)
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UsersManagerBean() {
	}

	@WebMethod
	public User getUser(long id) {
		return userDao.get(id);
	}

	@WebMethod
	public List<User> getUserAll() {
		return userDao.getAll();
	}

	@WebMethod
	public User createUser(User user) {
		userDao.create(user);
		return user;
	}

	@Override
	@WebMethod
	public User getLogin(String login, String pass) {
		User user = userDao.findUserByLogin(login);
		if (user != null && user.getPassword().equals(pass)) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	@WebMethod
	public User updateUser(User user) {
		return userDao.update(user);
	}

	@Override
	@WebMethod
	public User getUserByLogin(String login) {
		return userDao.findUserByLogin(login);
	}

	@Override
	@WebMethod
	public Long createRole(Role role) {
		roleDao.create(role);
	    return role.getId();
    }
}
