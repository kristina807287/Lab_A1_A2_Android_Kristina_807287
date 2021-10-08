package com.lab_a1_a2_android_kristina_807287.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lab_a1_a2_android_kristina_807287.model.Products;

@Dao
public interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Products products);





}
