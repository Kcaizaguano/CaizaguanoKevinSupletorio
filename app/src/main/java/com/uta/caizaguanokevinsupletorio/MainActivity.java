package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        UsuariosHelperKDCC usuarioHelper = new UsuariosHelperKDCC(this,"usuariosDB",null,1);
        SQLiteDatabase sql = usuarioHelper.getReadableDatabase();

        String consulta = "SELECT Cedula,Contrasenia FROM Usuarios  WHERE Cedula=" + usuario;
        Cursor cursor = sql.rawQuery(consulta,null);
        if ( cursor.moveToFirst()){



        }else{
            Toast.makeText(this, "No se  encotraron registros",
                    Toast.LENGTH_SHORT).show();
        }

        sql.close();

    }

    public  void registrar(View view)
    {
        try {
            UsuariosHelperKDCC  usuariohelper = new UsuariosHelperKDCC(this, "usuariosDB",null,1);
            SQLiteDatabase sql = usuariohelper.getWritableDatabase();
            ContentValues lstvalores = new ContentValues();
            lstvalores.put("Cedula","1805349246");
            lstvalores.put("Contrasenia","Kevin123@");
            lstvalores.put("Nombre","Kevin Caizaguano");
            sql.insert("Usuarios", null,lstvalores);
            sql.close();

            Toast.makeText(this,"Insertado con exito", Toast.LENGTH_SHORT).show();


        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}