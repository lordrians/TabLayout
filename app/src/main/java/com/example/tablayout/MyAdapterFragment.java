package com.example.tablayout;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MyAdapterFragment extends RecyclerView.Adapter<MyAdapterFragment.MyViewHolder> implements StatefulAdapter {
    private Context context;
    public static ArrayList<Soal> listSoal;

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
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.soal.setText(listSoal.get(position).getSoal());
        holder.pgA.setText(listSoal.get(position).getPgA());
        holder.pgB.setText(listSoal.get(position).getPgB());
        holder.pgC.setText(listSoal.get(position).getPgC());
        holder.pgD.setText(listSoal.get(position).getPgD());
        holder.pgD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Berhasil", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listSoal.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView soal, pgA, pgB, pgC, pgD, correctAns;
        ViewPager2 viewPager2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            soal = itemView.findViewById(R.id.tv_soal);
            pgA = itemView.findViewById(R.id.tv_pga);
            pgB = itemView.findViewById(R.id.tv_pgb);
            pgC = itemView.findViewById(R.id.tv_pgc);
            pgD = itemView.findViewById(R.id.tv_pgd);
            viewPager2 = itemView.findViewById(R.id.viewPager);
            pgA.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.tv_pga:
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() +1, true);

            }
        }
    }
}

