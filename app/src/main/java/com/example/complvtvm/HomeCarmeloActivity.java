package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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
    public String mAforo;
    ListadoDeHoras mHoras;


    // DECLARACION DE LAS SHAREDPREFERENCES
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_carmelo);

        mPrefs= getSharedPreferences("complutum",MODE_PRIVATE);  // INSTANCIAMOS LAS SHARED
        horarios = new ArrayList<>();                                   // INSTANCIAMOS EL ARRAY DE STRING
        listView = findViewById(R.id.listv_horarios_carmelo);
        btn = findViewById(R.id.btn_añadir_carmelo);

        // MIRAMOS EN LAS SHARED Y SI NO LO HARCODEAMOS
        String json = mPrefs.getString("horarios_shared","");

        if (!json.isEmpty()){
            mHoras = new ListadoDeHoras();
            mHoras = mHoras.fromJson(json); // le paso el String de las shared
            for(Hora h: mHoras.mListHorarios){
                horarios.add(h.hora);
                Log.i("complu","dentro del if ..añadios a la lista harcodeada el valor de h "+h.hora);
            }
        }else{
            mHoras= new ListadoDeHoras();
            horarios.add("8:30");
            Log.i("complu","dentro del else ..el listado de las shared esta vacio y entra en el harcodeado");

        }




        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);


    }

    // metodo para borrar los horarios de la lista
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        horarios.remove(i);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();


        // lo eliminamos de las shared
        // GUARDAR LA LISTA
        mPrefs= getSharedPreferences("complutum",MODE_PRIVATE);
        // y lo guardamos en las shared
        mHoras.mListHorarios.remove(i);
        mEditor = mPrefs.edit();
        mEditor.putString("horarios_shared",mHoras.toJson());
        mEditor.apply();
        Log.i("complu","en el dialog el valor del listado a guardar en las shared es: "+mHoras.toJson());
    }

    public void añadirHorarioCarmelo (View v){
        DialogCarmelo dialogCarmelo = new DialogCarmelo();
        dialogCarmelo.show(getSupportFragmentManager(),"nuevo_horario");
    }

    public void añadirAforoCarmelo(View v){
        DialogAforo dialogAforo = new DialogAforo();
        dialogAforo.show(getSupportFragmentManager(),"nuevo_aforo");
    }

    public void nuevoHorario(String hora){
        horarios.add(hora);
        Log.i("complu","la hora que llega es "+hora);

        // GUARDAR LA LISTA
        mPrefs= getSharedPreferences("complutum",MODE_PRIVATE);

        // crear un objeto hora
       Hora nuevaHora = new Hora();
       nuevaHora.hora= hora;

       // lo metemos en el listado de horas
       mHoras.mListHorarios.add(nuevaHora);

       // y lo guardamos en las shared
        mEditor = mPrefs.edit();
        mEditor.putString("horarios_shared",mHoras.toJson());
        mEditor.apply();
        Log.i("complu","en el dialog el valor del listado a guardar en las shared es: "+mHoras.toJson());

    }



    public void nuevoAforo(String aforo){
        mPrefs = getSharedPreferences("complutum",MODE_PRIVATE);
        mEditor = mPrefs.edit();
        mEditor.putString("aforo",aforo);
        mEditor.apply();
    }
}
