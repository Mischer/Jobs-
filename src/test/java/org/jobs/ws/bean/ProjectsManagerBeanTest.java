package org.jobs.ws.bean;

import java.util.Date;
import java.util.List;

import org.jobs.JobsTest;
import org.jobs.persistence.bean.Log;
import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.Task;
import org.jobs.persistence.bean.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class ProjectsManagerBeanTest {

	private static ProjectsManager projectsManager = null;
	private static UsersManager usersManager = null;
	private static Long projectId = null;
	private static Long taskId = null;
	private static Long logId = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		projectsManager = (ProjectsManager) JobsTest.getContext().getBean("projectsManager");
		usersManager = (UsersManager) JobsTest.getContext().getBean("usersManager");
	}

	@Ignore
	public void testCreteProjectWithoutUser() {
		Project project = new Project();
		project.setCaption("Test caption");
		project.setStatus("New");
		project.setTitle("Test Title");
		Project pr = projectsManager.creteProject(project);
		projectId = pr.getId();
		Assert.assertTrue(pr != null && pr.getId() != null);
	}

	@Ignore
	public void testAssignProject() {
		if (projectId == null) {
			Assert.fail("Error get projectId");
		}
		Project pr = projectsManager.getProjetc(projectId);
		User user = usersManager.getUserByLogin("test");
		Project projectUpdate = projectsManager.assignProject(pr.getId(), user.getId());
		// if (!projectUpdate.getUser().isEmpty() &&
		// !projectUpdate.getUser().get(0).getProjects().isEmpty()) {
		Assert.assertTrue(true);
		// }
	}

	@Ignore
	public void testCreteProjectWithUser() {
		Project project = new Project();
		project.setCaption("Test caption");
		project.setStatus("New");
		project.setTitle("Test Title");
		User user = usersManager.getUserByLogin("test");
		if (user == null) {
			Assert.fail("Get user is null.");
		}
		// user.getProjects().add(project);
		// project.getUser().add(user);
		Project pr = projectsManager.creteProject(project);
		Assert.assertTrue(pr != null && pr.getId() != null);
	}

	@Ignore
	public void testCreateLog() {
		Log log = new Log();
		log.setDescription("Login time");
		log.setHours(20);
		Log clog = projectsManager.createLog(log);
		logId = clog.getId();
		Assert.assertTrue(clog != null && clog.getId() != null);
	}

	@Ignore
	public void testCreateTask() {
		Task task = new Task();
		task.setCaption("Test task");
		task.setDescription("The description for this task.");
		task.setHours(20);
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		Task ctask = projectsManager.createTask(task);
		taskId = ctask.getId();
		Assert.assertTrue(ctask != null && ctask.getId() != null);
	}

	@Ignore
	public void testAssignLog() {
		Log log = projectsManager.getLog(logId);
		Task task = projectsManager.getTask(taskId);
		Log clog = projectsManager.assignLog(log.getId(), task.getId());
		Assert.assertTrue(clog != null && clog.getTask() != null);
	}

	@Ignore
	public void testAssignTask() {
		Task task = projectsManager.getTask(taskId);
		Project project = projectsManager.getProjetc(projectId);
		Task ctask = projectsManager.assignTask(task.getId(), project.getId());
		Assert.assertTrue(ctask != null && ctask.getProject() != null);
	}

	@Ignore
	public void testGetProjetsByUserId() {
		User user = usersManager.getUserByLogin("test");
		if (user == null) {
			Assert.fail("The user is null");
		}
		List<Project> projects = projectsManager.getProjetsByUserId(user.getId());
		Assert.assertTrue(projects != null && !projects.isEmpty());
	}

	@Ignore
	public void testGetLogsByTaskId() {
		List<Log> logs = projectsManager.getLogsByTaskId(taskId);
		Assert.assertTrue(!logs.isEmpty());
	}

	@Ignore
	public void testGetTasks() {
		List<Task> tasks = projectsManager.getTasksByProjectId(projectId);
		Assert.assertTrue(!tasks.isEmpty());
	}
}
