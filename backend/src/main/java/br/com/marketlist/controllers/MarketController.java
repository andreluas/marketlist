package br.com.marketlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketlist.dto.MarketDTO;
import br.com.marketlist.services.MarketService;

@RestController
@RequestMapping(value = "/markets")
public class MarketController {

    @Autowired
    private MarketService service;

    @GetMapping()
    public ResponseEntity<Page<MarketDTO>> marketsForCurrentUser(Pageable pageable) {
        Page<MarketDTO> page = service.marketsForCurrentUser(pageable);
        return ResponseEntity.ok().body(page);
    }
}
