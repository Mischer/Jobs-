package org.jobs.ws.bean;

import java.util.List;

import javax.jws.WebService;

import org.jobs.persistence.bean.Log;
import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.Task;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@WebService
@Transactional(readOnly = true)
@Deprecated
public interface ProjectsManager {

	List<Project> getProjetsByUserId(long userId);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Project creteProject(Project project);

	List<Task> getTasksByProjectId(long projectId);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Task createTask(Task task);

	List<Log> getLogsByTaskId(long taskId);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Log createLog(Log log);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Project assignProject(Long projectId, Long userId);

	Project getProjetc(Long projectId);

	Task getTask(Long taskId);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Task assignTask(Long id, Long id0);

	Log getLog(Long logId);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Log assignLog(Long id, Long id0);

}
