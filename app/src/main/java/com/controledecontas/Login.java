package com.controledecontas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.controledecontas.generalfunctions.FullScreen;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FullScreen(this);
        setContentView(R.layout.activity_login);
    }
}