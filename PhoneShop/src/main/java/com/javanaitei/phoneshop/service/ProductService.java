package com.javanaitei.phoneshop.service;

import com.javanaitei.phoneshop.model.BrandModel;
import com.javanaitei.phoneshop.model.ProductModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public ProductModel findProduct(Long id);

    public ProductModel addProduct(ProductModel productModel) throws Exception;

    public ProductModel editProduct(ProductModel productModel) throws Exception;

    public boolean deleteProduct(ProductModel productModel) throws Exception;

    public List<ProductModel> findAll(ProductModel productModel);

    public List<ProductModel> findAll();

    public Page<ProductModel> paginate(ProductModel productModel);

    public int count(ProductModel productModel);
}
