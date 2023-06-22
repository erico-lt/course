package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entites.OrderItem;
import com.educandoweb.course.services.OrderItemServices;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemResources {

    @Autowired
    private OrderItemServices orderItemServices;
    
   @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {

        return ResponseEntity.ok().body(orderItemServices.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> findById(@PathVariable Long id) {
        
        return ResponseEntity.ok().body(orderItemServices.findById(id));
    }
}
