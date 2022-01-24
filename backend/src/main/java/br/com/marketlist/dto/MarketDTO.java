package br.com.marketlist.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import br.com.marketlist.entities.Market;

public class MarketDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String title;
    private String body;

    @Past(message = "A data deve estar no passado")
    private Instant date;
    private Double total;
    private Long userId;
    private Long supermarketId;
    
    Set<ProductDTO> products = new HashSet<>();

    public MarketDTO() {
    }

    public MarketDTO(Long id, String title, String body, Instant date, Double total, Long userId, Long supermarketId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.total = total;
        this.userId = userId;
        this.supermarketId = supermarketId;
    }

    public MarketDTO(Market entity) {
        id = entity.getId();
        title = entity.getTitle();
        body = entity.getBody();
        date = entity.getDate();
        total = entity.getTotal();
        userId = entity.getUser().getId();
        supermarketId = entity.getSupermarket().getId();
        entity.getProducts().forEach(product -> this.products.add(new ProductDTO(product)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSupermarketId() {
        return supermarketId;
    }

    public void setSupermarketId(Long supermarketId) {
        this.supermarketId = supermarketId;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

}
