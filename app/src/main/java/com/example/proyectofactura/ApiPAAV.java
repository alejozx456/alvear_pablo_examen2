package com.example.proyectofactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiPAAV {
    String BASE_URL = "https://facturaheroku.herokuapp.com/api/";
    @GET("productos")
    Call<List<Producto>> getProductos();

    @GET("productos/{id}")
    Call <Producto> obtenerProducto(@Path("id") Long id);
}
