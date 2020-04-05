package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Soal> listSoal;

    public MyAdapter(Context context, ArrayList<Soal> listSoal) {
        this.context = context;
        this.listSoal = listSoal;
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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView soal, pgA, pgB, pgC, pgD, correctAns;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            soal = itemView.findViewById(R.id.tv_soal);
            pgA = itemView.findViewById(R.id.tv_pga);
            pgB = itemView.findViewById(R.id.tv_pgb);
            pgC = itemView.findViewById(R.id.tv_pgc);
            pgD = itemView.findViewById(R.id.tv_pgd);
        }
    }
}
