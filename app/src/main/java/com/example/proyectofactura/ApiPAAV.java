package com.example.proyectofactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiPAAV {
    String BASE_URL = "https://apiherokuprueba.herokuapp.com/api/";
    @GET("productos")
    Call<List<ProductoPAAV>> getProductos();

    @GET("productos/{id}")
    Call <ProductoPAAV> obtenerProducto(@Path("id") Long id);

    @GET("personas")
    Call<List<PersonaPAAV>> getPersonas();

    @POST("personas")
    Call<PersonaAPAAV> crearPersona(@Body PersonaAPAAV  personaAPAAV);
}
