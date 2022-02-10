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

    public boolean verificarCedulaPAAV(String x){
        int suma=0;
        if(x.length()==9){

            return false;
        }else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1))))
                return true;
            else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }

    public void crearPersonaPAAV( View view){
        String emailregistro=email.getText().toString();
        String claveregistro=clave.getText().toString();
        String cedularegistro=cedula.getText().toString();
        PersonaAPAAV personaAPAAV=new PersonaAPAAV();
        personaAPAAV.email=emailregistro;
        personaAPAAV.clave=claveregistro;
        personaAPAAV.ced=cedularegistro;
        if(verificarCedulaPAAV(cedularegistro)){
            // Call <List<ProductoPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getProductos();
            Call<PersonaAPAAV> call=RetrofitClientPAAV.getInstance().getMyApiPAAV().crearPersona(personaAPAAV);
            call.enqueue(new Callback<PersonaAPAAV>() {
                @Override
                public void onResponse(Call<PersonaAPAAV> call, Response<PersonaAPAAV> response) {
                    email.setText("");
                    clave.setText("");
                    cedula.setText("");


                }

                @Override
                public void onFailure(Call<PersonaAPAAV> call, Throwable t) {

                }
            });
        }else {
            Toast.makeText(this,"Cedula Invalida",Toast.LENGTH_LONG).show();
        }


    }


    public void ObtenerPersonasPAAV(View view){

        Call<List<PersonaPAAV>> call= RetrofitClientPAAV.getInstance().getMyApiPAAV().getPersonas();
        call.enqueue(new Callback<List<PersonaPAAV>>() {
            @Override
            public void onResponse(Call<List<PersonaPAAV>> call, Response<List<PersonaPAAV>> response) {
                List<PersonaPAAV> personaPAAVS=response.body();
                String[]numPersonas=new String[personaPAAVS.size()];
                for (int i = 0; i< personaPAAVS.size(); i++){
                    numPersonas[i]= personaPAAVS.get(i).getEmail()+" "+personaPAAVS.get(i).getCed();
                }
                listaUsuarios.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,numPersonas));
            }

            @Override
            public void onFailure(Call<List<PersonaPAAV>> call, Throwable t) {

            }
        });
    }
}