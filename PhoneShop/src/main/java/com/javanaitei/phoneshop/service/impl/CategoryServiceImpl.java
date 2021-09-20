package com.javanaitei.phoneshop.service.impl;

import com.javanaitei.phoneshop.dao.CategoryDAO;
import com.javanaitei.phoneshop.entity.Category;
import com.javanaitei.phoneshop.model.CategoryModel;
import com.javanaitei.phoneshop.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public CategoryModel findCategory(Long id) {
        return null;
    }

    @Override
    public CategoryModel addCategory(CategoryModel categoryModel) throws Exception {
        return null;
    }

    @Override
    public CategoryModel editCategory(CategoryModel categoryModel) throws Exception {
        return null;
    }

    @Override
    public boolean deleteCategory(CategoryModel categoryModel) throws Exception {
        return false;
    }

    @Override
    public List<CategoryModel> findAll(){
        logger.info("Fetching all microposts in the database");
        List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
        try {
            List<Category> categories = categoryDAO.findAll();
            for (Category category : categories) {
                CategoryModel categoryModel = new CategoryModel();
                BeanUtils.copyProperties(category, categoryModel);
                categoryModels.add(categoryModel);
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching all categories from the database", e);
        }
            return categoryModels;
    }

    @Override
    public Page<CategoryModel> paginate(CategoryModel categoryModel) {
        return null;
    }

    @Override
    public int count(CategoryModel categoryModel) {
        return 0;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}
