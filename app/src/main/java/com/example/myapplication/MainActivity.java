package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ApiInterface apiInterface;
    RecyclerView recyclerViewTC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //***********tabLayout**************************************************
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);



    }
}