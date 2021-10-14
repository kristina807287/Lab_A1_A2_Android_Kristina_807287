package com.lab_a1_a2_android_kristina_807287;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.lab_a1_a2_android_kristina_807287.model.ProductsViewModel;

public class MainActivity extends AppCompatActivity {

    private ProductsViewModel productsViewModel;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private FragmentAdapter fragmentAdapter;

    private SearchView searchbar;

    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductsViewModel productsViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication())
                .create(ProductsViewModel.class);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //searchbar = (SearchView) findViewById(R.id.search_bar);
        viewPager = (ViewPager2) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager, getLifecycle());
        viewPager.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Products"));
        tabLayout.addTab(tabLayout.newTab().setText("Provider"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab((tabLayout.getTabAt(position)));
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab_add_products);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddProductsActivity.class);
                //launcher.launch(intent);
                startActivity(intent);


            }
        });

    }
//        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
//
//            if (result.getResultCode() == RESULT_OK) {
//                Intent data = result.getData();
//                String prodName = data.getStringExtra(AddProductsActivity.PRODUCT_REPLY);
//                String prodDesc = data.getStringExtra(AddProductsActivity.DESCRIPTION_REPLY);
//                String prodPrice = data.getStringExtra(AddProductsActivity.PRICE_REPLY);
//
//                Products products = new Products(prodName, prodDesc, Double.parseDouble(prodPrice));
//                productsViewModel.insert(products);
//
//            }
//
//        });
    }

