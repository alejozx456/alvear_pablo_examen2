package com.example.proyectofactura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginPAAV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_paav);
    }
    public void EntrarRegistroPAAV(View view){
        Intent i = new Intent(this,RegistroPAAV.class);
        startActivity(i);
    }
}