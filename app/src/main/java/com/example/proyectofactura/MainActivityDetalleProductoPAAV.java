package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityDetalleProductoPAAV extends AppCompatActivity {
TextView idp;
TextView nombreProducto;
TextView precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_producto);

        idp=findViewById(R.id.IdNombreProducto);
        nombreProducto=findViewById(R.id.idNombreDelProducto);
        precio=findViewById(R.id.IdTextPrecio);

        Integer dato=getIntent().getIntExtra("nombrep",1);
        Integer datoL=dato+1;
        idp.setText(String.valueOf(datoL));
        Long convertirid=Long.parseLong(String.valueOf(datoL));
        obtenerProductoById(convertirid);
    }
   public void  obtenerProductoById(Long id){
       Call<ProductoPAAV> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().obtenerProducto(id);
       call.enqueue(new Callback<ProductoPAAV>() {
           @Override
           public void onResponse(Call<ProductoPAAV> call, Response<ProductoPAAV> response) {
                nombreProducto.setText(response.body().nombre);
                precio.setText(String.valueOf(response.body().precio));
           }

           @Override
           public void onFailure(Call<ProductoPAAV> call, Throwable t) {

           }
       });
    }
}