package com.example.cursospring.services;

import com.example.cursospring.domain.Category;
import com.example.cursospring.repository.CategoryRepository;
import com.example.cursospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findCategoriesById(int id){

        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow( () -> new ObjectNotFoundException("Object not found for id: " + id
                + ".Type: " + Category.class.getName()));
    }

    public List<Category> findCategories(){

        List<Category> categories = categoryRepository.findAll();
        return categories;

    }
}
