package com.riska.riskatulmahmudah.antrianpasien.server;

import com.riska.riskatulmahmudah.antrianpasien.model.ResponseDokter;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseDokterAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//todo 22
public interface ApiServiceDokter {

    @GET("Dokter/ListDataByRS")
    Call<List<ResponseDokter>> readDokter(@Query("rsID") String dokterID);

}
