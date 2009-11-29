/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobs.persistence.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jobs.persistence.bean.User;
import org.jobs.persistence.dao.UserDao;

public class UserDaoImpl extends DaoImpl<User> implements UserDao {

	public UserDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return getHibernateTemplate().find("from User");
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByLogin(String login) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", login));
		List<User> users = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public User get(Long id) {
		return get(User.class, id);
	}

	@Override
	public List<User> getAllBySort(String orderParam, Sort s) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		if (orderParam != null && Sort.ASC.equals(s)){
			criteria.addOrder(Order.asc(orderParam));
		}else if(orderParam != null && Sort.DESC.equals(s)){
			criteria.addOrder(Order.desc(orderParam));
		}
		List<User> users = getHibernateTemplate().findByCriteria(criteria);
		return users;
	}
}
