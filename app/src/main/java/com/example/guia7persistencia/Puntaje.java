package com.example.guia7persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.guia7persistencia.MainActivity.KEY_Jugador;
import static com.example.guia7persistencia.MainActivity.KEY_SCORE;
import static com.example.guia7persistencia.MainActivity.ModificarJugador;


public class Puntaje extends AppCompatActivity {
    TextView txtJugadorPuntaje, txtPPuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

        txtJugadorPuntaje = findViewById(R.id.txtJugadorPuntaje);
        txtPPuntaje = findViewById(R.id.txtPPuntaje);
        getDatos();
    }

    private void getDatos(){
        txtJugadorPuntaje.setText(ModificarJugador.getString(KEY_Jugador, ""));
        txtPPuntaje.setText(Integer.toString(ModificarJugador.getInt(KEY_SCORE, 0)));
    }
}
