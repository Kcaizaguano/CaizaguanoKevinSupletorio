package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.uta.caizaguanokevinsupletorio.Controlador.ListAdapterCCKD;
import com.uta.caizaguanokevinsupletorio.Entidades.Tarea;

import java.util.ArrayList;
import java.util.List;

public class ListTareasActivity extends AppCompatActivity {

    private ListView listViewDatos;
    private List<Tarea> mlista = new ArrayList<Tarea>();
    ListAdapterCCKD mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tareas);

        listViewDatos = findViewById(R.id.listViewDatos);
        mlista.add(new Tarea("185624","Estudiar","matematicas , fisica","personal"));

      mAdpater = new ListAdapterCCKD (ListTareasActivity.this,R.layout.item_rouwkdcc,mlista);

        listViewDatos.setAdapter(mAdpater);
    }
}