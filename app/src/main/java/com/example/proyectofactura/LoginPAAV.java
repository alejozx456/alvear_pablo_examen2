package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    public void ingresarMain(View view){
        Intent i = new Intent(this,MainActivityPAAV.class);
        startActivity(i);
    }


    public void EntrarRegistroPAAV(View view){
        Intent i = new Intent(this,RegistroPAAV.class);
        startActivity(i);
    }
}