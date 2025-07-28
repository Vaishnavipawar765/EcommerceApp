package com.example.ecommerceapp;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AccountActivity extends BaseActivity {  // ✅ Changed to BaseActivity

    private RecyclerView ordersRecyclerView;
    private TextView ordersMessage;
    private Button homeBtn;
    private ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        setupBottomNavigation(R.id.nav_account); // ✅ Highlight bottom nav

        // Bind views
        ordersRecyclerView = findViewById(R.id.ordersRecyclerView);
        ordersMessage = findViewById(R.id.ordersMessage);
        homeBtn = findViewById(R.id.homeBtn);

        // Load orders
        orders = OrderManager.getOrders();

        if (orders.isEmpty()) {
            ordersMessage.setVisibility(View.VISIBLE);
            ordersRecyclerView.setVisibility(View.GONE);
        } else {
            ordersMessage.setVisibility(View.GONE);
            ordersRecyclerView.setVisibility(View.VISIBLE);

            ordersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            OrderAdapter adapter = new OrderAdapter(orders);
            ordersRecyclerView.setAdapter(adapter);
        }

        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
