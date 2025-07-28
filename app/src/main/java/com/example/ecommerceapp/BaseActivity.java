package com.example.ecommerceapp;




import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity {
    protected BottomNavigationView bottomNavigationView;

    protected void setupBottomNavigation(int selectedItemId) {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(selectedItemId);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                if (!(this instanceof HomeActivity)) {
                    startActivity(new Intent(this, HomeActivity.class));
                    finish();
                }
                return true;
            } else if (itemId == R.id.nav_cart) {
                if (!(this instanceof CartActivity)) {
                    startActivity(new Intent(this, CartActivity.class));
                    finish();
                }
                return true;
            } else if (itemId == R.id.nav_account) {
                if (!(this instanceof AccountActivity)) {
                    startActivity(new Intent(this, AccountActivity.class));
                    finish();
                }
                return true;
            }

            return false;
        });
    }
}
