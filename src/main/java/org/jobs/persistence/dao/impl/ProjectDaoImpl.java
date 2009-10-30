/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobs.persistence.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.jobs.persistence.bean.Project;
import org.jobs.persistence.bean.User;
import org.jobs.persistence.dao.ProjectDao;

/**
 * 
 * @author vit
 */
public class ProjectDaoImpl extends DaoImpl<Project> implements ProjectDao {

    public ProjectDaoImpl() {
    }

    @Override
    public Project get(Long id) {
        return get(Project.class, id);
    }

    @Override
    public List<Project> getProjectByUser(User user) {
        Project project = new Project();
        project.getUser().add(user);
        DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
        criteria.add(Example.create(project));
        return getHibernateTemplate().findByCriteria(criteria);
    }
}
