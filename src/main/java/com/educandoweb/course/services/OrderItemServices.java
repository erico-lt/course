package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entites.OrderItem;
import com.educandoweb.course.repositorys.OrderItemRepository;

@Service
public class OrderItemServices {
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        
        return orderItemRepository.findAll();
    }

    public OrderItem findById(Long id) {
        Optional<OrderItem> obj = orderItemRepository.findById(id);
        return  obj.get();
    }
}