package com.lab_a1_a2_android_kristina_807287;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.lab_a1_a2_android_kristina_807287.model.Products;

import java.util.List;

public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.ViewHolder> {

    private List<Products> productsList;
    private Context context;
    private onProductClickListener onProductClickListener;

    public ProductRVAdapter(List<Products> productsList, Context context, onProductClickListener onProductClickListener) {
        this.productsList = productsList;
        this.context = context;
        this.onProductClickListener = onProductClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.product_list_row, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductRVAdapter.ViewHolder holder, int position) {

        Products products = productsList.get(position);
        holder.tv_productName.setText(products.getProductName());
        holder.tv_productDesc.setText(products.getProductDescription());
        //holder.tv_productPrice.setText(String.valueOf(products.getProductPrice()));
    }

    @Override
    public int getItemCount() {

        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_productName;
        public TextView tv_productDesc;
        public TextView tv_productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_productName = itemView.findViewById(R.id.tv_productName);
            tv_productDesc = itemView.findViewById(R.id.tv_productDesc);
            tv_productDesc = itemView.findViewById(R.id.tv_price);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onProductClickListener.onProductClick(getAdapterPosition());


        }
    }
    public interface onProductClickListener {
        void onProductClick(int position);

    }
}
