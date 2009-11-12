/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobs.persistence.dao.impl;

import java.util.List;

import org.jobs.persistence.bean.Group;
import org.jobs.persistence.dao.GroupDao;

public class GroupDaoImpl extends DaoImpl<Group> implements GroupDao {

	public GroupDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAll() {
		return getHibernateTemplate().find("from Group");
	}

	@Override
	public Group get(Long id) {
		return get(Group.class, id);
	}
}
