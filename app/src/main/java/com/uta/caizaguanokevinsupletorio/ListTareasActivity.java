package com.uta.caizaguanokevinsupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.uta.caizaguanokevinsupletorio.Controlador.ListAdapterCCKD;
import com.uta.caizaguanokevinsupletorio.Datos.TareaHelperKDCC;
import com.uta.caizaguanokevinsupletorio.Entidades.Tarea;

import java.util.ArrayList;
import java.util.List;

public class ListTareasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewDatos;
    private List<Tarea> mlista = new ArrayList<Tarea>();
    ListAdapterCCKD mAdpater;
    String cedula;
    String negocio ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tareas);
        cedula = getIntent().getExtras().getString("cedula");
        negocio = getIntent().getExtras().getString("negocio");
        listViewDatos = findViewById(R.id.listViewDatos);
        listViewDatos.setOnItemClickListener(this);

        if (negocio.equals("")){

            TareaHelperKDCC tareasHelper = new TareaHelperKDCC(this,"tareasDB",null,1);
            SQLiteDatabase sql = tareasHelper.getReadableDatabase();

            String consulta = "SELECT Cedula,Tarea,Tipo,Notas FROM Tareas  WHERE Tipo='Personal' AND Cedula=" + cedula;
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

        }else{

            TareaHelperKDCC tareasHelper = new TareaHelperKDCC(this,"tareasDB",null,1);
            SQLiteDatabase sql = tareasHelper.getReadableDatabase();

            String consulta = "SELECT Cedula,Tarea,Tipo,Notas FROM Tareas  WHERE Tipo='Negocios' AND Cedula=" + cedula;
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

        }

      mAdpater = new ListAdapterCCKD (ListTareasActivity.this,R.layout.item_rouwkdcc,mlista);

        listViewDatos.setAdapter(mAdpater);
        registerForContextMenu(listViewDatos);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucrudkdcc,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.CrudBorrar:
                Toast.makeText(this, "selecciono borrar", Toast.LENGTH_SHORT).show();

                return  true;
        }

        return super.onContextItemSelected(item);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        ListAdapter la = (ListAdapter) adapterView.getAdapter();

        Toast.makeText(view.getContext(), la.getItem(i).toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,RegistrarTareaActivityKDCC.class);
        intent.putExtra("tarea",mAdpater.getItem(i).getTarea());
        intent.putExtra("notas",mAdpater.getItem(i).getDescripcion());
        intent.putExtra("cedula",cedula);
        startActivity(intent);
    }
}