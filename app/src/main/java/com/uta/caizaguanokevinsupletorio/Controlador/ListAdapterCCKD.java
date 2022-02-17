package com.uta.caizaguanokevinsupletorio.Controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uta.caizaguanokevinsupletorio.Entidades.Tarea;
import com.uta.caizaguanokevinsupletorio.R;

import java.util.List;

public class ListAdapterCCKD  extends ArrayAdapter<Tarea>{

    private List<Tarea>  mlist;
    private  Context mcontext;
    private  int resourceLayout;

    public ListAdapterCCKD(@NonNull Context context, int resource, @NonNull List<Tarea> objects) {
        super(context, resource, objects);
        this.mlist = objects;
        this.mcontext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(mcontext).inflate(resourceLayout,null);

        Tarea  tarea = mlist.get(position);
        TextView tareaNombre = view.findViewById(R.id.textViewTarea);
        tareaNombre.setText(tarea.getTarea());

        TextView notasNombre = view.findViewById(R.id.textViewNotas);
        notasNombre.setText(tarea.getDescripcion());



        return  view;

    }
}
