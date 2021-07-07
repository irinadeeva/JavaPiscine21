package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Isolated

class ProductsRepositoryJdbcImplTest {

    @Autowired
    private ProductsRepository productsRepository;

    Product product1 = new Product(1L, "rice", 100);
/*     List<Product> list = new ArrayList<>();


     list.add(product1);*/

/*            .add(new Product(2L, "buckwheat", 150))
            .add(new Product(3L, "oats", 200))
            .add(new Product(4L, "quinoa", 250))
            .add(new Product(5L, "millet", 300));*/
    //final List<Product> EXPECTED_FIND_ALL_PRODUCTS
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1L, "rice", 100);
/*    final Product EXPECTED_UPDATED_PRODUCT = ...;*/

    private DataSource dataSource;

    public void setUp() {
       dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding("UTF-8")
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
    }


    @Test
    void findAll() {

    }

    @Test
    void findById() {
        Product product = productsRepository.findById(1L).get();
        assertEquals(product, EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void update() {
    }

    @Test
    void save() {
        productsRepository.save(new Product(6L, "red rice", 600));
        Product product = productsRepository.findById(6L).orElseGet(()
                -> new Product(1L, "rice", 100));
        assertEquals(product.getName(), "red rice");
    }

    @Test
    void delete() {
    }
}