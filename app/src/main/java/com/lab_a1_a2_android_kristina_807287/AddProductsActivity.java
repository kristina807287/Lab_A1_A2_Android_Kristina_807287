package com.lab_a1_a2_android_kristina_807287;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lab_a1_a2_android_kristina_807287.model.Products;
import com.lab_a1_a2_android_kristina_807287.model.ProductsViewModel;

public class AddProductsActivity extends AppCompatActivity {

    private EditText et_prodName, et_prodDesc, et_prodPrice;

    private ProductsViewModel productsViewModel;

    public static final String PRODUCT_REPLY = "prodName_reply";
    public static final String DESCRIPTION_REPLY = "prodDesc_reply";
    public static final String PRICE_REPLY = "prodPrice_reply";

    private Products products;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        //instantiate viewModel
        productsViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(ProductsViewModel.class);

        et_prodName = (EditText) findViewById(R.id.et_prodName);
        et_prodDesc = (EditText) findViewById(R.id.et_description);
        et_prodPrice = (EditText) findViewById(R.id.et_price);
        Button addProductBtn = findViewById(R.id.btn_add_products);
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductBtn();

            }
        });


        //get intent in order to display items
        if(getIntent().hasExtra(ProductFragment.PRODUCT_ID)) {
            int productId = getIntent().getIntExtra(ProductFragment.PRODUCT_ID, 0);
            productsViewModel.getProduct(productId).observe(this, products -> {
                if(products != null) {
                    et_prodName.setText(products.getProductName());
                    et_prodDesc.setText(products.getProductDescription());
                    et_prodPrice.setText(String.valueOf(products.getProductPrice()));
}
                });
            }


    }
    // the "ADD PRODUCT" button
    private void addProductBtn() {
        String product = et_prodName.getText().toString().trim();
        String description = et_prodDesc.getText().toString().trim();
        String price = et_prodPrice.getText().toString().trim();

        if(product.isEmpty()) {
            et_prodName.setError("name field is mandatory");
            et_prodName.requestFocus();
            return;

        }
        if(description.isEmpty()) {
            et_prodName.setError("name field is mandatory");
            et_prodName.requestFocus();
            return;

        }
        if(price.isEmpty()) {
            et_prodName.setError("name field is mandatory");
            et_prodName.requestFocus();
            return;

        }
        else {
            Products products = new Products();
            products.setProductName(product);
            products.setProductDescription(description);
            products.setProductPrice(Double.parseDouble(price));
            productsViewModel.insert(products);
        }
        finish();

        // create and intent to reply to the previous activity to set the result
        Intent replyIntent = new Intent();
        replyIntent.putExtra(PRODUCT_REPLY, product);
        replyIntent.putExtra(DESCRIPTION_REPLY, description);
        replyIntent.putExtra(PRICE_REPLY, price);
        setResult(RESULT_OK, replyIntent);
        Toast.makeText(this, "Product added", Toast.LENGTH_SHORT).show();
    }

}