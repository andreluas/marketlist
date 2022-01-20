package br.com.marketlist.services;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketlist.dto.ProductDTO;
import br.com.marketlist.entities.Market;
import br.com.marketlist.entities.Product;
import br.com.marketlist.repositories.MarketRepository;
import br.com.marketlist.repositories.ProductRepository;
import br.com.marketlist.services.exceptions.DataBaseException;
import br.com.marketlist.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private MarketRepository repositoryMarket;

    // Find all
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable) {
        Page<Product> list = repository.findAll(pageable);
        return list.map(l -> new ProductDTO(l));
    }

    // Find by id
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductDTO(entity);
    }

    // Insert
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        Market market = repositoryMarket.getById(dto.getMarketId());
        entity.setMarket(market);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    // Update
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
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
    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setAmount(dto.getAmount());
    }
}
