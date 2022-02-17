package com.uta.caizaguanokevinsupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegistrarTareaActivityKDCC extends AppCompatActivity {

    EditText editTextTarea, editTextNotas;
    Spinner spinnerTipo;
    ArrayList<String> op = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tarea_kdcc);

        editTextTarea = findViewById(R.id.editTextTextTarea);
        editTextNotas = findViewById(R.id.editTextTextNotas);
        spinnerTipo = findViewById(R.id.spinnerTipo);

        op.add("Personal");
        op.add("Negocios");

        ArrayAdapter adp = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,op);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuregistro,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.itemVisto:
                guardarTarea();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void guardarTarea() {
        String tarea = editTextTarea.getText().toString();
        String notas = editTextNotas.getText().toString();


    }
}