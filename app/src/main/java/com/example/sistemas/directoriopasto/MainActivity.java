package com.example.sistemas.directoriopasto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sistemas.directoriopasto.api.DatosApi;
import com.example.sistemas.directoriopasto.models.Directorio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDirectorio;
    private RecyclerViewAdaptador adaptadorDirectorio;

    public final static String TAG="DIRECTORIO TURISTICO";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit= new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        obtenerDatos();


        recyclerViewDirectorio=(RecyclerView)findViewById(R.id.recycler1);
        recyclerViewDirectorio.setLayoutManager(new LinearLayoutManager(this));

    }

    public void obtenerDatos(){

        DatosApi service = retrofit.create(DatosApi.class);
        Call<List<Directorio>> directorioCall=service.obtenerListaDirectorio();

        directorioCall.enqueue(new Callback<List<Directorio>>() {
            @Override
            public void onResponse(Call<List<Directorio>> call, Response<List<Directorio>> response) {

                if(response.isSuccessful()){

                    List listaDirectorio= response.body();
                    for (int i=0;i<listaDirectorio.size();i++){

                        Directorio m= (Directorio) listaDirectorio.get(i);
                        adaptadorDirectorio = new RecyclerViewAdaptador(listaDirectorio);
                        recyclerViewDirectorio.setAdapter(adaptadorDirectorio);
                    }

                }else{

                    Log.e(TAG,"onResponse" + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<Directorio>> call, Throwable t) {

                Log.e(TAG,"onFailure" + t.getMessage());

            }
        });

    }


}
