package br.com.marketlist.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketlist.dto.MarketDTO;
import br.com.marketlist.entities.Market;
import br.com.marketlist.entities.Supermarket;
import br.com.marketlist.entities.User;
import br.com.marketlist.repositories.MarketRepository;
import br.com.marketlist.repositories.SupermarketRepository;
import br.com.marketlist.services.exceptions.DataBaseException;
import br.com.marketlist.services.exceptions.ResourceNotFoundException;

@Service
public class MarketService {

    @Autowired
    private MarketRepository repository;

    @Autowired
    private SupermarketRepository supermarketRepository;

    @Autowired
    private AuthService authService;

    // marketsForCurrentUser
    @Transactional(readOnly = true)
    public Page<MarketDTO> marketsForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Market> page = repository.findByUser(user, pageable);
        return page.map(x -> new MarketDTO(x));
    }

    // Find by id
    @Transactional(readOnly = true)
    public MarketDTO findById(Long id) {
        Optional<Market> obj = repository.findById(id);
        Market entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new MarketDTO(entity);
    }

    // Insert
    @Transactional
    public MarketDTO insert(MarketDTO dto) {
        Market entity = new Market();
        Supermarket supermarket = supermarketRepository.getById(dto.getSupermarketId());
        entity.setSupermarket(supermarket);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new MarketDTO(entity);
    }

    // Update
    @Transactional
    public MarketDTO update(Long id, MarketDTO dto) {
        try {
            Market entity = repository.getById(id);
            copyDtoToEntity(dto, entity);
            return new MarketDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }

     // Delete
     public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    // Dto -> Entity
    private void copyDtoToEntity(MarketDTO dto, Market entity) {
        entity.setTitle(dto.getTitle());
        entity.setBody(dto.getBody());
        entity.setTotal(dto.getTotal());
    }
}
