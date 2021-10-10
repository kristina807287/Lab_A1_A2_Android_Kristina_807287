package com.lab_a1_a2_android_kristina_807287;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lab_a1_a2_android_kristina_807287.model.ProductsViewModel;

public class MainActivity extends AppCompatActivity {


    private ProductsViewModel productsViewModel;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewAdapter adapter;

    private SearchView searchbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication())
                .create(ProductsViewModel.class);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        searchbar = (SearchView) findViewById(R.id.search_bar);
        viewPager = (ViewPager2) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewAdapter(fragmentManager, getLifecycle());
        viewPager.setAdapter(adapter);

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



//        FloatingActionButton fab = findViewById(R.id.btn_add_products);
//        fab.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, AddProductsActivity.class);
//            startActivity(intent);
//        });

    }




}