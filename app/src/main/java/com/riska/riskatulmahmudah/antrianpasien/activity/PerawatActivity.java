package com.riska.riskatulmahmudah.antrianpasien.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.riska.riskatulmahmudah.antrianpasien.R;
import com.riska.riskatulmahmudah.antrianpasien.adapter.AdapterPerawat;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianAPI;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianPasien;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseMasuk;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponsePanggil;
import com.riska.riskatulmahmudah.antrianpasien.server.RetroServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerawatActivity extends AppCompatActivity {

    public static final String ID_DOK = "id_dok";
    @BindView(R.id.rvDataPasien)
    RecyclerView rvDataPasien;
    @BindView(R.id.fab1)
    FloatingActionButton fab1;
    @BindView(R.id.fab2)
    FloatingActionButton fab2;

    // to do 15
    ArrayList<ResponseAntrianPasien> mList = new ArrayList<>();
    // to do 28
    AdapterPerawat adapter;

    String idDok, idRs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to do 6 : klik kanan di activity_perawat lalu generate - butterknife centang hanya pada fab
        setContentView(R.layout.activity_perawat);
        ButterKnife.bind(this);

        idDok = "agusbudiman@gmail.com";
//        idDok = getIntent().getStringExtra(ID_DOK);



    // to do 14 - 1 baris
        initDataFromApi();
    }
    // to do 16 isi initDataAPI dan buat adapterperawat
    private void initDataFromApi() {
        RetroServer.getInstance().readAntrianAPI(
                "agusbudiman@gmail.com",
                "04-04-2019",
                "09:00:00",
                "RSPWD")
                .enqueue(new Callback<List<ResponseAntrianPasien>>() {
                    @Override
                    public void onResponse(Call<List<ResponseAntrianPasien>> call, Response<List<ResponseAntrianPasien>> response) {

                        List<ResponseAntrianPasien> list = response.body();
                        for (int i=0; i<list.size(); i++){
                            mList.add(new ResponseAntrianPasien(
                                    list.get(i).getDokterID(),
                                    list.get(i).getNoUrut(),
                                    list.get(i).getAntrianID(),
                                    list.get(i).getNoAntrian(),
                                    list.get(i).getJam(),
                                    list.get(i).getTgl(),
                                    list.get(i).getRSID(),
                                    list.get(i).getNamaPasien(),
                                    list.get(i).getDokterName(),
                                    list.get(i).getStatus()));
                        }
                        initToRecycler();
                    }

                    @Override
                    public void onFailure(Call<List<ResponseAntrianPasien>> call, Throwable t) {

                        Toast.makeText(PerawatActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void initToRecycler() {
    // to do 29
        adapter = new AdapterPerawat(this, mList);
        rvDataPasien.setHasFixedSize(true);
        rvDataPasien.setLayoutManager(new LinearLayoutManager(this));
        rvDataPasien.setAdapter(adapter);

        //30 buat function
        setDragRecyclerView();


    }

    // to do 31
    public void setDragRecyclerView() {
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvDataPasien.addItemDecoration(divider);

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(
                        ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder drag,
                                          @NonNull RecyclerView.ViewHolder drop) {
                        int dragged = drag.getAdapterPosition();
                        int dropped = drop.getAdapterPosition();
                        Collections.swap(mList, dragged, dropped);
                        adapter.notifyItemMoved(dragged, dropped);
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                        int position = viewHolder.getAdapterPosition();
                        //mList.remove(position);
                        adapter.notifyDataSetChanged();

                    }
                });
        helper.attachToRecyclerView(rvDataPasien);
    }

    @OnClick({R.id.fab1, R.id.fab2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab1:
            // to do 7 : buat panggil function fab 1,2,3 dan 4 --> buat class retroserver
                actionFab1();
                break;
            case R.id.fab2:
                actionFab2();
                break;
        }
    }

    private void actionFab1(){
        mList.clear();
        RetroServer.getInstance().readPanggil(
                "agusbudiman@gmail.com",
                "04-04-2019",
                "09:00:00",
                "RSPWD")
                .enqueue(new Callback<List<ResponsePanggil>>() {
                    @Override
                    public void onResponse(Call<List<ResponsePanggil>> call, Response<List<ResponsePanggil>> response) {

                        List<ResponsePanggil> list = response.body();
                        for (int i=0; i<list.size(); i++){
                            mList.add(new ResponseAntrianPasien(
                                    list.get(i).getDokterID(),
                                    list.get(i).getNoUrut(),
                                    list.get(i).getAntrianID(),
                                    list.get(i).getNoAntrian(),
                                    list.get(i).getJam(),
                                    list.get(i).getTgl(),
                                    list.get(i).getRSID(),
                                    list.get(i).getNamaPasien(),
                                    list.get(i).getDokterName(),
                                    list.get(i).getStatus()));
                        }
                        initToRecycler();
                    }

                    @Override
                    public void onFailure(Call<List<ResponsePanggil>> call, Throwable t) {

                        Toast.makeText(PerawatActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        Toast.makeText(this,"Panggil",Toast.LENGTH_LONG).show();
    }
    private void actionFab2() {

        mList.clear();
        RetroServer.getInstance().readMasuk(
                "agusbudiman@gmail.com",
                "04-04-2019",
                "09:00:00",
                "RSPWD")
                .enqueue(new Callback<List<ResponseMasuk>>() {
                    @Override
                    public void onResponse(Call<List<ResponseMasuk>> call, Response<List<ResponseMasuk>> response) {

                        List<ResponseMasuk> list = response.body();
                        for (int i=0; i<list.size(); i++){
                            mList.add(new ResponseAntrianPasien(
                                    list.get(i).getDokterID(),
                                    list.get(i).getNoUrut(),
                                    list.get(i).getAntrianID(),
                                    list.get(i).getNoAntrian(),
                                    list.get(i).getJam(),
                                    list.get(i).getTgl(),
                                    list.get(i).getRSID(),
                                    list.get(i).getNamaPasien(),
                                    list.get(i).getDokterName(),
                                    list.get(i).getStatus()));
                        }
                        initToRecycler();
                    }

                    @Override
                    public void onFailure(Call<List<ResponseMasuk>> call, Throwable t) {

                        Toast.makeText(PerawatActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Toast.makeText(this,"Masuk",Toast.LENGTH_LONG).show();
    }
}
