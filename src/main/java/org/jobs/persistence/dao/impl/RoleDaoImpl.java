/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobs.persistence.dao.impl;

import java.util.List;

import org.jobs.persistence.bean.Role;
import org.jobs.persistence.dao.RoleDao;

public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao {

	public RoleDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAll() {
		return getHibernateTemplate().find("from Role");
	}

	@Override
	public Role get(Long id) {
		return get(Role.class, id);
	}

}
