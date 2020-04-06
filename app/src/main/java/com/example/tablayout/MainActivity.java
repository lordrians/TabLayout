package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    ViewPager2 myVp2;
    Button btnNext, btnPrevious;
    ViewPager2 viewPager2;
    MyAdapter myAdapter;
    MyAdapterFragment myAdapterFragment;
    private ArrayList<Soal> soalArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btn_next);
        btnPrevious = findViewById(R.id.btn_previous);
        viewPager2 = findViewById(R.id.viewPager);
//        viewPager2.setAdapter(new PagesAdapter(this));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        myAdapter = new MyAdapter(this, dtSoal.getData());
        myAdapterFragment = new MyAdapterFragment(this, dtSoal.getData());
        viewPager2.setAdapter(myAdapterFragment);


        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                tab.setText("Soal "+(position +1));
            }
        });
        tabLayoutMediator.attach();

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous_fragment(v);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_fragment(v);
            }
        });

    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }
    public void next_fragment(View view) {

        if (viewPager2.getCurrentItem() < MyAdapterFragment.listSoal.size()){
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }

    }

    public void previous_fragment(View view) {
        if (viewPager2.getCurrentItem() != 0){
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()-1);
        }

    }


}
