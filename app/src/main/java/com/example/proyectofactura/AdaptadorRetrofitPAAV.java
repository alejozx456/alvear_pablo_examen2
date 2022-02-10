package com.example.proyectofactura;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdaptadorRetrofitPAAV {
    Retrofit retrofit;

    public AdaptadorRetrofitPAAV() {

    }
    public Retrofit getAdaptador(){
        retrofit=new Retrofit.Builder()
                .baseUrl("https://facturaheroku.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
