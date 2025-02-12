package nl.lhdev.lhcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.lhdev.lhcommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
