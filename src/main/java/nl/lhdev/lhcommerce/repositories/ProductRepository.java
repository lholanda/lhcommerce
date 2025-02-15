package nl.lhdev.lhcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.lhdev.lhcommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
