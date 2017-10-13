package com.example.sistemas.directoriopasto.api;

import com.example.sistemas.directoriopasto.models.Directorio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 13/10/17.
 */

public interface DatosApi {


    @GET("dnt9-jcdu.json")
    Call<List<Directorio>> obtenerListaDirectorio();
}

