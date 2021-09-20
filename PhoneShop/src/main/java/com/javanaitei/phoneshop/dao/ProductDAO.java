package com.javanaitei.phoneshop.dao;

import com.javanaitei.phoneshop.entity.Product;
import com.javanaitei.phoneshop.model.ProductModel;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ProductDAO extends GenericDAO<Product, Long>{
    public Page<Product> paginate(ProductModel productModel, String query, Map<String, Object> params);
}
