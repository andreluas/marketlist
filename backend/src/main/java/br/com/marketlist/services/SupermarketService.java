package br.com.marketlist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketlist.dto.SupermarketDTO;
import br.com.marketlist.entities.Supermarket;
import br.com.marketlist.repositories.SupermarketRepository;
import br.com.marketlist.services.exceptions.ResourceNotFoundException;

@Service
public class SupermarketService {
    
    @Autowired
    private SupermarketRepository repository;

    @Transactional(readOnly = true)
    public SupermarketDTO findById(Long id) {
        Optional<Supermarket> obj = repository.findById(id);
        Supermarket entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new SupermarketDTO(entity);
    }
}
