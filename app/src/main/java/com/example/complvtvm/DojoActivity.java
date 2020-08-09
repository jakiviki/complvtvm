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
import android.widget.Toast;


import java.util.ArrayList;

public class DojoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button boton;
    ListView listView;
    ArrayList<String> horarios;
    SharedPreferences sharedPreferences;
    int item;

    int clase0 = 0;
    int clase1 = 1;
    int clase2 = 2;
    int clase3 = 3;
    int clase4 = 4;
    int clase5 = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dojo);

        boton = findViewById(R.id.id_botonDojo);
        listView = findViewById(R.id.id_lisView_mma);
        sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);// SOLO ES LA INSTANCIA

        horarios = new ArrayList<>();
        horarios.add("9:00");
        horarios.add("17:30");
        horarios.add("18:30");
        horarios.add("19:30");
        horarios.add("20:30");
        horarios.add("21:30");
        horarios.add("22:30");

        // 1 creamos el adapter
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);

    }

    public void clickBoton(View v){
        // navegamos a la lista de Box
        Intent intent = new Intent(this, ListaBoxActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ///String horaintem = listView.getAdapter().getItem(i).toString();

        if( clase0 == i){
            // guardo la hora en las shares
            //SharedPreferences.Editor editor = sharedPreferences.edit();
            //editor.putInt(String.valueOf(i),i); // mando un entero
            //editor.apply();
            Toast.makeText(this,"clase 0:"+i,Toast.LENGTH_LONG).show();
        }else {
            if(clase1 == i){
                // guardo la hora en las shares
                //SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putInt(String.valueOf(i),i); // mando un entero
                //editor.apply();
                Toast.makeText(this,"clase 1:"+i,Toast.LENGTH_LONG).show();

            }else {
                if(clase2 == i){
                    // guardo la hora en las shares
                    //SharedPreferences.Editor editor = sharedPreferences.edit();
                    //editor.putInt(String.valueOf(i),i); // mando un entero
                    //editor.apply();
                    Toast.makeText(this,"clase 2:"+i,Toast.LENGTH_LONG).show();

                }else {
                    if(clase3 == i){
                        // guardo la hora en las shares
                        //SharedPreferences.Editor editor = sharedPreferences.edit();
                        //editor.putInt(String.valueOf(i),i); // mando un entero
                        //editor.apply();
                        Toast.makeText(this,"clase 3:"+i,Toast.LENGTH_LONG).show();
                    }else {
                        if(clase4 == i){
                            // guardo la hora en las shares
                            //SharedPreferences.Editor editor = sharedPreferences.edit();
                            //editor.putInt(String.valueOf(i),i); // mando un entero
                            //editor.apply();
                            Toast.makeText(this,"clase 4:"+i,Toast.LENGTH_LONG).show();

                        }
                    }
                }
            }
        }


        // mando las horas por intent por el intent
        Intent intent = new Intent(this,ListaDojoActivity.class);
        //intent.putExtra("hora_intent",horarios.get(i));
        item = i; // variable para acceso a la lista
        intent.putExtra("item",item);
        startActivity(intent);
        Log.d("log","valor del item: "+item);
        Toast.makeText(this,"valor de item: "+item,Toast.LENGTH_LONG).show();
    }
}
