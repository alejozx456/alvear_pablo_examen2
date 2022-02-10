package com.example.proyectofactura;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientPAAV {
    private static RetrofitClientPAAV instance=null;
    private ApiPAAV myApiPAAV;
    private RetrofitClientPAAV(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiPAAV.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApiPAAV =retrofit.create(ApiPAAV.class);
    }
    public static synchronized RetrofitClientPAAV getInstance() {
        if (instance == null) {
            instance = new RetrofitClientPAAV();
        }
        return instance;
    }
    public ApiPAAV getMyApiPAAV() {
        return myApiPAAV;
    }

}
