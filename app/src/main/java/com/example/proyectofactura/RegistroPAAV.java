package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroPAAV extends AppCompatActivity {

    public ListView listaUsuarios;
    EditText email;
    EditText clave;
    EditText cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paav);

        listaUsuarios=findViewById(R.id.IdListadeUsuariosPAAV);
        email=findViewById(R.id.IdIngresarEmailPAAV);
        clave=findViewById(R.id.IdIngresarPasswordPAAV);
        cedula=findViewById(R.id.IdIngresarCedulaPAAV);

    }

    public void crearPersonaPAAV(){
        String emailregistro=email.getText().toString();
        String claveregistro=clave.getText().toString();
        String cedularegistro=cedula.getText().toString();
        PersonaAPAAV personaAPAAV=new PersonaAPAAV();
        personaAPAAV.email=emailregistro;
        personaAPAAV.clave=claveregistro;
        personaAPAAV.ced=cedularegistro;
        // Call <List<ProductoPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getProductos();
        Call<PersonaAPAAV> call=RetrofitClientPAAV.getInstance().getMyApiPAAV().crearPersona(personaAPAAV);
        call.enqueue(new Callback<PersonaAPAAV>() {
            @Override
            public void onResponse(Call<PersonaAPAAV> call, Response<PersonaAPAAV> response) {
               

            }

            @Override
            public void onFailure(Call<PersonaAPAAV> call, Throwable t) {

            }
        });

    }


    public void ObtenerPersonasPAAV(View view){

        Call<List<PersonaPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getPersonas();
        call.enqueue(new Callback<List<PersonaPAAV>>() {
            @Override
            public void onResponse(Call<List<PersonaPAAV>> call, Response<List<PersonaPAAV>> response) {
                List<PersonaPAAV> personaPAAVS=response.body();
                String[]numPersonas=new String[personaPAAVS.size()];
                for (int i = 0; i< personaPAAVS.size(); i++){
                    numPersonas[i]= personaPAAVS.get(i).getEmail();
                }
                listaUsuarios.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,numPersonas));
            }

            @Override
            public void onFailure(Call<List<PersonaPAAV>> call, Throwable t) {

            }
        });
    }
}