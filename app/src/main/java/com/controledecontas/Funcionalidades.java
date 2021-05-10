package com.controledecontas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.controledecontas.functionalities.Inicio;
import com.controledecontas.functionalities.SetFragment;
import com.controledecontas.generalfunctions.FullScreen;

public class Funcionalidades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FullScreen(this);
        setContentView(R.layout.activity_funcionalidades);
        new SetFragment(getSupportFragmentManager(),new Inicio(),R.id.setFuncionalidades);
    }
}