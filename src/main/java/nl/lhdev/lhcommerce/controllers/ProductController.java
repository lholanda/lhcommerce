package nl.lhdev.lhcommerce.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.lhdev.lhcommerce.entities.Product;
import nl.lhdev.lhcommerce.repositories.ProductRepository;

@RestController
@RequestMapping(value ="/products")
public class ProductController {

    private ProductRepository repository;
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String teste() {
        Optional<Product> result = repository.findById(1L);
        Product product = result.get();
        return product.getName();
    }

    
}
