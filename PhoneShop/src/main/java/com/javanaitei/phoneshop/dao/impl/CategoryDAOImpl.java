package com.javanaitei.phoneshop.dao.impl;

import com.javanaitei.phoneshop.dao.CategoryDAO;
import com.javanaitei.phoneshop.dao.GenericDAO;
import com.javanaitei.phoneshop.entity.Category;
import com.javanaitei.phoneshop.entity.Product;
import com.javanaitei.phoneshop.model.CategoryModel;
import com.javanaitei.phoneshop.util.SearchQueryTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Map;

public class CategoryDAOImpl extends GenericDAOImpl<Category, Long> implements CategoryDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    public Page<Category> paginate(CategoryModel categoryModel, String query, Map<String, Object> params) {
        String sql = query;
        String countSql = "SELECT COUNT(*) "+query;
        SearchQueryTemplate searchQueryTemplate = new SearchQueryTemplate(sql, countSql, categoryModel.getPageable());
        searchQueryTemplate.addParameters(params);
        searchQueryTemplate.addOrder(Sort.Direction.DESC, "createTime");
        return paginate(searchQueryTemplate);
    }
}
