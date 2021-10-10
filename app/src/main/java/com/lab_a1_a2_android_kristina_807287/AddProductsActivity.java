package com.lab_a1_a2_android_kristina_807287;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lab_a1_a2_android_kristina_807287.model.ProductsViewModel;

public class AddProductsActivity extends AppCompatActivity {

    private EditText et_prodName, et_prodDesc, et_prodPrice;

    private ProductsViewModel productsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        //instantiate viewModel
        productsViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication())
                .create(ProductsViewModel.class);

        et_prodName = (EditText) findViewById(R.id.et_prodName);
        et_prodDesc = (EditText) findViewById(R.id.et_description);
        et_prodPrice = (EditText) findViewById(R.id.et_price);
        Button addProductBtn = findViewById(R.id.btn_add_products);
        addProductBtn.setOnClickListener((View.OnClickListener) addProductBtn);
        addProductBtn();


        //enter data statically
        et_prodName.setText("Bed");
        et_prodName.setText("Queen Size Bed");
        et_prodPrice.setText(String.valueOf(300));
    }

    private void addProductBtn() {
    }
}