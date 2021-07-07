package edu.school21.repositories;

import edu.school21.models.Product;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ProductsRepository extends Repository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void update(Product product);
    void save(Product product);
    void delete(Long id);
}
