package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import com.telusko.assetmanagmentapplication.assetObjects.Categories;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.dto.CategoryAddDTO;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.service.AssetsService;
import com.telusko.assetmanagmentapplication.service.CategoriesService;
import com.telusko.assetmanagmentapplication.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public List<Categories> getAllCategories() {

        return categoriesService.getAllCategories();
    }

    @PostMapping("/categories/add")
    public String addCategory(@RequestBody CategoryAddDTO categoryAddDTO) {
        return categoriesService.addCategory(categoryAddDTO);
    }

    @GetMapping("/categories/list")
    public List<CategoryDropDownDTO> getAllCategoriesForDropDown() {
        return categoriesService.getAllCategoriesForDropDown();
    }

    @PutMapping("/categories/update")
    public String updateCategory(@RequestBody CategoryAddDTO categoryAddDTO) {
        return categoriesService.updateCategory(categoryAddDTO);
    }


}