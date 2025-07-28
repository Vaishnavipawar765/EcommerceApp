package com.example.ecommerceapp;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final Context context;
    private final ArrayList<Product> cartList;

    public CartAdapter(Context context, ArrayList<Product> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        Product product = cartList.get(position);

        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText("₹" + product.getPrice());
        holder.cardProductImage.setImageResource(product.getImageResId());


        holder.removeButton.setOnClickListener(v -> {
            cartList.remove(position); // Remove from adapter list
            CartManager.updateCart(cartList); // Update global cart
            notifyDataSetChanged(); // Refresh list
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, priceTextView;
        ImageView cardProductImage;
        Button removeButton;

        public CartViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.cartProductName);
            priceTextView = itemView.findViewById(R.id.cartProductPrice);
            cardProductImage = itemView.findViewById(R.id.cartProductImage);
            removeButton = itemView.findViewById(R.id.removeButton);
        }
    }
}
