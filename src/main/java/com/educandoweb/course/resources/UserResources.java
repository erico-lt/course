package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entites.User;
import com.educandoweb.course.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    
    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {        
        
        return ResponseEntity.ok().body(userServices.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {        
        
        return ResponseEntity.ok().body(userServices.findById(id));        
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        
        user = userServices.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        userServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
