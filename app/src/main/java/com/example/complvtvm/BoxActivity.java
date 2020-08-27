package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.example.complvtvm.R.color.negro_tool_bar;
import static java.util.Calendar.YEAR;

public class BoxActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button boton;

    ListView listView;
    ArrayList<String> horarios;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences mAforoCarmelo,mHorarioCarmelo;
    int item;
    TextView mTxvAforo;
    TextView mfecha;
    ListadoDeHoras listaHoras;
    String dia;


    // en las clases creo un int y lo guardo en las shared
    // hago un array de int
    // a cada uno le doy el valor de las shared por defecto 0
    // en el adapter creo un objeto de esta clase y compruebo el valor del aforo para pintarlo en rojo


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

        mTxvAforo = findViewById(R.id.n_aforo);
        boton = findViewById(R.id.id_botonBox_peque);
        listView = findViewById(R.id.id_lisView_box_peque);
        mfecha = findViewById(R.id.id_fecha_text);
        dia = "h";
        //calendar = new GregorianCalendar();

        sharedPreferences = getSharedPreferences("complutum",MODE_PRIVATE);// SOLO ES LA INSTANCIA
        editor = sharedPreferences.edit();


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
            horarios.add("Hoy no hay clases");
        }else{
            listaHoras = new ListadoDeHoras();
            listaHoras = listaHoras.fromJson(json);
            for(Hora h: listaHoras.mListHorarios){
                horarios.add(h.getHora());
            }
        }

        ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.item,horarios);
        // 1 creamos el adapter
        //ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.item,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);

    }

    // metodo para apuntarse en mañana
    // solo cambia las letras no se va a ningun activity
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

        // cambio el valor de dia
        dia= "m";

        // desaparece el boton de mañana
        boton.setVisibility(listView.GONE);

    }

    // metodo del listview para apuntarse en la lista de pantalla
    @SuppressLint("ResourceAsColor")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // todo como aqui es donde mando el dato del dia aqui es donde tengo que gestionar el dia con android y mandarle el dia actual
        // todo si elige el dia de mañana le digo que es el dia mas uno
        // mando las horas por intent por el intent
        Intent intent = new Intent(this,ListaBoxActivity.class);
        item = i+1; // variable para acceso a la lista  = 1

        // intento extraer el string
        TextView textView = view.findViewById(R.id.mi_item);
        String textoTxv = textView.getText().toString();


        intent.putExtra("dia",dia);  // esto si no ha pulsado en mañana
        intent.putExtra("item",item);
        intent.putExtra("texto_tv",textoTxv); // mando el texto del iten



        // solo lo enseño en la consola para mi info
        int aforoCarmelo = sharedPreferences.getInt("nAforo",0);
        Log.i("complu","///////////aforo_de_carmelo_= "+aforoCarmelo);


        Log.i("complu","///////////////box/onclik valor del item en camino: "+item);  // aqui vale o
        Log.i("complu","box/onclik valor del dia en camino: "+dia);
        Toast.makeText(this,"Clase: "+(item),Toast.LENGTH_LONG).show();


        startActivity(intent);
    }

    // metodo para combertir a json
    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    // metodo para pasar un json a objeto
    public BoxActivity fromJson(String json){
        Gson gson = new Gson();
        BoxActivity boxActivity = gson.fromJson(json,BoxActivity.class);
        return boxActivity;
    }
}
