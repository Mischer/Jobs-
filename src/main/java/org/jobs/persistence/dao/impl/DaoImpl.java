package org.jobs.persistence.dao.impl;

import org.jobs.persistence.dao.Dao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class DaoImpl<T> extends HibernateDaoSupport implements Dao<T> {

    public DaoImpl() {
    }

    protected T get(Class<T> t, Long id) {
        return (T) getHibernateTemplate().get(t, id);
    }

    public void create(T instance) {
        getHibernateTemplate().persist(instance);
    }

    public void delete(T instance) {
        getHibernateTemplate().delete(instance);
    }

    public T update(T insance) {
        return (T) getHibernateTemplate().merge(insance);
    }
    
    public enum Sort{
    	ASC,
    	DESC
    }
}
