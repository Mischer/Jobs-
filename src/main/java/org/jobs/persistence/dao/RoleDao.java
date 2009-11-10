package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.Role;

public interface RoleDao extends Dao<Role> {

	List<Role> getAll();

	Role get(Long id);
}
