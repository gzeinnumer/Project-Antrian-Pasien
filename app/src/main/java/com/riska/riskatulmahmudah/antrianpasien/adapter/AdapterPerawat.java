package com.riska.riskatulmahmudah.antrianpasien.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.riska.riskatulmahmudah.antrianpasien.R;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianPasien;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//to do 17 : extend kan dan pecah2kan bohlam sebanyak 4 kali
public class AdapterPerawat extends RecyclerView.Adapter<AdapterPerawat.MyHolder> {

    // to do 18 deklarasikan - 2 baris
    private Context context;
    private ArrayList<ResponseAntrianPasien> list;

    // to do 19 buat contruktor

    public AdapterPerawat(Context context, ArrayList<ResponseAntrianPasien> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //to do 20 - 3 baris
        // to do 22 klik kanan item pasien - butterkinfe - centang createviewholder
        View view = LayoutInflater.from(context).inflate(R.layout.item_perawat, viewGroup, false);
        return new MyHolder(view);

        //to do 21 : pecahkan bohlam item_perawat , buat layout
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        // to do 26 tambahkan
        myHolder.antrianID.setText(list.get(i).getAntrianID());
        myHolder.dokterID.setText(list.get(i).getDokterID());
        myHolder.dokterName.setText(list.get(i).getDokterName());
        myHolder.tgl.setText(list.get(i).getTgl());
        myHolder.jam.setText(list.get(i).getJam());
        myHolder.rsid.setText(list.get(i).getRSID());
        myHolder.noAntrian.setText(String.valueOf(list.get(i).getNoAntrian()));
        myHolder.noUrut.setText(String.valueOf(list.get(i).getNoUrut()));
        myHolder.namaPasient.setText(list.get(i).getNamaPasien());
        myHolder.status.setText(String.valueOf(list.get(i).getStatus()));
        if(list.get(i).getStatus()==1){
            myHolder.lnperawat.setBackgroundColor(Color.BLUE);
        }else if(list.get(i).getStatus()==2){
            myHolder.lnperawat.setBackgroundColor(Color.RED);
        }else {
            myHolder.lnperawat.setBackgroundColor(Color.WHITE);
        }
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        // to do 27 -> perawat activity
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
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.lnperawat)
        LinearLayout lnperawat;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //to do 25 hapus static class viewHolder
            ButterKnife.bind(this, itemView);

        }

    }



//    static class ViewHolder {
//       // to do 23 cut semua @bindview pindahkan ke myholder
////        @BindView(R.id.antrianID)
////        TextView antrianID;
////        @BindView(R.id.dokterID)
////        TextView dokterID;
////        @BindView(R.id.dokterName)
////        TextView dokterName;
////        @BindView(R.id.tgl)
////        TextView tgl;
////        @BindView(R.id.jam)
////        TextView jam;
////        @BindView(R.id.rsid)
////        TextView rsid;
////        @BindView(R.id.noAntrian)
////        TextView noAntrian;
////        @BindView(R.id.noUrut)
////        TextView noUrut;
////        @BindView(R.id.namaPasient)
////        TextView namaPasient;
//
////        ViewHolder(View view) {
////            // to do 24 cut butterknife pindahkan ke myholder
////            //ButterKnife.bind(this, view);
////        }
//    }
}
