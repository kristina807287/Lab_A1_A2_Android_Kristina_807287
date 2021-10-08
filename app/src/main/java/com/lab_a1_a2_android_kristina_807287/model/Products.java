package com.lab_a1_a2_android_kristina_807287.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Products {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int productId;

    @NonNull
    @ColumnInfo(name = "product_name")
    private String productName;

    @NonNull
    @ColumnInfo(name = "product_description")
    private String productDescription;

    @NonNull
    @ColumnInfo(name = "product_price")
    private double productPrice;

    @Ignore
   public Products() {
   }

   // generate constructor


    public Products(@NonNull String productName, @NonNull String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    //generate getters

    public int getProductId() {
        return productId;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    @NonNull
    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    // generate setters

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    public void setProductDescription(@NonNull String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}
