package com.educandoweb.course.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
