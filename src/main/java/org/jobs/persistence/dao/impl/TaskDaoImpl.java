/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobs.persistence.dao.impl;

import java.util.List;

import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.Task;
import org.jobs.persistence.dao.TaskDao;

/**
 * 
 * @author vit
 */
public class TaskDaoImpl extends DaoImpl<Task> implements TaskDao {

    public TaskDaoImpl() {
    }

    @Override
    public Task get(long taskId) {
        return get(Task.class, taskId);
    }

    @Override
    public List<Task> getTasksByProject(Project project) {
        return getHibernateTemplate().find("from Task ts where ts.project = ?", project);
    }
}
