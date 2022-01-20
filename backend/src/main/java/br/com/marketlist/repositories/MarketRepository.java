package br.com.marketlist.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketlist.entities.Market;
import br.com.marketlist.entities.User;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    
    Page<Market> findByUser(User user, Pageable pageable);
}
