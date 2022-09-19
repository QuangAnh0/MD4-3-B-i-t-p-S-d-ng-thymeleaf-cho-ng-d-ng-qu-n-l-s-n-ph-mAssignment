package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ShoesForm {
    private int id;
    private String name;
    private String price;
    private MultipartFile image;

    public ShoesForm() {
    }

    public ShoesForm(int id, String name, String price, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
