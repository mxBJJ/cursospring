package com.example.cursospring.resources;

import com.example.cursospring.domain.Category;
import com.example.cursospring.dto.CategoryDTO;
import com.example.cursospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoryDTO>> getCategories(
           @RequestParam(value = "page", defaultValue = "0") Integer page,
           @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
           @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ){

        Page<Category> categories = categoryService.findPage(page,linesPerPage,orderBy,direction);
        Page<CategoryDTO> categoryDTOS = categories.map(obj -> new CategoryDTO(obj));
        return ResponseEntity.ok().body(categoryDTOS);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.fromDto(categoryDTO);
        category = categoryService.insert(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCategory(@PathVariable Integer id
            , @RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.fromDto(categoryDTO);
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
