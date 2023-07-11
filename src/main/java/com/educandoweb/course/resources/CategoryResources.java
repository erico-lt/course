package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entites.Category;
import com.educandoweb.course.services.CategoryServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {
    
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category category) {

        category = categoryServices.insert(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        categoryServices.delete(id);
        return ResponseEntity.ok().body("Delete completed");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id,@RequestBody Category category) {

        category = categoryServices.update(id, category);
        return ResponseEntity.ok().body(category);
    }
}
