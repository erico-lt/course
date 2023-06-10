package com.educandoweb.course.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{    
    
}
