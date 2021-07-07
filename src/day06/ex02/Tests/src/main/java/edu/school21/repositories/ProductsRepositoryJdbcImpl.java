package edu.school21.repositories;

import edu.school21.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private final ProductsRepository productsRepository ;

    public ProductsRepositoryJdbcImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List) productsRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productsRepository.update(product);
    }

    @Override
    public void save(Product product) {
        productsRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productsRepository.delete(id);
    }

}
