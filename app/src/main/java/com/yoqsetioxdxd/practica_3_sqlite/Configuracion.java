package com.yoqsetioxdxd.practica_3_sqlite;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Configuracion extends AppCompatActivity implements View.OnClickListener {

    private RadioButton radioA1;
    private EditText tvNombre;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        SharedPreferences sharedPreferences = this.getSharedPreferences("KEY", MODE_PRIVATE);
        sharedPreferences.getString("STRING","DEFAULT_VALUE");

        tvNombre = (EditText) findViewById(R.id.ET_nombre);
        radioA1 = (RadioButton) findViewById(R.id.radio_A1);
        radioA1.setChecked(true);

        btnGuardar = (Button) findViewById(R.id.BTN_guardar);
        btnGuardar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.BTN_guardar) {

            String nombre = tvNombre.getText().toString();

            //GUARDAR SHARED PREFERENCES
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("NOMBRE", nombre);
            editor.putBoolean("GRUPA1", radioA1.isChecked());
            editor.commit();
            //

            this.finish();
        }
    }

    public void onRadioButtonClicked(View view) {

    }
}
