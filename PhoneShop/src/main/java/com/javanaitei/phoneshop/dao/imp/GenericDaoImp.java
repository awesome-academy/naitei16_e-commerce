package com.javanaitei.phoneshop.dao.imp;

import com.javanaitei.phoneshop.dao.GenericDao;
import com.javanaitei.phoneshop.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDaoImp <E , Id extends Serializable> extends HibernateDaoSupport implements GenericDao<E, Id> {
    private static Logger log = LoggerFactory.getLogger(GenericDaoImp.class);

//    @Autowired
    public GenericDaoImp(SessionFactory sessionFactory, Class<E> persistentClass){
        super.setSessionFactory(sessionFactory);
        this.persistentClass = persistentClass;
    }

    private Class<E> persistentClass;

    public GenericDaoImp(Class<E> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public List<E> findAll() throws Exception {
        return findByCriteria();
    }

    public Class<E> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    public List<E> findByCriteria(Criterion... criterion) throws Exception {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        return (List<E>) getHibernateTemplate().findByCriteria(criteria);
    }
}
