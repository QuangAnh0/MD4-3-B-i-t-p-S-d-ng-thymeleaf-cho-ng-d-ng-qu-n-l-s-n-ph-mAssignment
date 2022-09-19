package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "shoes")
public class Shoes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String price;
    private String image;

    @Override
    public String toString() {
        return String.format("Shoes[id=%d, name='%s', price='%s',image='%s']", id, name, price,image);
    }

    public Shoes() {
    }

    public Shoes(Integer id, String name, String price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}