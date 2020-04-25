package com.example.tablayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MyAdapterFragment extends RecyclerView.Adapter<MyAdapterFragment.MyViewHolder> implements StatefulAdapter {
    private Context context;
    public static ArrayList<Soal> listSoal;
    private SharedPreferences sharedPreferences;
    TabLayout tabLayout;

    public MyAdapterFragment(Context context, ArrayList<Soal> listSoal) {
        this.context = context;
        this.listSoal = listSoal;
    }

    @NonNull
    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(@NonNull Parcelable savedState) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment,parent,false);

        sharedPreferences = context.getSharedPreferences("myFile", 0);
        View view1 = parent.getRootView();
        tabLayout = view1.findViewById(R.id.tabLayout);

        return new MyViewHolder(view);
    }

    private RadioButton lastCheck = null;
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.soal.setText(listSoal.get(position).getSoal());
        holder.rbPgA.setText(listSoal.get(position).getPgA());
        holder.rbPgB.setText(listSoal.get(position).getPgB());
        holder.rbPgC.setText(listSoal.get(position).getPgC());
        holder.rbPgD.setText(listSoal.get(position).getPgD());



    }

    @Override
    public int getItemCount() {
        return listSoal.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView soal;
        ViewPager2 viewPager2;
        RadioButton rbPgA, rbPgB, rbPgC, rbPgD, rbCheck;
        int rbId;
        RadioGroup radioGroup;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            soal = itemView.findViewById(R.id.tv_soal);
            rbPgA = itemView.findViewById(R.id.rb_pga);
            rbPgB = itemView.findViewById(R.id.rb_pgb);
            rbPgC = itemView.findViewById(R.id.rb_pgc);
            rbPgD = itemView.findViewById(R.id.rb_pgd);
            radioGroup = itemView.findViewById(R.id.rg_pg);
            viewPager2 = itemView.findViewById(R.id.viewPager);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    rbCheck = group.findViewById(checkedId);
                    String jwbUser = rbCheck.getText().toString();
                    int select =tabLayout.getSelectedTabPosition();
                    TabLayout.Tab se = tabLayout.getTabAt(select);
                    se.view.setBackgroundResource(R.drawable.tab_background_answered);



                    if (jwbUser.equals(listSoal.get(getAdapterPosition()).getCorrectAns())){
                        Toast.makeText(context, "jawaban benar", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("SoalNum_" + getAdapterPosition(),true);
                        editor.commit();
                    } else {
                        Toast.makeText(context, "jawaban Salah", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("SoalNum_" + getAdapterPosition(),false);
                        editor.commit();
                    }



                }
            });

//            if (radioGroup.getCheckedRadioButtonId() == -1){
//
//            } else {
//                rbId = radioGroup.getCheckedRadioButtonId();
//                rbCheck = radioGroup.findViewById(rbId);
//                Toast.makeText(context, rbCheck.getText().toString(), Toast.LENGTH_SHORT).show();
//            }



        }

    }
}

