package com.example.ecommerceapp;





public class Order {
    private String productName;
    private String orderDate;
    private double orderAmount;

    public Order(String productName, String orderDate, double orderAmount) {
        this.productName = productName;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public String getProductName() {
        return productName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
