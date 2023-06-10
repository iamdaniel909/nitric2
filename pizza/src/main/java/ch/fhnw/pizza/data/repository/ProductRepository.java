package ch.fhnw.pizza.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Product;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);
    Product findByProductId(Long productId);
    List<Product> findAll();
}
