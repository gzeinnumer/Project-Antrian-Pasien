package com.riska.riskatulmahmudah.antrianpasien.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.riska.riskatulmahmudah.antrianpasien.R;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianAPI;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianPasien;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPasien extends RecyclerView.Adapter<AdapterPasien.MyHolder> {
    private Context context;
    private ArrayList<ResponseAntrianPasien> list;

    public AdapterPasien(Context context, ArrayList<ResponseAntrianPasien> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pasien, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.noAntrian.setText(String.valueOf(list.get(i).getNoAntrian()));
        myHolder.namaPasient.setText(String.valueOf(list.get(i).getNamaPasien()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.antrianID)
        TextView antrianID;
        @BindView(R.id.dokterID)
        TextView dokterID;
        @BindView(R.id.dokterName)
        TextView dokterName;
        @BindView(R.id.tgl)
        TextView tgl;
        @BindView(R.id.jam)
        TextView jam;
        @BindView(R.id.rsid)
        TextView rsid;
        @BindView(R.id.noAntrian)
        TextView noAntrian;
        @BindView(R.id.noUrut)
        TextView noUrut;
        @BindView(R.id.namaPasient)
        TextView namaPasient;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

//    static class ViewHolder {
//        @BindView(R.id.antrianID)
//        TextView antrianID;
//        @BindView(R.id.dokterID)
//        TextView dokterID;
//        @BindView(R.id.dokterName)
//        TextView dokterName;
//        @BindView(R.id.tgl)
//        TextView tgl;
//        @BindView(R.id.jam)
//        TextView jam;
//        @BindView(R.id.rsid)
//        TextView rsid;
//        @BindView(R.id.noAntrian)
//        TextView noAntrian;
//        @BindView(R.id.noUrut)
//        TextView noUrut;
//        @BindView(R.id.namaPasient)
//        TextView namaPasient;
//
//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//    }
}
