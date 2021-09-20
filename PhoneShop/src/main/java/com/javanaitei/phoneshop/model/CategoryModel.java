package com.javanaitei.phoneshop.model;

import com.javanaitei.phoneshop.entity.Category;
import com.javanaitei.phoneshop.entity.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryModel extends BaseModel{
    private Long id;
    private String name;
    private Category parentCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCategoryChilds(List<Category> categoryChilds) {
        this.categoryChilds = categoryChilds;
    }

    private List<Product> products = new ArrayList<>();
    private List<Category> categoryChilds = new ArrayList<>();
    public List<Category> getCategoryChilds() {
        return categoryChilds;
    }
}
