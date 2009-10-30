package org.jobs.persistence.dao;


//@Transactional(readOnly = false)
public interface Dao<T> {

//        @Transactional(readOnly=false)
//   T get(Class<T> t, Long id);

//       @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    void create(T instance);

//        @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    void delete(T instance);

//	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    T update(T insance);
}
