package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.uta.caizaguanokevinsupletorio.Controlador.ListAdapterCCKD;
import com.uta.caizaguanokevinsupletorio.Datos.TareaHelperKDCC;
import com.uta.caizaguanokevinsupletorio.Entidades.Tarea;

import java.util.ArrayList;
import java.util.List;

public class ListTareasActivity extends AppCompatActivity {

    private ListView listViewDatos;
    private List<Tarea> mlista = new ArrayList<Tarea>();
    ListAdapterCCKD mAdpater;
    String cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tareas);
        cedula = getIntent().getExtras().getString("cedula");

        listViewDatos = findViewById(R.id.listViewDatos);


        TareaHelperKDCC tareasHelper = new TareaHelperKDCC(this,"tareasDB",null,1);
        SQLiteDatabase sql = tareasHelper.getReadableDatabase();

        String consulta = "SELECT Cedula,Tarea,Tipo,Notas FROM Tareas  WHERE Cedula=" + cedula;
        Cursor cursor =  sql.rawQuery(consulta, null);
        if (cursor.moveToFirst()){
            do {

                Tarea t = new Tarea();
                t.setCedula(cursor.getString(0));
                t.setTarea(cursor.getString(1));
                t.setTipo(cursor.getString(2));
                t.setDescripcion(cursor.getString(3));
                mlista.add(t);
            }while (cursor.moveToNext());

        }
        /*
        mlista.add(new Tarea("185624","Estudiar","matematicas , fisica","personal"));
        mlista.add(new Tarea("185624","Comer","matematicas , fisica","personal"));
        mlista.add(new Tarea("185624","Dormir","matematicas , fisica","personal"));

         */

      mAdpater = new ListAdapterCCKD (ListTareasActivity.this,R.layout.item_rouwkdcc,mlista);

        listViewDatos.setAdapter(mAdpater);
    }
}