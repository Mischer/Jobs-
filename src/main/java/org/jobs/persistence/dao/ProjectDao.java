package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.User;

//@Transactional(readOnly=false)
public interface ProjectDao extends Dao<Project> {

    Project get(Long id);

    List<Project> getProjectByUser(User user);
}
