package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entites.Category;
import com.educandoweb.course.repositorys.CategoryRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryServices {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

    public Category insert(Category category) {

        return categoryRepository.save(category);
    }

    public void delete(Long id) {

        try {
            if(!categoryRepository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            } else {
                categoryRepository.deleteById(id);
            }            
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());            
        } 
    }
}

