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
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.YEAR;

public class BoxActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button boton;
    Calendar calendar;
    ListView listView;
    ArrayList<String> horarios;
    SharedPreferences sharedPreferences;
    SharedPreferences mAforoCarmelo,mHorarioCarmelo;
    int item;
    TextView mTxvAforo;
    ListadoDeHoras listaHoras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

        mTxvAforo = findViewById(R.id.n_aforo);
        boton = findViewById(R.id.id_botonBox_peque);
        listView = findViewById(R.id.id_lisView_box_peque);
        sharedPreferences = getSharedPreferences("complutum",MODE_PRIVATE);// SOLO ES LA INSTANCIA

        // LOGICA PARA EL AFORO CREADO POR CARMELO
        mAforoCarmelo = getSharedPreferences("complutum",MODE_PRIVATE);
        String aforo = mAforoCarmelo.getString("aforo","8");
        Log.i("aforo",aforo);
        mTxvAforo.setText(aforo);

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



        // 1 creamos el adapter
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);

        //todo por aqui podrias cambiar el color del horario a rojo si esta lleno

    }

    public void clickBoton(View v){
        // navegamos a la lista de Box
        Intent intent = new Intent(this, ListaBoxActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // mando las horas por intent por el intent
        Intent intent = new Intent(this,ListaBoxActivity.class);
        item = i; // variable para acceso a la lista
        intent.putExtra("item",item);
        startActivity(intent);
        Log.d("log","valor del item: "+item);
        Toast.makeText(this,"Clase: "+(i+1),Toast.LENGTH_LONG).show();
    }
}
