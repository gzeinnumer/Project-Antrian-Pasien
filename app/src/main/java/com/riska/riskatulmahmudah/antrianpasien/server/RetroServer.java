package com.riska.riskatulmahmudah.antrianpasien.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//to do 8 ke modul
public class RetroServer {

// to do 10 : tambahkan kodingan
public static String BASE_URL = "http://dev.smart-ics.com:222/antrian-api/Api/";
    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    // to do 11 buat class interface ==> bikin pojo ResponseAntrianAPI
    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}

