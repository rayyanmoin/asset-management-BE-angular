package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.Categories;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.dto.CategoryAddDTO;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.repository.CategoriesRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    private  final CategoriesRepo categoriesRepo;

    public CategoriesService(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public List<Categories> getAllCategories() {

        return categoriesRepo.findAll();
    }

    public List<CategoryDropDownDTO> getAllCategoriesForDropDown() {
        List<Categories> categories = categoriesRepo.findAll();
        List<CategoryDropDownDTO> categoryDropDownDTOS = new ArrayList<>();
        for(Categories categories1 : categories) {
            CategoryDropDownDTO categoryDropDownDTO = new CategoryDropDownDTO();
            categoryDropDownDTO.setCategoryId(categories1.getCategoryId());
            categoryDropDownDTO.setCategoryName(categories1.getCategoryName());
            categoryDropDownDTOS.add(categoryDropDownDTO);
        }
        return categoryDropDownDTOS;
    }

    public String addCategory(@RequestBody CategoryAddDTO categoryAddDTO) {
        Categories categories = new Categories();
        categories.setCategoryName(categoryAddDTO.getCategoryName());
        categories.setCategoryDescription(categoryAddDTO.getCategoryDescription());
        categories.setCategoryCode(categoryAddDTO.getCategoryCode());
        categoriesRepo.save(categories);
        return "Category saved successfully!";
    }


    public String updateCategory(CategoryAddDTO categoryAddDTO) {
        Optional<Categories> categories = categoriesRepo.findById(categoryAddDTO.getCategoryId());
        if (categories.isPresent()) {
            Categories category = categories.get();

            category.setCategoryName(categoryAddDTO.getCategoryName());
            category.setCategoryDescription(categoryAddDTO.getCategoryDescription());
            category.setCategoryCode(categoryAddDTO.getCategoryCode());

            categoriesRepo.save(category);
            return "Category updated successfully!";
        }
        else {
            return "Category with Id Not found";
        }
    }

}