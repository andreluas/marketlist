package br.com.marketlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketlist.dto.SupermarketDTO;
import br.com.marketlist.services.SupermarketService;

@RestController
@RequestMapping(value = "/supermarkets")
public class SupermarketController {
    
    @Autowired
    private SupermarketService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SupermarketDTO> findById(@PathVariable Long id) {

        SupermarketDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
