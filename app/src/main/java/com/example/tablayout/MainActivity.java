package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
//    ViewPager2 myVp2;
    Button btnNext, btnPrevious;
    ViewPager2 viewPager2;
    int Nilai;

    String allitem="";
//    MyAdapter myAdapter;
    MyAdapterFragment myAdapterFragment;
    private ArrayList<Soal> soalArrayList = new ArrayList<>();
    private  SharedPreferences sharedPreferences;
    private ArrayList<String> soalKosong = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btn_next);
        btnPrevious = findViewById(R.id.btn_previous);

        viewPager2 = findViewById(R.id.viewPager);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int jmlJawaban = dtSoal.getData().size();
                sharedPreferences = getSharedPreferences("myFile", 0);
                for (int i=0; i<jmlJawaban; i++){
                    boolean SoalNum = sharedPreferences.getBoolean("SoalNum_" + i, Boolean.parseBoolean(""));
                    if (!sharedPreferences.contains("SoalNum_"+i)){

                        soalKosong.add(String.valueOf(i+1));


                    }
                    if (SoalNum){
                        Nilai += 10;
                    }
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("Nilai", Nilai);
                editor.apply();

                for (int j = 0; j <soalKosong.size(); j++){

                    if (j == soalKosong.size()-1  ){
                        allitem +=  soalKosong.get(j);
                    } else {
                        allitem += soalKosong.get(j) + "/";
                    }
                }


                Toast.makeText(getApplicationContext(), "Soal yang belum dikerjakan = "+ allitem, Toast.LENGTH_LONG).show();
                finish();
            }
        });

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
