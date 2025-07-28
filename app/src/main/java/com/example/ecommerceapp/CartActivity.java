package com.example.ecommerceapp;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends BaseActivity {

    RecyclerView cartRecyclerView;
    CartAdapter cartAdapter;
    TextView emptyCartText, totalPriceText;
    Button placeOrderButton;

    ArrayList<Product> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card); // ✅ Corrected XML name

        setupBottomNavigation(R.id.nav_cart); // ✅ Enable bottom navigation

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        emptyCartText = findViewById(R.id.emptyCartText);
        totalPriceText = findViewById(R.id.totalPriceText);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        cartItems = CartManager.getCart();
        cartAdapter = new CartAdapter(this, cartItems);

        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerView.setAdapter(cartAdapter);

        if (cartItems.isEmpty()) {
            emptyCartText.setVisibility(View.VISIBLE);
            cartRecyclerView.setVisibility(View.GONE);
            totalPriceText.setVisibility(View.GONE);
            placeOrderButton.setVisibility(View.GONE);
        } else {
            emptyCartText.setVisibility(View.GONE);
            cartRecyclerView.setVisibility(View.VISIBLE);
            totalPriceText.setVisibility(View.VISIBLE);
            placeOrderButton.setVisibility(View.VISIBLE);

            int total = 0;
            for (Product p : cartItems) {
                try {
                    total += Integer.parseInt(p.getPrice().replaceAll("[^0-9]", ""));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            totalPriceText.setText("₹" + total);
        }

        placeOrderButton.setOnClickListener(v -> {
            OrderManager.placeOrder(cartItems);
            Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
            CartManager.clearCart();

            // Go to AccountActivity
            Intent intent = new Intent(CartActivity.this, AccountActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
