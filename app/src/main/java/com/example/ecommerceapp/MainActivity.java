package com.example.ecommerceapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button adminBtn, customerBtn;
    BottomNavigationView bottomNavigationView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminBtn = findViewById(R.id.adminBtn);
        customerBtn = findViewById(R.id.customerBtn);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }




        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdminAddProductActivity.class));
            }
        });

        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomerViewActivity.class));
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    return true;
                } else if (id == R.id.nav_cart) {
                    startActivity(new Intent(MainActivity.this, CartActivity.class));
                    return true;
                } else if (id == R.id.nav_account) {
                    startActivity(new Intent(MainActivity.this, AccountActivity.class));
                    return true;
                }
                return false;
            }
        });



    }
}