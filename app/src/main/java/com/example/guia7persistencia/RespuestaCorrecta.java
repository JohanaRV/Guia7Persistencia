package com.example.guia7persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.guia7persistencia.MainActivity.KEY_RANDOM;
import static com.example.guia7persistencia.MainActivity.ModificarJugador;

public class RespuestaCorrecta extends AppCompatActivity {

    TextView txtRespuestaCorrecta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_correcta);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtRespuestaCorrecta = findViewById(R.id.txtRespuestaCorrecta);
        getDatos();
    }

    private void getDatos(){
        txtRespuestaCorrecta.setText(Integer.toString(ModificarJugador.getInt(KEY_RANDOM, 0)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                this.finish();
            }break;
        }
        return super.onOptionsItemSelected(item);
    }
}
