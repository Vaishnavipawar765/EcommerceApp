package com.example.ecommerceapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<Order> orderList;

    public OrderAdapter(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView productName, orderDate, orderAmount;

        public OrderViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            orderDate = itemView.findViewById(R.id.orderDate);
            orderAmount = itemView.findViewById(R.id.orderAmount);
        }
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.productName.setText(order.getProductName());
        holder.orderDate.setText(order.getOrderDate());
        holder.orderAmount.setText("₹" + order.getOrderAmount());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}

