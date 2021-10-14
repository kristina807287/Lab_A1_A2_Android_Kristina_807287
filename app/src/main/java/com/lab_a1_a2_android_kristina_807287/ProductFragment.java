package com.lab_a1_a2_android_kristina_807287;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lab_a1_a2_android_kristina_807287.model.Products;
import com.lab_a1_a2_android_kristina_807287.model.ProductsViewModel;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ProductFragment extends Fragment {

    public final static String PRODUCT_ID = "product_id";

    private ProductsViewModel productsViewModel;
    private RecyclerView recyclerView;
    private ProductRVAdapter productRVAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.products_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        productsViewModel = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(ProductsViewModel.class);
        productsViewModel.getAllProducts().observe((LifecycleOwner) getContext(), products -> {

            productRVAdapter = new ProductRVAdapter(products, getContext(), position -> {
                getActivity();
            });
            recyclerView.setAdapter(productRVAdapter);
            productRVAdapter.notifyDataSetChanged();

        });


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}