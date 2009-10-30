package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.Task;

//@Transactional(readOnly=false)
public interface TaskDao extends Dao<Task> {

    Task get(long taskId);

    List<Task> getTasksByProject(Project project);

}
