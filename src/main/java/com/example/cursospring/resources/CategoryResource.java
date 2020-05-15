package com.example.cursospring.resources;

import com.example.cursospring.domain.Category;
import com.example.cursospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/categorias")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id){

        Category category = categoryService.findCategoriesById(id);

        return ResponseEntity.ok().body(category);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCategories(){

        List<Category> categories = categoryService.findCategories();

        return ResponseEntity.ok().body(categories);
    }
}
