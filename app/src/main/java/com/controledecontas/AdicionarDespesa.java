package com.controledecontas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.controledecontas.generalfunctions.FullScreen;

import java.util.ArrayList;
import java.util.List;

public class AdicionarDespesa extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText despesa;
    private EditText valor;
    private Spinner tipo;
    private EditText dataInicial;
    private EditText dataFinal;
    private CheckBox recorrente;
    private Dialog dialog;
    private TextView vincularPessoas;
    private LinearLayout llPessoas;
    private Button cadastrarDespesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FullScreen(this);
        setContentView(R.layout.activity_adicionar_despesa);
        iniciarObjetos();
        setToolbar();
        setTipo();
        setRecorrente();
        setCadastrarDespesa();
    }

    private void iniciarObjetos(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        despesa = (EditText) findViewById(R.id.despesa);
        valor = (EditText) findViewById(R.id.valor);
        tipo = (Spinner) findViewById(R.id.tipo);
        dataInicial = (EditText) findViewById(R.id.dataInicial);
        dataFinal = (EditText) findViewById(R.id.dataFinal);
        recorrente = (CheckBox) findViewById(R.id.recorrente);
        vincularPessoas = (TextView) findViewById(R.id.vincularPessoas);
        llPessoas = (LinearLayout) findViewById(R.id.llPessoas);
        cadastrarDespesa = (Button) findViewById(R.id.cadastrarDespesa);
    }

    private void setToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void setTipo(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getItens());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        tipo.setAdapter(adapter);
    }

    private List<String> getItens(){
        List<String> itens = new ArrayList<String>();
        itens.add("Tipo");
        itens.add("Água");
        itens.add("Luz");
        itens.add("Telefone");
        itens.add("Internet");
        itens.add("Lazer");
        itens.add("Outros");
        return itens;
    }

    private void setRecorrente(){
        recorrente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!recorrente.isChecked()) dataFinal.setVisibility(View.VISIBLE);
                else dataFinal.setVisibility(View.GONE);
            }
        });
    }

    private void setCadastrarDespesa(){
        cadastrarDespesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregar();
                verificar();
            }
        });
    }

    private void carregar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_main,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();
    }

    private void verificar(){
        if(despesa.getText().length() == 0 || despesa.getText().toString().equals(" ")) setError(despesa);
        if(valor.getText().length() == 0 || valor.getText().toString().equals(" ")) setError(valor);
        if(tipo.getSelectedItem().toString().equals("Tipo")) dialog.dismiss();
        if (dataInicial.getText().length() == 0 || dataInicial.getText().toString().equals(" ")) setError(dataInicial);
        if(recorrente.isChecked() && (dataFinal.getText().length() == 0 || dataFinal.getText().toString().equals(" "))) setError(dataFinal);

    }

    private void setError(EditText editText){
        dialog.dismiss();
        editText.setError("Este campo precisa ser preenchido!!");
        editText.requestFocus();
    }




}