package com.controledecontas.functionalities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.controledecontas.AdicionarDespesa;
import com.controledecontas.AdicionarPagamento;
import com.controledecontas.BalancoMensal;
import com.controledecontas.ConsultarDespesas;
import com.controledecontas.R;

public class Inicio extends Fragment {

    private FrameLayout adicionarDespesa;
    private FrameLayout adicionarPagamento;
    private FrameLayout consultarDespesas;
    private FrameLayout balancoMensal;
    private ImageView settings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inicio,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        iniciarObjetos();
        setAdicionarDespesa();
        setAdicionarPagamento();
        setBalancoMensal();
        setConsultarDespesas();
        setSettings();
    }

    private void iniciarObjetos(){
        adicionarDespesa  = (FrameLayout) getActivity().findViewById(R.id.adicionarDespesa);
        adicionarPagamento = (FrameLayout) getActivity().findViewById(R.id.adicionarPagamento);
        consultarDespesas = (FrameLayout) getActivity().findViewById(R.id.consultarDespesa);
        balancoMensal = (FrameLayout) getActivity().findViewById(R.id.balncoMensal);
        settings = (ImageView) getActivity().findViewById(R.id.settings);
    }

    private void setAdicionarDespesa(){
        adicionarDespesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AdicionarDespesa.class));
            }
        });
    }

    private void setAdicionarPagamento(){
        adicionarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getContext(), AdicionarPagamento.class));
            }
        });
    }

    private void setConsultarDespesas(){
        consultarDespesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getContext(), ConsultarDespesas.class));
            }
        });
    }

    private void setBalancoMensal(){
        balancoMensal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getContext(), BalancoMensal.class));
            }
        });
    }

    private void setSettings(){
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
