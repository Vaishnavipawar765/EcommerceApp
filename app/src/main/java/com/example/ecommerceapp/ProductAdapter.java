package com.example.ecommerceapp;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<Product> productList;
    Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.name.setText(p.getName());
        holder.price.setText("₹" + p.getPrice());
        holder.desc.setText(p.getDesc());
        holder.productImage.setImageResource(p.getImageResId());

        holder.buyBtn.setOnClickListener(v -> {
            Product selectedProduct = productList.get(position);
            CartManager.addToCart(selectedProduct);

            Toast.makeText(context, "Added to cart!", Toast.LENGTH_SHORT).show();

            // Go to CartActivity
            Intent intent = new Intent(context, CartActivity.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, desc;
        Button buyBtn;
        ImageView productImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.productPrice);
            desc = itemView.findViewById(R.id.productDesc);
            buyBtn = itemView.findViewById(R.id.buyBtn);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
