package org.jobs.persistence.dao;

import java.util.List;
import org.jobs.persistence.bean.Log;
import org.jobs.persistence.bean.Task;

//@Transactional(readOnly = false)
public interface LogDao extends Dao<Log> {

    Log get(Long logId);

    List<Log> getLogsByTask(Task task);
}
