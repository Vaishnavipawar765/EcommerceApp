package com.example.ecommerceapp;




import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {  // ✅ Changed to BaseActivity

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupBottomNavigation(R.id.nav_home); // ✅ Activate bottom nav

        productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = getProducts();
        productAdapter = new ProductAdapter(this, productList);
        productRecyclerView.setAdapter(productAdapter);
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Smartphone", "₹78,468", "Latest 5G smartphone with AMOLED display", R.drawable.smartphones));
        products.add(new Product("Headphones", "₹2,499", "Wireless headphones with noise cancellation", R.drawable.headphones));
        products.add(new Product("Shoes", "₹1,999", "Comfortable and stylish running shoes", R.drawable.shoes));
        products.add(new Product("Backpack", "₹899", "Waterproof backpack with laptop compartment", R.drawable.backpack));
        products.add(new Product("Smart Watch", "₹3,999", "Fitness tracking smartwatch with heart monitor", R.drawable.watch));
        products.add(new Product("Laptop", "₹49,999", "Powerful laptop with 16GB RAM and SSD", R.drawable.laptop));
        products.add(new Product("Water Bottle", "₹299", "Insulated steel bottle, keeps drinks hot/cold", R.drawable.bottle));

        return products;
    }
}
