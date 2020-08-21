package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class DojoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button boton;
    ListView listView;
    ArrayList<String> horarios;
    SharedPreferences sharedPreferences;
    SharedPreferences mAforoCarmelo,mHorarioCarmelo;
    TextView mTexvAforo;
    ListadoDeHoras listaHoras;
    TextView mfecha;
    int item;
    String dia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dojo);

        boton = findViewById(R.id.id_botonDojo);
        listView = findViewById(R.id.id_lisView_mma);
        horarios = new ArrayList<>();
        mfecha = findViewById(R.id.id_fecha_text);
        dia = "h";

        sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);// SOLO ES LA INSTANCIA

        // LOGICA PARA EL AFORO DE CARMELO
        mTexvAforo = findViewById(R.id.n_aforo_dojo);
        mAforoCarmelo = getSharedPreferences("complutum",MODE_PRIVATE);
        String aforo = mAforoCarmelo.getString("aforo","8");
        mTexvAforo.setText(aforo);

        // LOGICA PARA LOS HORARIOS DE CARMELO
        mHorarioCarmelo = getSharedPreferences("complutum",MODE_PRIVATE);
        String json = mHorarioCarmelo.getString("horarios_shared","");
        if(json.isEmpty()){
            horarios.add("8:30");
        }else{
            listaHoras = new ListadoDeHoras();
            listaHoras = listaHoras.fromJson(json);
            for(Hora h: listaHoras.mListHorarios){
                horarios.add(h.getHora());
            }

        }

        // 1 creamos el adapter
        ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.item,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);

    }

    public void mañana(View v){
        // logica para cambiar la pantalla a mañana
        mfecha.setText(R.string.Mañana);

        // LOGICA PARA EL HORARIO DE CARMELO
        mHorarioCarmelo = getSharedPreferences("complutum",MODE_PRIVATE);
        String json = mHorarioCarmelo.getString("horarios_shared","");
        horarios = new ArrayList<>();
        if(json.isEmpty()){
            horarios.add("8:30");
        }else{
            listaHoras = new ListadoDeHoras();
            listaHoras = listaHoras.fromJson(json);
            for(Hora h: listaHoras.mListHorarios){
                horarios.add(h.getHora());
            }
        }

        ///// cambio la variable dia a mañana
        dia = "m";

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // mando las horas por intent por el intent
        Intent intent = new Intent(this,ListaDojoActivity.class);
        item = i+1;                  // variable para acceso a la lista = 1
        intent.putExtra("item",item);
        intent.putExtra("dia",dia);
        TextView textView = view.findViewById(R.id.mi_item);
        String textoTv = textView.getText().toString();
        startActivity(intent);


        /////////// mensajes ////////////
        Log.d("log","dojo onclik enviando valor item: "+item);
        Log.d("log","dojo onclik enviando valor dia: "+dia);
        Toast.makeText(this,"Clase: "+(item),Toast.LENGTH_LONG).show();

    }
}
