package com.example.sith3.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected RecyclerView mRecy_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecy_view= findViewById(R.id.Recy_view);
        mRecy_view.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(this,getData());
        mRecy_view.setAdapter(adapter);
    }
    private List<Product> getData(){
        List<Product> data=new ArrayList<>();
                Product p1=new Product();
                p1.setName("Television");
                p1.setUnitPrice(90);
                data.add(p1);
                Product p2=new Product();
                p2.setName("Refrigerator");
                p2.setUnitPrice(80);
                data.add(p2);
                return data;
    }
}
