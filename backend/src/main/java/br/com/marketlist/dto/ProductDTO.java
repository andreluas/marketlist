package br.com.marketlist.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marketlist.entities.Product;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String name;

    @NotNull(message = "Campo obrigatório")
    private Integer amount;

    @NotNull(message = "Campo obrigatório")
    private Double price;
    private Long marketId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Integer amount, Double price, Long marketId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.marketId = marketId;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        amount = entity.getAmount();
        price = entity.getPrice();
        marketId = entity.getMarket().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

}
