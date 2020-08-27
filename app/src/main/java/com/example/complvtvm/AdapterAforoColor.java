package com.example.complvtvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static android.content.Context.MODE_PRIVATE;
import static com.example.complvtvm.R.color.rojonegro;

public class AdapterAforoColor extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<String> horarios;




    public AdapterAforoColor(@NonNull Context context, int resource, @NonNull ArrayList<String> horarios) {
        super(context, resource, horarios);

        this.context = context;
        this.resource = resource;
        this.horarios = horarios;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // lo metemos dentro del if para que no cree las vistat cada vez y reutilize el codigo
        if(convertView == null) {
            // creamos la vista con el metodo inflater
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource, parent, false); // muy importante el false si no se pone puede fallar
        }


        TextView textView = convertView.findViewById(R.id.mi_item);
        textView.setText(horarios.get(position));

        BoxActivity boxActivity = new BoxActivity();
        HomeCarmeloActivity homeCarmeloActivity = new HomeCarmeloActivity();
        int aforo = homeCarmeloActivity.nAforo;

        textView.setTextColor(Color.RED);






        //textView.setTextColor(Color.RED);









        return convertView;
    }


}
