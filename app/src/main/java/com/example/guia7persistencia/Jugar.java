package com.example.guia7persistencia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import static com.example.guia7persistencia.MainActivity.KEY_Jugador;
import static com.example.guia7persistencia.MainActivity.KEY_SCORE;
import static com.example.guia7persistencia.MainActivity.KEY_Intentos;
import static com.example.guia7persistencia.MainActivity.KEY_RANDOM;
import static com.example.guia7persistencia.MainActivity.ModificarJugador;

public class Jugar extends AppCompatActivity {
    String jugador;
    int score, intentos, random, puntajeActual;
    TextView txtJugador, txvScore, txvIntentos, txtPista, txtPistaPista;
    MaterialEditText EdtNumeroCorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        /*txtJugador = findViewById(R.id.txtJug);
        txvScore = findViewById(R.id.txtPuntaje);
        txvIntentos = findViewById(R.id.txtIntentos);
        txtPista = findViewById(R.id.txvPista);
        txtPistaPista = findViewById(R.id.txvPistaPista);
        EdtNumeroCorrecto = findViewById(R.id.EdtNumeroCorrecto);*/


        IniciarVariables();
        getDatos();

    }


    public void OnClickJugar(View v) {
        int numUsuario = 0;
        if (EdtNumeroCorrecto.length() == 0 || Integer.parseInt(EdtNumeroCorrecto.getText().toString()) < 1 ||
                Integer.parseInt(EdtNumeroCorrecto.getText().toString()) > 10) {
            Toast.makeText(this, "Digite un número del 1 al 10", Toast.LENGTH_SHORT).show();
        } else {
            numUsuario = Integer.parseInt(EdtNumeroCorrecto.getText().toString());
            intentos++;
            String ni = Integer.toString(intentos);
            txvIntentos.setText(ni);

            SharedPreferences.Editor editorConfiguracion = ModificarJugador.edit();
            editorConfiguracion.putInt(KEY_Intentos, intentos);
            editorConfiguracion.commit();

            if (numUsuario == random) {
                new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("Ha ganado el juego")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                puntajeActual = 10 - intentos;
                                random = (int) ((Math.random() * 10) + 1);

                                SharedPreferences.Editor editorConfiguracionWin = ModificarJugador.edit();
                                editorConfiguracionWin.putInt(KEY_SCORE, score + puntajeActual);
                                editorConfiguracionWin.putInt(KEY_Intentos, 0);
                                editorConfiguracionWin.putInt(KEY_RANDOM, random);
                                editorConfiguracionWin.commit();
                                finish();
                            }
                        }).show();

            } else {
                txtPistaPista.setText(R.string.lblPista);
                if (numUsuario < random) {
                    txtPista.setText(R.string.lblMayor);
                    txtPista.setTextColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    txtPista.setText(R.string.lblMenor);
                    txtPista.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
            }
        }
    }


    private void getDatos() {
        txtJugador.setText(jugador);
        txvScore.setText(Integer.toString(score));
        txvIntentos.setText(Integer.toString(intentos));
    }

    private void IniciarVariables(){
        txtJugador = findViewById(R.id.txtJug);
        txvScore = findViewById(R.id.txtPuntaje);
        txvIntentos = findViewById(R.id.txtIntentos);
        txtPista = findViewById(R.id.txvPista);
        txtPistaPista = findViewById(R.id.txvPistaPista);
        EdtNumeroCorrecto = findViewById(R.id.EdtNumeroCorrecto);

        jugador = ModificarJugador.getString(KEY_Jugador, "");
        score = ModificarJugador.getInt(KEY_SCORE, 0);
        intentos = ModificarJugador.getInt(KEY_Intentos, 0);
        random = ModificarJugador.getInt(KEY_RANDOM, 0);
    }
}
