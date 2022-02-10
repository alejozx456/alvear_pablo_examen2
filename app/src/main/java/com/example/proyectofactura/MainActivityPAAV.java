package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivityPAAV extends AppCompatActivity {

public Retrofit retrofit;
    EditText etIdBuscar, etId, etNombre, etTelefono;
    Button btnIdBuscar, btnEliminar, btnTodosBuscar, btnAgregar, btnEditar;
    public ListView listap;
    List<ProductoPAAV> productoPAAVS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listap=findViewById(R.id.IdlistaProductos);
        Intent intent=new Intent(this, MainActivityDetalleProductoPAAV.class);

       // obtenerProductos();
        listap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("nombrep",i);
                startActivity(intent);
            }
        });
    }
    public void obtenerProductos( View view){

        Call <List<ProductoPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getProductos();
        call.enqueue(new Callback<List<ProductoPAAV>>() {
            @Override
            public void onResponse(Call<List<ProductoPAAV>> call, Response<List<ProductoPAAV>> response) {
                List<ProductoPAAV> productoPAAVS =response.body();
                String[] numProductos=new String[productoPAAVS.size()];

                for (int i = 0; i< productoPAAVS.size(); i++){
                    numProductos[i]= productoPAAVS.get(i).getNombre();
                }
                listap.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,numProductos));

            }

            @Override
            public void onFailure(Call<List<ProductoPAAV>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

}