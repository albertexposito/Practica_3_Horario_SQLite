package com.yoqsetioxdxd.practica_3_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by ALUMNEDAM on 01/12/2016.
 */

public class    HorariosSQLiteHelper extends SQLiteOpenHelper {
    private String[] sentencias = new String[35];

    public HorariosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLES

        sentencias[0] = "CREATE TABLE Profes (id_profe INTEGER, nombre_profe TEXT)";
        sentencias[1] = "CREATE TABLE Modulos (id_modulo INTEGER, codigo_modulo TEXT, nombre_modulo TEXT, id_profe TEXT)";
        sentencias[2] = "CREATE TABLE Horarios (id_horari INTEGER, grup TEXT, id_modulo INTEGER, hora_inici TEXT, hora_final TEXT, dia_setmana INTEGER)";

        //INSERT INTOs

        sentencias[3] = "INSERT INTO Profes VALUES (1, 'Jorge');";
        sentencias[4] = "INSERT INTO Profes VALUES (2, 'Josefa');";
        sentencias[5] = "INSERT INTO Profes VALUES (3, 'Leo');";
        sentencias[6] = "INSERT INTO Profes VALUES (4, 'Lluis');";
        sentencias[7] = "INSERT INTO Profes VALUES (5, 'Marta');";

        sentencias[8]="INSERT INTO Modulos VALUES (1, 'M05/M02/M06','Algo de Jorge', 1)";
        sentencias[9]="INSERT INTO Modulos VALUES (2, 'M03','Programacion', 2)";
        sentencias[10]="INSERT INTO Modulos VALUES (3, 'M07','Diseno de interfaces', 3)";
        sentencias[11]="INSERT INTO Modulos VALUES (4, 'M08','Desarrollo Android', 4)";
        sentencias[12]="INSERT INTO Modulos VALUES (5, 'M09','Threads', 1)";
        sentencias[13]="INSERT INTO Modulos VALUES (6, 'M10','Erps', 5)";
        sentencias[14]="INSERT INTO Modulos VALUES (7, 'TUTORIA','', 2)";

        sentencias[15] = "INSERT INTO Horarios VALUES (1,'A1/A2',3,'15:00:00','17:59:59',2)";
        sentencias[16] = "INSERT INTO Horarios VALUES (2,'A1/A2',7,'18:20:00','19:19:59',2)";
        sentencias[17] = "INSERT INTO Horarios VALUES (3,'A2',2,'19:20:00','21:20:00',2)";
        sentencias[18] = "INSERT INTO Horarios VALUES (4,'A1',2,'15:00:00','16:59:59',3)";
        sentencias[19] = "INSERT INTO Horarios VALUES (5,'A2',4,'15:00:00','16:59:59',3)";
        sentencias[20] = "INSERT INTO Horarios VALUES (6,'A1/A2',6,'17:00:00','19:19:59',3)";
        sentencias[21] = "INSERT INTO Horarios VALUES (7,'A1/A2',1,'19:20:00','21:20:00',3)";
        sentencias[22] = "INSERT INTO Horarios VALUES (8,'A1/A2',1,'16:00:00','16:59:59',4)";
        sentencias[23] = "INSERT INTO Horarios VALUES (9,'A1',5,'17:00:00','19:19:59',4)";
        sentencias[24] = "INSERT INTO Horarios VALUES (11,'A1',2,'19:20:00','21:20:00',4)";
        sentencias[25] = "INSERT INTO Horarios VALUES (10,'A2',4,'17:00:00','19:19:59',4)";
        sentencias[26] = "INSERT INTO Horarios VALUES (12,'A2',5,'19:20:00','20:20:00',4)";
        sentencias[27] = "INSERT INTO Horarios VALUES (13,'A1',5,'15:00:00','15:59:59',5)";
        sentencias[28] = "INSERT INTO Horarios VALUES (14,'A1',4,'16:00:00','17:59:59',5)";
        sentencias[29] = "INSERT INTO Horarios VALUES (15,'A2',2,'16:00:00','17:59:59',5)";
        sentencias[30] = "INSERT INTO Horarios VALUES (16,'A1/A2',1,'18:20:00','21:20:00',5)";
        sentencias[31] = "INSERT INTO Horarios VALUES (17,'A1/A2',6,'15:00:00','16:59:00',6)";
        sentencias[32] = "INSERT INTO Horarios VALUES (18,'A1',4,'17:00:00','19:19:59',6)";
        sentencias[33] = "INSERT INTO Horarios VALUES (19,'A2',5,'17:00:00','19:19:59',6)";
        sentencias[34] = "INSERT INTO Horarios VALUES (20,'A1/A2',1,'19:20:00','21:20:00',6)";

        //SE EJECUTAN LAS SENTENCIAS AL CREAR LA BASE DE DATOS POR PRIMERA VEZ
        for (int i = 0; i < sentencias.length; i++) {
            db.execSQL(sentencias[i]);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //EN CASO DE ACTUALIZAR LA VERSION DE LA BASE DE DATOS SE EJECUTARIA ESTE METODO.

    }
}
