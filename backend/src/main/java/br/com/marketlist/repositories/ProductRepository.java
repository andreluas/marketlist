package br.com.marketlist.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketlist.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
