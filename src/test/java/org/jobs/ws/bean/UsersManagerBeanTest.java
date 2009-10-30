package org.jobs.ws.bean;

import java.util.List;

import org.jobs.JobsTest;
import org.jobs.persistence.bean.Group;
import org.jobs.persistence.bean.User;
import org.junit.Assert;
import org.junit.BeforeClass;
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
    public void testCreateGroup() {
        Group group = new Group();
        group.setName("Test Group");
        idGroup = usersManager.createGroup(group).getId();
        Assert.assertNotNull(idGroup);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setLogin("test");
        user.setPass("test");
        user.setName("UserName");
        user.setGroup(usersManager.getGroup(idGroup));
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

    @Test
    public void testGetGroup() {
        Group group = usersManager.getGroup(idGroup);
        Assert.assertNotNull(group);
    }

    @Test
    public void testGetUserAll() {
        List<User> list = usersManager.getUserAll();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testGetGroupAll() {
        List<Group> list = usersManager.getGroupAll();
        Assert.assertFalse(list.isEmpty());
    }
}
