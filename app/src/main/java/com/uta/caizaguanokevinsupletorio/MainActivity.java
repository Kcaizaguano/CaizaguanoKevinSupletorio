package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.uta.caizaguanokevinsupletorio.Datos.UsuariosHelperKDCC;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsuario = findViewById(R.id.editTextTextusuario);
        editTextContraseña = findViewById(R.id.editTextTextContraseña);

    }

    public  void logiarse (View view)
    {
        String usuario = editTextUsuario.getText().toString();
        String contraseña = editTextContraseña.getText().toString();

    }

    public  void registrar(View view)
    {
        UsuariosHelperKDCC  usuariohelper = new UsuariosHelperKDCC(this, "usuariosDB",null,1);
        SQLiteDatabase sql = usuariohelper.getWritableDatabase();
        ContentValues lstvalores = new ContentValues();



    }
}