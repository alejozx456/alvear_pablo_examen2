package com.example.proyectofactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRest {
    @GET("productos")
    Call<List<Producto>> obtenerProductos();

    @GET("productos/{id}")
    Call <Producto> obtenerProducto(@Path("id") Long id);
}
