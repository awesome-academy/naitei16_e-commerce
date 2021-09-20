package com.javanaitei.phoneshop.service.impl;

import com.javanaitei.phoneshop.dao.CategoryDAO;
import com.javanaitei.phoneshop.dao.ProductDAO;
import com.javanaitei.phoneshop.dao.impl.ProductDAOImpl;
import com.javanaitei.phoneshop.entity.Product;
import com.javanaitei.phoneshop.model.CategoryModel;
import com.javanaitei.phoneshop.model.ProductModel;
import com.javanaitei.phoneshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional(readOnly = true)
    public ProductModel findProduct(Long id) {
        logger.info("Checking the tour in the database");
        try {
            Product product = productDAO.find(id);
            ProductModel productModel = null;
            if (product != null) {
                productModel = new ProductModel();
                BeanUtils.copyProperties(product, productModel);
                CategoryModel categoryModel = new CategoryModel();
                BeanUtils.copyProperties(product.getCategory(), categoryModel);
                productModel.setCategory(categoryModel);
            }
            return productModel;
        } catch (Exception e) {
            logger.error("An error occurred while fetching the tour details from the database", e);
            return null;
        }
    }

    @Override
    @Transactional
    public ProductModel addProduct(ProductModel productModel) throws Exception {
        logger.info("Adding the micropost in the database");
        try {
            Product product = new Product();
            product.setName(productModel.getName());
            product.setDescription(productModel.getDescription());
            product.setCategory(categoryDAO.find(productModel.getCategory().getId()));
            product.setPrice(productModel.getPrice());
            product.getSale(productModel.getSale());
            product.setImage(productModel.getImage());
            product.setImages(productModel.getImages());
            product.setConsists(productModel.getConsists());
            product.setAmount(productModel.getAmount());
            product.setBrand(productModel.getBrand());
            product = productDAO.makePersistent(product);
            productModel = new ProductModel();
            BeanUtils.copyProperties(product, productModel);
            return productModel;
        } catch (Exception e) {
            logger.error("An error occurred while adding the micropost details to the database", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public ProductModel editProduct(ProductModel productModel) throws Exception {
        logger.info("Updating the product in the database");
        try {
            Product product = productDAO.find(productModel.getId(), true);
            if (StringUtils.hasText(productModel.getDescription())) {
                product.setDescription(productModel.getDescription());
            }
            if (StringUtils.hasText(productModel.getName())) {
                product.setName(productModel.getName());
            }
            if (productModel.getCategory().getId() != null){
                product.setCategory(categoryDAO.find(productModel.getCategory().getId()));
            }
//            if (productModel.getExpectedDurationMax() != null){
//                product.setExpectedDurationMax(productModel.getExpectedDurationMax());
//            }
            productDAO.makePersistent(product);
            return productModel;
        } catch (Exception e) {
            logger.error("An error occurred while updating the tour details to the database", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteProduct(ProductModel productModel) throws Exception {
        logger.info("Deleting the product in the database");
        try {
            Product product = productDAO.find(productModel.getId(), true);
            productDAO.makeTransient(product);
            return true;
        } catch (Exception e) {
            logger.error("An error occurred while deleting the tour details to the database", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductModel> findAll(ProductModel productModel) {
        logger.info("Fetching all tours in the database");
        List<ProductModel> productModels = new ArrayList<ProductModel>();
        try {
            Product condition = new Product();
            condition.setCategory(categoryDAO.find(productModel.getCategory().getId()));
            List<Product> products = productDAO.findByExample(condition);
            for (Product product : products) {
                ProductModel model = new ProductModel();
                BeanUtils.copyProperties(product, model);
                productModels.add(model);
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching all tours from the database", e);
        }
        return productModels;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductModel> findAll() {
        logger.info("Fetching all order in the database");
        List<ProductModel> productModels = new ArrayList<ProductModel>();
        try {
            List<Product> products = productDAO.findAll();
            for (Product product : products) {
                ProductModel productModel = new ProductModel();
                BeanUtils.copyProperties(product, productModel);
                productModels.add(productModel);
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching all tours from the database", e);
        }
        return productModels;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductModel> paginate(ProductModel productModel) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public int count(ProductModel productModel) {
        return 0;
    }

    public void setProductDAO(ProductDAOImpl productDAO) {
    }
}
