package nl.lhdev.lhcommerce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.lhdev.lhcommerce.dto.ProductDTO;
import nl.lhdev.lhcommerce.entities.Product;
import nl.lhdev.lhcommerce.repositories.ProductRepository;

@Service
public class ProductService {

    private ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // lock de leitura para nao lock no banco
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();

        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl());
    }
}
