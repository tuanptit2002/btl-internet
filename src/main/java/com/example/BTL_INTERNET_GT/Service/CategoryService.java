package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.CategoryDTO;
import com.example.BTL_INTERNET_GT.Entity.Category;
import com.example.BTL_INTERNET_GT.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;


    public void create(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setDescribeItem(categoryDTO.getDescribe());
        category.setTotalItem(categoryDTO.getTotal());
        categoryRepo.save(category);
    }

    @Transactional
    public void update(CategoryDTO categoryDTO) {

        Category category = categoryRepo.findById(categoryDTO.getId()).orElseThrow((() -> new RuntimeException("Category Valid")));
                category.setTotalItem(categoryDTO.getTotal());
                categoryDTO.setDescribe(categoryDTO.getDescribe());
                categoryRepo.save(category);
    }
    public void delete(Long id){
        categoryRepo.deleteById(id);
    }

}
