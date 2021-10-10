package com.lab_a1_a2_android_kristina_807287;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lab_a1_a2_android_kristina_807287.model.Products;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private List<Products> productsList;
    private Context context;
    private onProductClickListener onProductClickListener;

    @NonNull
    @Override
    public ProductRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_row, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerViewAdapter.ViewHolder holder, int position) {
        Products products = productsList.get(position);
        holder.productName.setText(products.getProductName());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView productName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.tv_productName);

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
