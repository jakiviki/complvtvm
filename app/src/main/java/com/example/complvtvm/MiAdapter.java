package com.example.complvtvm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MiAdapter extends ArrayAdapter {

    Context context;
    int imagenLayout;
    ArrayList<UsuarioFecha> usuarioFecha;

    public MiAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UsuarioFecha> objects) {
        super(context, resource, objects);
        this.context = context;
        imagenLayout = resource;
        usuarioFecha = objects;
    }

    // creamos el getView este metodo es el que devuelve el layout de la lista ya creado

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // lo metemos dentro del if para que no cree las vistat cada vez y reutilize el codigo
        if(convertView == null) {
            Log.d("main", "veces " + position);
            // creamos la vista con el metodo inflater
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(imagenLayout, parent, false); // muy importante el false si no se pone puede fallar
        }
        // rellenamos la vista con mi array (findbyId solo funciona en Activitys al ser una class lo busco en la vista)
        ImageView imageView = convertView.findViewById(R.id.id_imagen_usuario);
        imageView.setImageResource(usuarioFecha.get(position).imagen);
        // y ahora el nombre
        TextView textView = convertView.findViewById(R.id.id_nombre_usuario);
        textView.setText(usuarioFecha.get(position).nombre);


        return convertView;
    }
}
