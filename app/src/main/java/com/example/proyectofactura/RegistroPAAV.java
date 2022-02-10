package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroPAAV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paav);
    }
    public void ObtenerPersonasPAAV(View view){
        //Call<List<ProductoPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getProductos();
        Call<List<PersonaPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getPersonas();
        call.enqueue(new Callback<List<PersonaPAAV>>() {
            @Override
            public void onResponse(Call<List<PersonaPAAV>> call, Response<List<PersonaPAAV>> response) {
                List<PersonaPAAV> personaPAAVS=response.body();
            }

            @Override
            public void onFailure(Call<List<PersonaPAAV>> call, Throwable t) {

            }
        });
    }
}