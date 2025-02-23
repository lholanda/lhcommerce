package nl.lhdev.lhcommerce.util;

import org.springframework.stereotype.Component;

import nl.lhdev.lhcommerce.dto.ProductDTO;
import nl.lhdev.lhcommerce.entities.Product;

@Component
public class ConverterDTO {

    public ProductDTO fromEntity(Product entity){
        //System.out.println("convertendo from Product to ProductDTO");
        return new ProductDTO(
                   entity.getId(), 
                   entity.getName(),
                   entity.getDescription(), 
                   entity.getPrice(), 
                   entity.getImgUrl()
                );
    }

    public Product toEntity(ProductDTO dto){
        return new Product(
                   dto.getId(),
                   dto.getName(),
                   dto.getDescription(), 
                   dto.getPrice(), 
                   dto.getImgUrl()
                );
    }

    public void toEntityExisting(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());          
    }
    
}
