package com.example.cursospring.services;

import com.example.cursospring.domain.Category;
import com.example.cursospring.dto.CategoryDTO;
import com.example.cursospring.repository.CategoryRepository;
import com.example.cursospring.services.exception.DataIntegrityViolationException;
import com.example.cursospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findCategoriesById(Integer id){

        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow( () -> new ObjectNotFoundException("Object not found for id: " + id
                + ".Type: " + Category.class.getName()));
    }

    public List<Category> findCategories(){

        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category update(Category category){
        return categoryRepository.save(category);
    }

    public Category insert(Category category) {
        category.setId(null);
        return categoryRepository.save(category);
    }

    public void delete(Integer id){
        findCategoriesById(id);

        try{
            categoryRepository.deleteById(id);
        }catch(DataIntegrityViolationException exception){
            throw new DataIntegrityViolationException("Can't delete category, because it has products associated.");
        }
    }

    public Page<Category> findPage(
            Integer page, Integer linesPerPage,
            String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return categoryRepository.findAll(pageRequest);

    }

    public Category fromDto(CategoryDTO categoryDTO){
        return new Category(categoryDTO.getId(), categoryDTO.getName());
    }
}
