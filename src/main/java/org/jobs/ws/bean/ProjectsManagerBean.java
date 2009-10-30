package org.jobs.ws.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import org.apache.log4j.Logger;
import org.hibernate.mapping.Collection;
import org.jobs.persistence.bean.Log;
import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.Task;
import org.jobs.persistence.bean.User;
import org.jobs.persistence.dao.LogDao;
import org.jobs.persistence.dao.ProjectDao;
import org.jobs.persistence.dao.TaskDao;
import org.jobs.persistence.dao.UserDao;
import org.springframework.util.CollectionUtils;

@WebService(name = "ProjectsManager", serviceName = "ProjectsManager")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT)
@SuppressWarnings("unchecked")
public class ProjectsManagerBean implements ProjectsManager {

    private static Logger log = Logger.getLogger(ProjectsManagerBean.class);
    private LogDao logDao;
    private TaskDao taskDao;
    private ProjectDao projectDao;
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    @WebMethod
    public Log createLog(Log log) {
        logDao.create(log);
        return log;
    }

    @Override
    @WebMethod
    public Task createTask(Task task) {
        taskDao.create(task);
        return task;
    }

    @Override
    @WebMethod
    public Project creteProject(Project project) {
        projectDao.create(project);
        return project;
    }

    @Override
    @WebMethod
    public List<Log> getLogsByTaskId(long taskId) {
        Task task = taskDao.get(taskId);
        return logDao.getLogsByTask(task);
        //return (List<Log>) taskDao.get(taskId).getLog();
    }

    @Override
    @WebMethod
    public List<Project> getProjetsByUserId(long userId) {
        User user = userDao.get(userId);
        return projectDao.getProjectByUser(user);

    }
    
    @Override
    @WebMethod
    public List<Task> getTasksByProjectId(long projectId) {
        Project project = projectDao.get(projectId);
        return taskDao.getTasksByProject(project);
        //return projectDao.get(projectId).getTasks();
    }

    @Override
    @WebMethod
    public Project assignProject(Long projectId, Long userId) {
        Project project = projectDao.get(projectId);
        User user = userDao.get(userId);
        project.getUser().add(user);
        user.getProjects().add(project);
        if (log.isDebugEnabled()) {
            log.debug(String.format("Project with id = %s, asign with user id = %s.", projectId, userId));
        }
        return project;
    }

    @Override
    @WebMethod
    public Project getProjetc(Long projectId) {
        return projectDao.get(projectId);
    }

    @Override
    @WebMethod
    public Task getTask(Long taskId) {
        return taskDao.get(taskId);
    }

    @Override
    @WebMethod
    public Log getLog(Long logId) {
        return logDao.get(logId);
    }

    @Override
    @WebMethod
    public Task assignTask(Long taskId, Long projectId) {
        Task task = taskDao.get(taskId);
        Project project = projectDao.get(projectId);
        task.setProject(project);
        project.getTasks().add(task);
        if (log.isDebugEnabled()) {
            log.debug(String.format("Task with id = %s, asign with project id = %s.", taskId, projectId));
        }
        return task;
    }

    @Override
    @WebMethod
    public Log assignLog(Long logId, Long taskId) {
        Log log1 = logDao.get(logId);
        Task task = taskDao.get(taskId);
        log1.setTask(task);
        task.getLog().add(log1);
        if (log.isDebugEnabled()) {
            log.debug(String.format("Log with id = %s, asign with task id = %s.", logId, taskId));
        }
        return log1;
    }
}
