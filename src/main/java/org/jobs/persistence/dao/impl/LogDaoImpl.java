package org.jobs.persistence.dao.impl;

import java.util.List;
import org.jobs.persistence.bean.Log;
import org.jobs.persistence.bean.Task;
import org.jobs.persistence.dao.LogDao;

public class LogDaoImpl extends DaoImpl<Log> implements LogDao {

    public LogDaoImpl() {
    }

    @Override
    public Log get(Long logId) {
        return get(Log.class, logId);
    }

    @Override
    public List<Log> getLogsByTask(Task task) {
        return getHibernateTemplate().find("from Log ls where ls.task = ?", task);
    }
}
