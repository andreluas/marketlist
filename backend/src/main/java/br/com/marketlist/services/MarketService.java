package br.com.marketlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketlist.dto.MarketDTO;
import br.com.marketlist.entities.Market;
import br.com.marketlist.entities.User;
import br.com.marketlist.repositories.MarketRepository;

@Service
public class MarketService {
    
    @Autowired
    private MarketRepository repository;

    @Autowired
    private AuthService authService;

    // marketsForCurrentUser
    @Transactional(readOnly = true)
    public Page<MarketDTO> marketsForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Market> page = repository.findByUser(user, pageable);
        return page.map(x -> new MarketDTO(x));
    }
}
