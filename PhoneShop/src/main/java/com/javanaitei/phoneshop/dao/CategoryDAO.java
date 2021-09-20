package com.javanaitei.phoneshop.dao;

import com.javanaitei.phoneshop.entity.Category;
import com.javanaitei.phoneshop.model.CategoryModel;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface CategoryDAO extends GenericDAO<Category, Long>{
    public Page<Category> paginate(CategoryModel categoryModel, String query, Map<String, Object> params);
}
