package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPAAV extends AppCompatActivity {
EditText email;
EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_paav);
        email=findViewById(R.id.IdEmailPersonaPAAV);
        password=findViewById(R.id.IdPasswordPersonaPAAV);



    }

    public boolean verificarPasswordPAAV(String dato){
        return  dato.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,10}$"); //Validar contraseña
    }


    public void ingresarMain(View view){
        String passwordverificado=password.getText().toString();
        if(verificarPasswordPAAV(passwordverificado)){
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,MainActivityPAAV.class);
            startActivity(i);
        }else {
            Toast.makeText(this,"Tipo de contraseña invalida",Toast.LENGTH_LONG).show();
        }



    }


    public void EntrarRegistroPAAV(View view){
        Intent i = new Intent(this,RegistroPAAV.class);
        startActivity(i);
    }
}