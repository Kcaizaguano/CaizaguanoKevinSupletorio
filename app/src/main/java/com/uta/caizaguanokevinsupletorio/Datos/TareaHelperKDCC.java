package com.uta.caizaguanokevinsupletorio.Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TareaHelperKDCC extends SQLiteOpenHelper {

    private  String createTable_Tareas = "CREATE TABLE Tareas" +
            "(Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Cedula TEXT," +
            "Tarea TEXT," +
            "Tipo TEXT," +
            "Notas TEXT)";



    public TareaHelperKDCC(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTable_Tareas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Tareas");
        db.execSQL(createTable_Tareas);
    }
}
