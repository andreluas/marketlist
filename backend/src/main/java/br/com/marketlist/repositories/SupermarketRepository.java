package br.com.marketlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketlist.entities.Supermarket;

@Repository
public interface SupermarketRepository extends JpaRepository<Long, Supermarket> {
    
}
