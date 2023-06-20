package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entites.Category;
import com.educandoweb.course.entites.Product;
import com.educandoweb.course.entites.Order;
import com.educandoweb.course.entites.User;
import com.educandoweb.course.enums.OrderStatus;
import com.educandoweb.course.repositorys.CategoryRepository;
import com.educandoweb.course.repositorys.OrderRepository;
import com.educandoweb.course.repositorys.ProductRepository;
import com.educandoweb.course.repositorys.UserRepository;

@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
     
        User u1 = new User(null, "Érico", "erico.blp@gmail.com", "2325666", "12345");
        User u2 = new User(null, "Olivia", "olivia.blp@gmail.com", "5453656", "232332");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAINTING);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAINTING);      
        
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        cat1.getProducts().add(p2);
        cat2.getProducts().add(p1);
        cat2.getProducts().add(p5);
        cat3.getProducts().add(p2);
        cat3.getProducts().add(p3);
        cat3.getProducts().add(p4);       

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
    }

}
