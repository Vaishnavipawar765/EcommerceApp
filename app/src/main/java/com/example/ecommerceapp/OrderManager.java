package com.example.ecommerceapp;

// OrderManager.java


import java.util.ArrayList;

public class OrderManager {
    private static final ArrayList<Order> orderList = new ArrayList<>();

    public static void placeOrder(ArrayList<Product> cartItems) {
        for (Product p : cartItems) {
            try {
                Order order = new Order(
                        p.getName(),
                        java.text.DateFormat.getDateTimeInstance().format(new java.util.Date()),
                        Double.parseDouble(p.getPrice().replaceAll("[^0-9.]", "")) // ✅ Clean price
                );
                orderList.add(order);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Optional: log error
            }
        }
    }

    public static ArrayList<Order> getOrders() {
        return orderList;
    }

    public static boolean hasOrders() {
        return !orderList.isEmpty();
    }
}
