package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entites.Order;
import com.educandoweb.course.entites.OrderItem;
import com.educandoweb.course.repositorys.OrderRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order order) {

        return orderRepository.save(order);
    }

    public void delete(Long id) {
        
        try {
            if(!orderRepository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            } else {
                orderRepository.deleteById(id);
            }            
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Order update(Long id, Integer quantity) {

        Order entity = orderRepository.getReferenceById(id);
        updatedata(entity, quantity, id);

        return orderRepository.save(entity);
    }

    public void updatedata(Order entity, Integer quantity, Long id) {
        
        for(OrderItem x: entity.getItems()) {
            x.setQuantity(quantity);
        } 
    } 
}