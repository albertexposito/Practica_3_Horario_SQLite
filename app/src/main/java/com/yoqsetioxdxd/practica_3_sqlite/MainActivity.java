package com.yoqsetioxdxd.practica_3_sqlite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SQLiteDatabase db;

    private TextView tvNombre;
    private TextView tvGrupo;
    private TextView tvAsignatura;
    private TextView tvProfesor;

    private Button btnActualizar;
    private Button btnConfig;

    private String nombre;
    private boolean isGrupoA1;
    private String grupo = "A1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvAsignatura = (TextView) findViewById(R.id.TV_asignatura);
        tvProfesor = (TextView) findViewById(R.id.TV_profesor);
        tvNombre = (TextView) findViewById(R.id.TV_mostrarNombre);
        tvGrupo = (TextView) findViewById(R.id.TV_mostrarGrupo);

        btnActualizar = (Button) findViewById(R.id.BTN_actualizar);
        btnActualizar.setOnClickListener(this);
        btnConfig = (Button) findViewById(R.id.BTN_config);
        btnConfig.setOnClickListener(this);

        HorariosSQLiteHelper usdbh =
                new HorariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getReadableDatabase();
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.BTN_config) {
            Intent intent = new Intent(this, Configuracion.class);
            startActivityForResult(intent, 1);
        }

        if (v.getId() == R.id.BTN_actualizar) {

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatData = new SimpleDateFormat("HH:mm:ss");
            String hora = formatData.format(cal.getTime());
            int dia = new GregorianCalendar().get(Calendar.DAY_OF_WEEK);

            if (isGrupoA1) {
                grupo = "A1";
            } else {
                grupo = "A2";
            }

            tvNombre.setText(nombre);
            tvGrupo.setText("GRUPO "+grupo);

            //CONSULTA SQL
            String consulta = "SELECT codigo_modulo, nombre_modulo, nombre_profe " +
                    "FROM Horarios, Profes, Modulos " +
                    "WHERE Horarios.id_modulo == Modulos.id_modulo AND Modulos.id_profe == Profes.id_profe AND " +
                    "'" + hora + "' BETWEEN hora_inici AND hora_final AND (grup LIKE '" + grupo + "' OR grup LIKE 'A1/A2') AND dia_setmana == " + dia;


            //SE CREA EL CURSOR
            Cursor c = db.rawQuery(consulta, null);




            //SE EXTRAEN LOS ELEMENTOS DEL CURSOR EN VARIABLES
            if (c.moveToFirst()) {
                String codiModul = c.getString(0);
                String nomModul = c.getString(1);
                String nomProfe = c.getString(2);


                tvAsignatura.setText("Asignatura: " + codiModul + " | " + nomModul);
                tvProfesor.setText("Professor: " + nomProfe);
            }

        }
    }

    /**
     * EXTRAE LOS DATOS DE SHARED PREFERENCES, SI NO HAY TE INDICA QUE VAYAS A LA PANTALLA CONFIGURACION.
     */
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.nombre = preferences.getString("NOMBRE", "Vé a configuración y añade tu nombre");
        this.isGrupoA1 = preferences.getBoolean("GRUPA1", true);
    }

    public void onRadioButtonClicked(View view) {

    }

}


