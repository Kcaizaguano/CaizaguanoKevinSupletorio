package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.uta.caizaguanokevinsupletorio.Datos.UsuariosHelperKDCC;

public class RegistroActivityKDCC extends AppCompatActivity {

    EditText editTextCedula, editTextNombre, editTextContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_kdcc);

        editTextCedula = findViewById(R.id.editTextTextCedulaRegistro);
        editTextContrasenia = findViewById(R.id.editTextTextContraseñaRegistro);
        editTextNombre = findViewById(R.id.editTextTextNombreRegistro);
    }

    public  void registrar(View view)
    {
        String cedula = editTextCedula.getText().toString();
        String contrasenia = editTextContrasenia.getText().toString();
        String nombre = editTextNombre.getText().toString();
        try {
            UsuariosHelperKDCC usuariohelper = new UsuariosHelperKDCC(this, "usuariosDB",null,1);
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