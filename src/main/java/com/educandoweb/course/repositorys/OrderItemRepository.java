package com.educandoweb.course.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
    
}
