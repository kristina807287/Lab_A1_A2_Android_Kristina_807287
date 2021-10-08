package com.lab_a1_a2_android_kristina_807287;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private List<Products> productsList;
    private Context context;
    private onProductClickListener onProductClickListener;

    public ProductRecyclerViewAdapter(List<Products> productsList, Context context, onProductClickListener onProductClickListener) {
        this.productsList = productsList;
        this.context = context;
        this.onProductClickListener = onProductClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //TODO: complete when entities are done

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {


        public ViewHolder(View view) {
            super();
        }

        @Override
        public void onClick(View v) {

        }
    }
}
