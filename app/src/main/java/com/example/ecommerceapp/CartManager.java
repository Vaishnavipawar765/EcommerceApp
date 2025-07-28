package com.example.ecommerceapp;


import java.util.ArrayList;




public class CartManager {
    private static final ArrayList<Product> cart = new ArrayList<>();

    public static ArrayList<Product> getCart() {
        return new ArrayList<>(cart); // return a copy
    }

    public static void addToCart(Product product) {
        cart.add(product);
    }

    public static ArrayList<Product> getCartItems() {
        return new ArrayList<>(cart); // Return copy to avoid direct modification
    }

    public static void clearCart() {
        cart.clear();
    }

    public static void updateCart(ArrayList<Product> updatedCart) {
        cart.clear();
        cart.addAll(updatedCart);
    }
}
