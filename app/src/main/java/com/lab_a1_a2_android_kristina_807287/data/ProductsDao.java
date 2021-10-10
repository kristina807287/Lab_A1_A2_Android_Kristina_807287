package com.lab_a1_a2_android_kristina_807287.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.lab_a1_a2_android_kristina_807287.model.Products;

import java.util.List;

@Dao
public interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Products products);

    @Query("SELECT * FROM products ORDER BY product_name ASC")
    LiveData<List<Products>> getAllProducts();

    @Query("SELECT * FROM products WHERE product_id == :id")
    LiveData<Products> getProducts (int id);

    @Query("DELETE FROM products")
    void deleteAll();

    @Update
    void update(Products products);

    @Delete
    void delete(Products products);







}
