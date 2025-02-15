package nl.lhdev.lhcommerce.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import nl.lhdev.lhcommerce.dto.ProductDTO;
import nl.lhdev.lhcommerce.services.ProductService;

@RestController
@RequestMapping(value ="/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @GetMapping(value="/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
      
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> pageDTO = service.findAll(pageable);
        return ResponseEntity.ok(pageDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        // qdo cria um recurso na resposta, alem de dar o codigo created (201), vai dar o link do recurso criado - no header 
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }






    // Lista nao paginada
    @GetMapping("/no-pageable")
    public List<ProductDTO> noPageFindAll() {
        return service.noPageFindAll();
    }
  
}
