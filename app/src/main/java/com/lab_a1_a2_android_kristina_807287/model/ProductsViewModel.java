package com.lab_a1_a2_android_kristina_807287.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.lab_a1_a2_android_kristina_807287.data.ProductsRepository;

import java.util.List;

public class ProductsViewModel extends AndroidViewModel {

    private ProductsRepository repository;
    private final LiveData<List<Products>> allProducts;

    public ProductsViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductsRepository(application);
        allProducts = repository.getAllProducts();
    }
    // public API
    public  LiveData<List<Products>> getAllProducts() {
        return allProducts;
    }

    public LiveData<Products> getProducts(int id) {
        return repository.getProducts(id);
    }

    public void insert(Products products) {
        repository.insert(products);
    }

    public void update(Products products) {
        repository.update(products);
    }

    public void delete(Products products) {
        repository.delete(products);
    }

}
