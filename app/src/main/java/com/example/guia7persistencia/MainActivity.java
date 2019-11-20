package com.example.guia7persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_Jugador = "Jugador";
    public static final String KEY_SCORE = "SCORE";
    public static final String KEY_Intentos = "Intentos";
    public static final String KEY_RANDOM = "RANDOM";
    public static final String KEY_NEW = "IFNEW";
    public static final String NAME_FILE = "ModificarJugador";
    public static SharedPreferences ModificarJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrearJugador();

    }
    public void onClickDatos(View v){
        Intent i = new Intent(this, Datos.class);
        startActivity(i);
    }

    public void onClickJugar(View v){
        Intent i = new Intent(this, Jugar.class);
        startActivity(i);
    }

    public void onClickVerRespuestaCorrecta(View v){
        Intent i = new Intent(this, RespuestaCorrecta.class);
        startActivity(i);
    }

    public void onClickVerPuntaje(View v){
        Intent i = new Intent(this, Puntaje.class);
        startActivity(i);
    }

    public void onClickVerModificar(View v){
        Intent i = new Intent(this, ModificarJugador.class);
        startActivity(i);
    }

    private void CrearJugador(){
        this.ModificarJugador= getSharedPreferences(NAME_FILE, MODE_PRIVATE);
        if(this.ModificarJugador.getBoolean(KEY_NEW, true)){
            int random = (int) ((Math.random() * 10) + 1);
            SharedPreferences.Editor editorConfiguracion = this.ModificarJugador.edit();
            editorConfiguracion.putString(KEY_Jugador, "Judador 1");
            editorConfiguracion.putInt(KEY_SCORE, 0);
            editorConfiguracion.putInt(KEY_Intentos, 0);
            editorConfiguracion.putInt(KEY_RANDOM, random);
            editorConfiguracion.putBoolean(KEY_NEW, false);
            editorConfiguracion.commit();
        }
    }
}
