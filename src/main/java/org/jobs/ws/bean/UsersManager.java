package org.jobs.ws.bean;

import java.util.List;

import javax.jws.WebService;

import org.jobs.persistence.bean.Group;
import org.jobs.persistence.bean.Role;
import org.jobs.persistence.bean.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@WebService
@Transactional(readOnly = true)
public interface UsersManager {

	User getUser(long id);

	List<User> getUserAll();

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	User createUser(User user);

	User getLogin(String login, String pass);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	User updateUser(User user);

	User getUserByLogin(String login);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Long createRole(Role role);
	
	List<Group> getGroupAll();

	List<Role> getRoles();

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	void deleteUser(Long userId) throws Exception;
}
