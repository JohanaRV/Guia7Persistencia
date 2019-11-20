package com.example.guia7persistencia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import static com.example.guia7persistencia.MainActivity.ModificarJugador;
import static com.example.guia7persistencia.MainActivity.KEY_Jugador;


public class ModificarJugador extends AppCompatActivity {
    MaterialEditText edtModificarJugador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_jugador);

        edtModificarJugador = findViewById(R.id.edtModificarJugador);
        CargarNombre();
    }
    public void OnClickModificarJugador(View v){
        if( ModificarJugador!= null){
            //Obtenemos el editor
            SharedPreferences.Editor editorConfiguracion = ModificarJugador.edit();

            editorConfiguracion.putString(KEY_Jugador, edtModificarJugador.getText().toString());
            editorConfiguracion.commit();
            new AlertDialog.Builder(this).setTitle("¡Éxito!").setMessage("Nombre del jugador guardado...")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();
        }
    }

    private void CargarNombre(){
        String n = ModificarJugador.getString(KEY_Jugador, "");
        edtModificarJugador.setText(n);
    }




}
