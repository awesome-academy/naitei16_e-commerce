package com.javanaitei.phoneshop.dao.impl;

import com.javanaitei.phoneshop.dao.ProductDAO;
import com.javanaitei.phoneshop.entity.Product;
import com.javanaitei.phoneshop.model.ProductModel;
import com.javanaitei.phoneshop.util.SearchQueryTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Map;

public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public ProductDAOImpl() {
        super(Product.class);
    }

    @Override
    public Page<Product> paginate(ProductModel productModel, String query, Map<String, Object> params) {
        String sql = query;
        String countSql = "SELECT COUNT(*) " + sql;
        SearchQueryTemplate searchQueryTemplate = new SearchQueryTemplate(sql, countSql, productModel.getPageable());
        searchQueryTemplate.addParameters(params);
        searchQueryTemplate.addOrder(Sort.Direction.DESC, "createTime");
        return paginate(searchQueryTemplate);
    }
}
