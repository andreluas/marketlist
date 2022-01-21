package br.com.marketlist.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.marketlist.entities.Market;

public class SupermarketDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String img;
    private List<Market> markets = new ArrayList<>();

    public SupermarketDTO() {
    }

    public SupermarketDTO(Long id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Market> getMarkets() {
        return markets;
    }

}
