package com.riska.riskatulmahmudah.antrianpasien.server;

import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianAPI;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseAntrianPasien;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseDokter;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseDokterAPI;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponseMasuk;
import com.riska.riskatulmahmudah.antrianpasien.model.ResponsePanggil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // to do 13 function untuk memanggil respon data --> perawatactivity
    @GET("Antrian/ListAntrian")
    Call<List<ResponseAntrianPasien>> readAntrianAPI(@Query("dokterID") String dokterID,
                                                     @Query("tgl") String tgl,
                                                     @Query("jam") String jam,
                                                     @Query("rsid") String rsid);


    @GET("Dokter/ListDataByRS")
    Call<List<ResponseDokter>> readDokter(@Query("rsID") String dokterID);

    @GET("antrian/panggil")
    Call<List<ResponsePanggil>> readPanggil(@Query("dokterID") String dokterID,
                                            @Query("tgl") String tgl,
                                            @Query("jam") String jam,
                                            @Query("rsID") String rsID);

    @GET("antrian/masuk")
    Call<List<ResponseMasuk>> readMasuk(@Query("dokterID") String dokterID,
                                        @Query("tgl") String tgl,
                                        @Query("jam") String jam,
                                        @Query("rsID") String rsID);

}
