package com.example.cursospring.resources;

import com.example.cursospring.domain.Category;
import com.example.cursospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/categorias")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){

        Category category = categoryService.findCategoriesById(id);
        return ResponseEntity.ok().body(category);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories(){

        List<Category> categories = categoryService.findCategories();
        return ResponseEntity.ok().body(categories);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Category category){
        Category obj = categoryService.insert(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCategory(@PathVariable Integer id
            , @RequestBody Category category){
        category.setId(id);
        categoryService.update(category);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
