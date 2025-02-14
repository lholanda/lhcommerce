package nl.lhdev.lhcommerce.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.lhdev.lhcommerce.dto.ProductDTO;
import nl.lhdev.lhcommerce.entities.Product;
import nl.lhdev.lhcommerce.repositories.ProductRepository;
import nl.lhdev.lhcommerce.util.ConverterDTO;

@Service
public class ProductService {
    private ProductRepository repository;

    private ConverterDTO converterDto;

    public ProductService(ProductRepository repository, ConverterDTO converterDto) {
        this.repository = repository;
  
        this.converterDto   = converterDto;
    }


    @Transactional(readOnly = true)  // lock de leitura para nao lock no banco
    public ProductDTO findById(Long id) {

        Product product = repository.findById(id).get();

        return converterDto.fromEntity(product);
    }
}
