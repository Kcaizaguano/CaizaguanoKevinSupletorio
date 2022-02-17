package com.uta.caizaguanokevinsupletorio.Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosHelperKDCC extends SQLiteOpenHelper {

    private  String createTable_Usuario = "CREATE TABLE Usuarios" +
            "(Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Cedula TEXT," +
            "Contrasenia TEXT," +
            "Nombre TEXT)";
    public UsuariosHelperKDCC(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTable_Usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(createTable_Usuario);
    }
}
