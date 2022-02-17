package com.uta.caizaguanokevinsupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.uta.caizaguanokevinsupletorio.Controlador.PagerController;
import com.uta.caizaguanokevinsupletorio.Datos.TareaHelperKDCC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListaTareasActivityKDCC extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2;
    PagerController pagerAdapter;
    String cedula;
    private ListView listViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas_kdcc);
        cedula = getIntent().getExtras().getString("cedula");
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        pagerAdapter =  new PagerController(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        listViewDatos = findViewById(R.id.listViewDatos);


        //cargar();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0){
                    //pagerAdapter.notifyDataSetChanged();
                    //Toast.makeText(ListaTareasActivityKDCC.this, "personas", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ListaTareasActivityKDCC.this,ListTareasActivity.class);
                    intent.putExtra("cedula",cedula);
                    intent.putExtra("negocio","");

                    startActivity(intent);
                }

                if (tab.getPosition() == 1){
                    //pagerAdapter.notifyDataSetChanged();
                    Intent intent = new Intent(ListaTareasActivityKDCC.this,ListTareasActivity.class);
                    intent.putExtra("cedula",cedula);
                    intent.putExtra("negocio","negocio");
                    startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private List<String> cargarDatos() {
        List<String> lista = new ArrayList<String>();

        TareaHelperKDCC tareasHelper = new TareaHelperKDCC(this,"tareasDB",null,1);
        SQLiteDatabase sql = tareasHelper.getReadableDatabase();

        String consulta = "SELECT Tarea,Notas FROM Tareas  WHERE Cedula=" + cedula;
        Cursor cursor =  sql.rawQuery(consulta, null);
        if (cursor.moveToFirst()){
            do {
                lista.add(cursor.getString(0));
            }while (cursor.moveToNext());

        }

        return  lista;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menukdcc,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAgregar:
                Intent intent = new Intent(this,RegistrarTareaActivityKDCC.class);
                intent.putExtra("cedula",cedula);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cargar(){

        try {

            ArrayList<String> list = new ArrayList<>();
            TareaHelperKDCC tareasHelper = new TareaHelperKDCC(this,"tareasDB",null,1);
            SQLiteDatabase sql = tareasHelper.getReadableDatabase();

            String consulta = "SELECT Tarea,Notas FROM Tareas  WHERE Cedula=" + cedula;
            Cursor cursor =  sql.rawQuery(consulta, null);
            if (cursor.moveToFirst()){
                do {
                    list.add(cursor.getString(0) + "  "+
                            cursor.getString(1));
                }while (cursor.moveToNext());

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, list);

            listViewDatos.setAdapter(adapter);

        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    public  void  mostrarTareas(View view){
        Intent intent = new Intent(this,ListTareasActivity.class);
        intent.putExtra("cedula",cedula);
        intent.putExtra("negocio","*");
        startActivity(intent);
    }
}