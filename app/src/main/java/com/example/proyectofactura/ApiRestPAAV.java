package com.example.proyectofactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRestPAAV {
    @GET("productos")
    Call<List<ProductoPAAV>> obtenerProductos();

    @GET("productos/{id}")
    Call <ProductoPAAV> obtenerProducto(@Path("id") Long id);


}
