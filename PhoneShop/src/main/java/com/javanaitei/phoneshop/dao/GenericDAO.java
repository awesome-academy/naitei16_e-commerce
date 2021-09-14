package com.javanaitei.phoneshop.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.data.domain.Page;

import com.javanaitei.phoneshop.util.SearchQueryTemplate;

/**
 * @author ducda referenced from CaveatEmptor project tm JBoss Hibernate version
 */
public interface GenericDAO<E, Id extends Serializable> {

    E find(Id id) throws Exception;

    E find(Id id, boolean lock) throws Exception;

    List<E> findAll() throws Exception;

    List<E> findByExample(E exampleInstance) throws Exception;

    List<E> findByExample(E exampleInstance, String[] excludeProperty) throws Exception;

    boolean checkExisted(Long id, String field, String value, String column, String table);

    int count(E exampleInstance, String[] excludeProperty, boolean isLike) throws Exception;

    int count() throws Exception;

    int count(Criterion... criterion) throws Exception;

    E makePersistent(E entity) throws Exception;

    void makeTransient(E entity) throws Exception;

    List<E> findByCriteria(Criterion... criterion) throws Exception;

    Timestamp getSystemTimestamp() throws Exception;

    Page<E> find(final SearchQueryTemplate searchQueryTemplate) throws Exception;

}
