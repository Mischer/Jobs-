package org.jobs.ws.bean;

import java.util.List;

import org.jobs.JobsTest;
import org.jobs.persistence.bean.Role;
import org.jobs.persistence.bean.RoleConstant;
import org.jobs.persistence.bean.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class UsersManagerBeanTest {

	private static UsersManager usersManager = null;
	private static Long idGroup = null;
	private static Long idUser = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usersManager = (UsersManager) JobsTest.getContext().getBean("usersManager");
	}

	@Test
	public void testCreateRole() {
		Role role = new Role();
		role.setAuthority(RoleConstant.ROLE_ADMINISTRATOR);
		Long id = usersManager.createRole(role);
		Assert.assertNotNull(id);
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		user.setAccountNonExpired(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.getRoles().add(new Role(RoleConstant.ROLE_USER));
		idUser = usersManager.createUser(user).getId();
		Assert.assertNotNull(idUser);
	}

	@Test
	public void testGetUser() {
		User user = usersManager.getUser(idUser);
		Assert.assertNotNull(user);
	}

	@Test
	public void testGetUserByLogin() {
		User user = usersManager.getUserByLogin("test");
		Assert.assertNotNull(user);
	}

	@Ignore
	public void testGetGroup() {
		// Group group = usersManager.getGroup(idGroup);
		// Assert.assertNotNull(group);
	}

	@Test
	public void testGetUserAll() {
		List<User> list = usersManager.getUserAll();
		Assert.assertFalse(list.isEmpty());
	}

	@Ignore
	public void testGetGroupAll() {
		// List<Group> list = usersManager.getGroupAll();
		// Assert.assertFalse(list.isEmpty());
	}
}
