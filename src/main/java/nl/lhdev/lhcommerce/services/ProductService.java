package nl.lhdev.lhcommerce.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import nl.lhdev.lhcommerce.dto.ProductDTO;
import nl.lhdev.lhcommerce.entities.Product;
import nl.lhdev.lhcommerce.repositories.ProductRepository;
import nl.lhdev.lhcommerce.services.exceptions.DataBaseException;
import nl.lhdev.lhcommerce.services.exceptions.ResourceNotFoundException;
import nl.lhdev.lhcommerce.util.ConverterDTO;

@Service
public class ProductService {
    private ProductRepository repository;

    private ConverterDTO converterDto;

    public ProductService(ProductRepository repository, ConverterDTO converterDto) {
        this.repository = repository;

        this.converterDto = converterDto;
    }

    // Pesquisa por Id - findbyId

    @Transactional(readOnly = true) // lock de leitura para nao lock no banco
    public ProductDTO findById(Long id) {
        Product entity = repository.findById(id).orElseThrow(
              () -> new ResourceNotFoundException("Resource NOT found !!!")
        );
        return converterDto.fromEntity(entity);            
    }

    @Transactional(readOnly = true) // lock de leitura para nao lock no banco
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
        try {
            Product entity = repository.getReferenceById(id);
            // vai converter para DTO de uma entity já gravada no BD
            converterDto.toEntityExisting(dto, entity);
            entity = repository.save(entity);       
            return converterDto.fromEntity(entity);
        } catch (EntityNotFoundException e) {
             throw new ResourceNotFoundException("Resource NOT found !!!");
        }
    }

    // testar
    // BeanUtils.copyProperties(dto, entity, "id"); // Ignora o ID para evitar criar
    // um novo objeto

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(!repository.existsById((id))){
            throw new ResourceNotFoundException("Resource NOT found !!!");
        }
        try {
            repository.deleteById(id);          
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Referential integrity violated !!!");
        }
    }

    // Lista nao paginada
    @Transactional(readOnly = true) // lock de leitura para nao lock no banco
    public List<ProductDTO> noPageFindAll() {

        List<Product> products = repository.findAll();

        return products.stream().map(p -> converterDto.fromEntity(p)).toList();
    }
}


// https://www.baeldung.com/spring-boot-bean-validation
// https://jakarta.ee/learn/docs/jakartaee-tutorial/current/beanvalidation/bean-validation/bean-validation.html

/*

    @Transactional(readOnly = true) // lock de leitura para nao lock no banco
    public ProductDTO findById(Long id) {

        Product entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found !!")); 
        // get() orElseThrow sao funcoes do
        // Optional
        // get() orElseThrow sao funcoes do Optional

        return converterDto.fromEntity(entity);
    }

 */

 /*
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        // findById, vai no banco de dados
        // getReferenceById nao vai no BD, so prepara o objeto e este objeto será
        // monitorado pela JPA
        // para ser gerenciado, deve ou ser buscado ou ser referenciado
        Product entity = repository.getReferenceById(id);

        entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Eita, nao achei a entidade !!!")); // get() orElseThrow sao funcoes
                                                                                        // do Optional

        // vai converter para DTO de uma entity já gravada no BD
        converterDto.toEntityExisting(dto, entity);

        entity = repository.save(entity);

        return converterDto.fromEntity(entity);
    }

  */

  /*
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
   */