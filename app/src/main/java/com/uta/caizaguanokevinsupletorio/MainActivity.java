package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
}