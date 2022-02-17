package com.uta.caizaguanokevinsupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        spinnerTipo.setAdapter(adp);
        spinnerTipo.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String elem = (String) spinnerTipo.getAdapter().getItem(i);
                Toast.makeText(RegistrarTareaActivityKDCC.this,elem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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