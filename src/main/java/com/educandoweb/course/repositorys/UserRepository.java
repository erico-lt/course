package com.educandoweb.course.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    
}
