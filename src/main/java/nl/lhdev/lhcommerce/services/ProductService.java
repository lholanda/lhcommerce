package nl.lhdev.lhcommerce.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)  // lock de leitura para nao lock no banco
    public Page<ProductDTO> findAll(Pageable pageable) {

        Page<Product> products = repository.findAll(pageable);

        return products.map(p -> converterDto.fromEntity(p));
    }


    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product entity = converterDto.toEntity(dto);
        entity = repository.save(entity);

        return converterDto.fromEntity(entity);
    }



    // Lista nao paginada
    @Transactional(readOnly = true)  // lock de leitura para nao lock no banco
    public List<ProductDTO> noPageFindAll() {

        List<Product> products = repository.findAll();

        return products.stream().map(p -> converterDto.fromEntity(p)).toList();
    }
}
