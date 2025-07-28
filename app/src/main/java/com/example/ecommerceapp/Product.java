package com.example.ecommerceapp;





public class Product {
    private String name;
    private String price;
    private String desc;
    private int imageResId; // Drawable resource ID

    public Product() {
        // Default constructor
    }

    public Product(String name, String price, String desc, int imageResId) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageResId() {
        return imageResId;
    }
}
