package nl.lhdev.lhcommerce.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

        Product entity = repository.findById(id).get();

        return converterDto.fromEntity(entity);
    }

    @Transactional(readOnly = true)  // lock de leitura para nao lock no banco
    public Page<ProductDTO> findAll(Pageable pageable) {

        Page<Product> products = repository.findAll(pageable);

        return products.map(p -> converterDto.fromEntity(p));
    }


    // inserir novo Produto
    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product entity = converterDto.toEntity(dto);
        entity = repository.save(entity);

        return converterDto.fromEntity(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        // findById, vai no banco de dados
        // getReferenceById nao vai no BD, so prepara o objeto e este objeto será monitorado pela JPA
        // para ser gerenciado, deve ou ser buscado ou ser referenciado
        Product entity = repository.getReferenceById(id);

        // vai converter para DTO de uma entity já gravada no BD
        converterDto.toEntityExisting(dto, entity);

        entity = repository.save(entity);

        return converterDto.fromEntity(entity);
    }


    // testar
    // BeanUtils.copyProperties(dto, entity, "id"); // Ignora o ID para evitar criar um novo objeto
    

    @Transactional 
    public void deleteById(Long id) {
        
        repository.deleteById(id);
    }




    // Lista nao paginada
    @Transactional(readOnly = true)  // lock de leitura para nao lock no banco
    public List<ProductDTO> noPageFindAll() {

        List<Product> products = repository.findAll();

        return products.stream().map(p -> converterDto.fromEntity(p)).toList();
    }
}
