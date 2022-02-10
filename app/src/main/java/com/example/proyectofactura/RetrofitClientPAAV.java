package com.example.proyectofactura;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance=null;
    private ApiPAAV myApiPAAV;
    private  RetrofitClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiPAAV.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApiPAAV =retrofit.create(ApiPAAV.class);
    }
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public ApiPAAV getMyApiPAAV() {
        return myApiPAAV;
    }

}
