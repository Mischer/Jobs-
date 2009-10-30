package org.jobs.ws.bean;

import java.util.List;

import javax.jws.WebService;

import org.jobs.persistence.bean.Group;
import org.jobs.persistence.bean.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@WebService
@Transactional(readOnly=true)
public interface UsersManager {

	User getUser(long id);

	List<User> getUserAll();

        @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	User createUser(User user);

	List<Group> getGroupAll();

	Group getGroup(long id);

        @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	Group createGroup(Group group);

	User getLogin(String login, String pass);

        @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	User updateUser(User user);

        User getUserByLogin(String login);
}
