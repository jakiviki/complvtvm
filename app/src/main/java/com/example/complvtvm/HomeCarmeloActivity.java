package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeCarmeloActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // creamos el array para mostrar horarios
    ArrayList<String> horarios;
    ListView listView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_carmelo);

        horarios = new ArrayList<>();
        listView = findViewById(R.id.listv_horarios_carmelo);
        btn = findViewById(R.id.btn_añadir_carmelo);

        horarios.add("8:30");
        horarios.add("9:30");
        horarios.add("18:15");
        horarios.add("19:15");
        horarios.add("20:15");
        horarios.add("21:15");


        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void añadirHorarioCarmelo (View v){
        DialogCarmelo dialogCarmelo = new DialogCarmelo();
        dialogCarmelo.show(getSupportFragmentManager(),"nuevo_horario");
    }

    public void nuevoHorario(String hora){
        horarios.add(hora);
        Log.i("hora","la hora que llega es "+hora);

    }
}
