package com.javanaitei.phoneshop.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E, Id extends Serializable>  {
    public List<E> findAll() throws Exception;
}
