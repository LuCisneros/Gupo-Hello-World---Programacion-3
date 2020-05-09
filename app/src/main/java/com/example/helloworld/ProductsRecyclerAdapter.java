package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductosViewHolder> {

    private Context context;
    private ArrayList<Product> productos;
    private OnItemClickListener onItemClickListener;

    public ProductsRecyclerAdapter(Context context, ArrayList<Product> productos) {
        this.context = context;
        this.productos = productos;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_products, null);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, final int position) {
        holder.onBind(productos.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(productos.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewPrice;
        ImageView imageView;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.tvName);
            textViewPrice = itemView.findViewById(R.id.tvPrice);
            imageView = itemView.findViewById(R.id.ivproducto);
        }

        public void onBind(Product producto) {
            textViewName.setText(producto.getName());
            textViewPrice.setText(producto.getPrice());
            imageView.setImageResource(producto.getImage());
        }
    }
}
