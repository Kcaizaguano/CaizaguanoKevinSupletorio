package com.uta.caizaguanokevinsupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import com.uta.caizaguanokevinsupletorio.Datos.TareaHelperKDCC;
import com.uta.caizaguanokevinsupletorio.Datos.UsuariosHelperKDCC;
import com.uta.caizaguanokevinsupletorio.Entidades.Tarea;

import java.util.ArrayList;

public class RegistrarTareaActivityKDCC extends AppCompatActivity {

    EditText editTextTarea, editTextNotas;
    Spinner spinnerTipo;
    String tipo ;
    ArrayList<String> op = new ArrayList<String>();
    String cedula;
    String tarea_;
    String _notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tarea_kdcc);

        cedula = getIntent().getExtras().getString("cedula");
        tarea_= getIntent().getExtras().getString("tarea");
        _notas= getIntent().getExtras().getString("notas");

        editTextTarea = findViewById(R.id.editTextTextTarea);
        editTextNotas = findViewById(R.id.editTextTextNotas);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        editTextTarea.setText(tarea_);
        editTextNotas.setText(_notas);
        op.add("Personal");
        op.add("Negocios");

        ArrayAdapter adp = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,op);
        spinnerTipo.setAdapter(adp);
        spinnerTipo.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipo = (String) spinnerTipo.getAdapter().getItem(i);

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

            case R.id.itemX:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void guardarTarea() {
        String tarea = editTextTarea.getText().toString();
        String notas = editTextNotas.getText().toString();


        try {
            TareaHelperKDCC tareahelper = new TareaHelperKDCC(this, "tareasDB",null,1);
            SQLiteDatabase sql = tareahelper.getWritableDatabase();
            ContentValues lstvalores = new ContentValues();
            lstvalores.put("Cedula",cedula);
            lstvalores.put("Tarea",tarea);
            lstvalores.put("Notas",notas);
            lstvalores.put("Tipo",tipo);
            sql.insert("Tareas", null,lstvalores);
            sql.close();
            Toast.makeText(this,"Insertado con exito", Toast.LENGTH_SHORT).show();
            finish();

        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }



    public void actualizar (){

        TareaHelperKDCC tareasHelper = new TareaHelperKDCC(this
                ,"tareasDB",null,1);

        SQLiteDatabase sql = tareasHelper.getWritableDatabase();

        String tarea = editTextTarea.getText().toString();
        String notas = editTextNotas.getText().toString();
        ContentValues lstvalores = new ContentValues();
        lstvalores.put("Cedula",cedula);
        lstvalores.put("Tarea",tarea);
        lstvalores.put("Notas",notas);
        lstvalores.put("Tipo",tipo);

       // int cantidad = sql.update("Tareas",lstvalores,"Codigo="+ codigo,null);
        sql.close();

    }


    public  void borrarTarea( View view){


        try {


            String tareA = editTextTarea.getText().toString();

            TareaHelperKDCC tareaHelperKDCCHelper= new TareaHelperKDCC(this
                    ,"tareasDB",null,1);
            SQLiteDatabase sql = tareaHelperKDCCHelper.getReadableDatabase();
            String consulta = "SELECT Codigo FROM Tareas  WHERE Tarea=" + tareA ;

            Cursor cursor = sql.rawQuery(consulta,null);

            if ( cursor.moveToFirst()){

                Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "No se  encotraron registrso en la tabla ",
                        Toast.LENGTH_SHORT).show();
            }

            sql.close();

        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }
}