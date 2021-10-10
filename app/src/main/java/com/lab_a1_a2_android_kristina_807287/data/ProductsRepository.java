package com.lab_a1_a2_android_kristina_807287.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lab_a1_a2_android_kristina_807287.model.Products;
import com.lab_a1_a2_android_kristina_807287.util.ProductsRoomDB;

import java.util.List;

public class ProductsRepository {

    private ProductsDao productsDao;
    LiveData<List<Products>> allProducts;


    public ProductsRepository (Application application) {
        ProductsRoomDB productsRoomDB = ProductsRoomDB.getInstance((application)); // application is the context
        productsDao = productsRoomDB.productsDao();
        allProducts = productsDao.getAllProducts();
    }

    //public API
    public LiveData<List<Products>> getAllProducts() {
        return allProducts;
    }

    public LiveData<Products> getProducts(int id) {
        return productsDao.getProducts(id);
    }

    public  void update (Products products) {
        ProductsRoomDB.databaseWriteExecutor.execute(() -> productsDao.update(products));
    }

    public  void delete (Products products) {
        ProductsRoomDB.databaseWriteExecutor.execute(() -> productsDao.delete(products));
    }

    public void insert(Products products) {
        ProductsRoomDB.databaseWriteExecutor.execute(()-> productsDao.insert(products));

    }
}
