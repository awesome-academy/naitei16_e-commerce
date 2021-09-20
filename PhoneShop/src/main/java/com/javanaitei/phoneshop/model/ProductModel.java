package com.javanaitei.phoneshop.model;

import com.javanaitei.phoneshop.entity.Brand;
import com.javanaitei.phoneshop.entity.Category;
import com.javanaitei.phoneshop.entity.Reviews;
import com.javanaitei.phoneshop.entity.Specifications;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel extends BaseModel{
    private Long id;
    private String name;
    private float price;
    private float sale;
    private String image;
    private String images;
    private String consists;
    private String description;
    private Integer amount;
    private CategoryModel category;
    private Brand brand;
    private List<Specifications> specifications = new ArrayList<>();
    private List<Reviews> reviews = new ArrayList<>();

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public String getConsists() {
        return consists;
    }

    public void setConsists(String consists) {
        this.consists = consists;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Specifications> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specifications> specifications) {
        this.specifications = specifications;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
}
