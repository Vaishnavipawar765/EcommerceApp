package com.example.ecommerceapp;





import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAddProductActivity extends AppCompatActivity {

    EditText nameInput, priceInput, descInput;
    Button addButton;
    DatabaseReference productRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_product);

        nameInput = findViewById(R.id.editName);
        priceInput = findViewById(R.id.editPrice);
        descInput = findViewById(R.id.editDescription);
        addButton = findViewById(R.id.addProduct);

        // Firebase "products" node
        productRef = FirebaseDatabase.getInstance().getReference("products");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String price = priceInput.getText().toString().trim();
                String desc = descInput.getText().toString().trim();

                if (name.isEmpty() || price.isEmpty() || desc.isEmpty()) {
                    Toast.makeText(AdminAddProductActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int imageResId = R.drawable.cart; // ✅ your drawable image

                Product product = new Product(name, price, desc, imageResId);
                String id = productRef.push().getKey(); // generate unique ID
                productRef.child(id).setValue(product);

                Toast.makeText(AdminAddProductActivity.this, "Product Added", Toast.LENGTH_SHORT).show();

                // clear input
                nameInput.setText("");
                priceInput.setText("");
                descInput.setText("");
            }
        });
    }
}
