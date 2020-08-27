package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListaDojoActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Usuario> usuariosFechas;
    EditText editText;
    Button boton;
    SharedPreferences mShared;
    SharedPreferences.Editor editor;
    Usuario nuevoUsuario;
    ListUsuarios mListUsuarios;
    ListaUsuariosMañana listaUsuariosManana;
    ListadoDeHoras listadoDeHoras;
    Boolean mApuntado = false;
    String dia;
    int itemAsignado;
    String mTextoT;
    int maximo;
    Calendar calendar;
    int ayerCalendar;
    int hoyCalendar;
    int mananaCalendar;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dojo);
        editText = findViewById(R.id.id_edit_nom_dojo);
        boton = findViewById(R.id.id_boton_apun_dojo);
        listView = findViewById(R.id.id_lisView_apun_dojo);
        usuariosFechas = new ArrayList<>();
        mListUsuarios = new ListUsuarios();
        listaUsuariosManana = new ListaUsuariosMañana();
        listadoDeHoras = new ListadoDeHoras();
        dia = "h";
        calendar = new GregorianCalendar();
        ayerCalendar = calendar.get(Calendar.DAY_OF_MONTH)-1;
        hoyCalendar = calendar.get(Calendar.DAY_OF_MONTH);
        mananaCalendar = calendar.get(Calendar.DAY_OF_MONTH)+1;

        // recupero las sharedPreferences
        mShared = getSharedPreferences("complutum",MODE_PRIVATE);  // lectura de disco
        editor = mShared.edit();                                          // grabar en disco

        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        dia = intent.getStringExtra("dia");
        mTextoT = intent.getStringExtra("textoDj");

        Log.i("complu","oncreate listabox itemAsignado es: "+itemAsignado);
        Log.i("complu","oncreate listabox valor del inten dia "+dia);


        ////// recupero los horarios de las shared horarios
        String horasJson = mShared.getString("horarios_shared","");  // horarios guardados por carmelo
        listadoDeHoras = listadoDeHoras.fromJson(horasJson);


        // logica para borrar las shared de ayer y no acumular
        if (ayerCalendar < calendar.get(Calendar.DAY_OF_MONTH)){
            for ( Hora h: listadoDeHoras.mListHorarios){
                editor.remove(ayerCalendar+h.hora);
                editor.remove(ayerCalendar+h.hora+"d");
                editor.apply();
            }
        }

        if(listadoDeHoras == null){
            Toast.makeText(this,"Ponte en contacto con el monitor",Toast.LENGTH_SHORT).show();
        }else {


            for (Hora h : listadoDeHoras.mListHorarios) {

                if (h.getHora().equals(mTextoT)) {
                    Log.i("complu", "////////////////////sisiiiiiiiii la hora es " + h.getHora());
                    Log.i("complu", " la clave_hora de hora: " + h.getHora() + " es " + h.getClaveHora() + " tope 16");

                    switch (h.getClaveHora()) {
                        case 1:
                            Log.i("complu", "Listabox/oncreate  entrando en la clase 1");
                            // recupero el json de las shared
                            String json = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String jsonM = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!jsonM.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(jsonM);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 2:
                            Log.i("complu", "listbox/oncreate entrando en la clase 2");
                            // recupero el json de las shared
                            String json2 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json2M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json2.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json2);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json2M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json2M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }

                            break;
                        case 3:

                            Log.i("complu", "listbox/oncreate entrando en la clase 3");
                            // recupero el json de las shared
                            String json3 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json3M = mShared.getString(mananaCalendar+h.hora+"d", "");

                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json3.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json3);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json3M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json3M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 4:
                            Log.i("complu", "listbox/oncreate entrando en la clase 4");
                            // recupero el json de las shared
                            String json4 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json4M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json4.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json4);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json4M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json4M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 5:
                            Log.i("complu", "listbox/oncreate entrando en la clase 5");
                            // recupero el json de las shared
                            String json5 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json5M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json5.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json5);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json5M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json5M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }

                            break;
                        case 6:
                            Log.i("complu", "listbox/oncreate entrando en la clase 6");
                            // recupero el json de las shared
                            String json6 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json6M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json6.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json6);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json6M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json6M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 7:
                            Log.i("complu", "listbox/oncreate entrando en la clase 7");

                            String json7 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json7M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json7.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json7);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json7M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json7M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 8:
                            Log.i("complu", "listbox/oncreate entrando en la clase 8");

                            String json8 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json8M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json8.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json8);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json8M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json8M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 9:
                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 9");
                            String json9 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json9M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json9.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json9);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json9M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json9M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }

                            break;
                        case 10:

                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 10");
                            String json10 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json10M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json10.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json10);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json10M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json10M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 11:
                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 11");
                            String json11 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json11M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json11.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json11);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json11M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json11M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }

                            break;
                        case 12:
                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 12");
                            String json12 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json12M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json12.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json12);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json12M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json12M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 13:
                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 13");
                            String json13 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json13M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json13.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json13);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json13M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json13M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 14:

                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 14");
                            String json14 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json14M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json14.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json14);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json14M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json14M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }
                            break;
                        case 15:
                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 15");
                            String json15 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json15M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json15.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json15);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json15M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json15M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }

                            break;
                        case 16:
                            // recupero el json de las shared
                            Log.i("complu", "listbox/oncreate entrando en la clase 16");
                            String json16 = mShared.getString(hoyCalendar+h.hora+"d", "");
                            String json16M = mShared.getString(mananaCalendar+h.hora+"d", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json16.isEmpty()) {
                                    mListUsuarios = mListUsuarios.fromJson(json16);
                                    Log.i("complu", "clase1 listabox valor de json" + mListUsuarios);
                                    for (Usuario u : mListUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json16M.isEmpty()) {
                                    listaUsuariosManana = listaUsuariosManana.fromJson(json16M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuariosManana);
                                    for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                                }
                            }

                            break;
                        default:
                            Log.i("complu", "listaDojo/swhitc no entra en el switc ningun caso encontrado");
                            break;
                    }
                }
            }
        }



        // 2 crear el Adapter (pasamos contex, vista, array)
        MiAdapter adapter = new MiAdapter(this,R.layout.mi_layout,usuariosFechas);
        // 3 Asociamos el Adapter a la vista
        listView.setAdapter(adapter);
    }

    // metodo para añadir a la lista el nombre y el item de las shared
    public void agregar(View v) {
        // cojo el usuario escrito y lo añado en la lista sin escribir en el disco
        String nombre = editText.getText().toString();

        // recupero el aforo de las shared  y lo comparo en cada clase con el array de usuarios si son iguales no entra mas gente
        int nAforoCarmelo = mShared.getInt("nAforo", 8);




        if(!nombre.isEmpty()) {
            nuevoUsuario = new Usuario(nombre, R.drawable.iconojpg);

            ////////////////prueba para buscasr en el tab de las shared//////////
            listadoDeHoras = new ListadoDeHoras();
            String hora = mShared.getString("horarios_shared", "");
            listadoDeHoras = listadoDeHoras.fromJson(hora);

            if(listadoDeHoras == null){
                Toast.makeText(this,"No hay clases hoy",Toast.LENGTH_SHORT).show();
            }else {

                for (Hora h : listadoDeHoras.mListHorarios) {

                    if (h.hora.equals(mTextoT)) {
                        Log.i("complu", "////////////////siiiiiii_AGREGANDO_CLAVE_AUTOMATICA_SHARED=" + h.getClaveHora());

                        // usamos el swich para dar una clave diferente a las shared
                        switch (h.getClaveHora()) {
                            case 1:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c1hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {

                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c1hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m1hd", 0);
                                            maximo += 1;
                                            editor.putInt("m1hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 1hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG);
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c1md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {

                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c1md", mApuntado);

                                            maximo = mShared.getInt("m1md", 0);
                                            maximo += 1;
                                            editor.putInt("m1md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 1mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 2:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c2hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c2hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m2hd", 0);
                                            maximo += 1;
                                            editor.putInt("m2hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 2hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c2md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {

                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c2md", mApuntado);

                                            maximo = mShared.getInt("m2md", 0);
                                            maximo += 1;
                                            editor.putInt("m2md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 2mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                break;
                            case 3:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c3hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c3hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m3hd", 0);
                                            maximo += 1;
                                            editor.putInt("m3hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 3hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {

                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c3md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c3md", mApuntado);

                                            maximo = mShared.getInt("m3md", 0);
                                            maximo += 1;
                                            editor.putInt("m3md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 3mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                break;
                            case 4:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c4hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c4hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m4hd", 0);
                                            maximo += 1;
                                            editor.putInt("m4hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 4hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c4md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {

                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c4md", mApuntado);

                                            maximo = mShared.getInt("m4md", 0);
                                            maximo += 1;
                                            editor.putInt("m4md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 4mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 5:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c5hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c5hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m5hd", 0);
                                            maximo += 1;
                                            editor.putInt("m5hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 5hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c5md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c5md", mApuntado);

                                            maximo = mShared.getInt("m5md", 0);
                                            maximo += 1;
                                            editor.putInt("m5md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 5mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 6:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c6hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c6hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m6hd", 0);
                                            maximo += 1;
                                            editor.putInt("m6hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 6hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c6md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c6md", mApuntado);

                                            maximo = mShared.getInt("m6md", 0);
                                            maximo += 1;
                                            editor.putInt("m6md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 6mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 7:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c7hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c7hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m7hd", 0);
                                            maximo += 1;
                                            editor.putInt("m7hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 7hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c7md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c7md", mApuntado);

                                            maximo = mShared.getInt("m7md", 0);
                                            maximo += 1;
                                            editor.putInt("m7md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 7mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 8:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c8hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {

                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c8hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m8hd", 0);
                                            maximo += 1;
                                            editor.putInt("m8hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 8hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c8md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c8md", mApuntado);

                                            maximo = mShared.getInt("m8md", 0);
                                            maximo += 1;
                                            editor.putInt("m8md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 8mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 9:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c9hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c9hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m9hd", 0);
                                            maximo += 1;
                                            editor.putInt("m9hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 9hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c9md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c9md", mApuntado);

                                            maximo = mShared.getInt("m9md", 0);
                                            maximo += 1;
                                            editor.putInt("m9md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 9mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 10:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c10hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {
                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c10hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m10hd", 0);
                                            maximo += 1;
                                            editor.putInt("m10hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 10hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();

                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c10md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c10md", mApuntado);

                                            maximo = mShared.getInt("m10md", 0);
                                            maximo += 1;
                                            editor.putInt("m10md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 10mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();

                                        }
                                    }

                                }

                                break;
                            case 11:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c11hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c11hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m11hd", 0);
                                            maximo += 1;
                                            editor.putInt("m11hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 11hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();

                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c11md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c11md", mApuntado);

                                            maximo = mShared.getInt("m11md", 0);
                                            maximo += 1;
                                            editor.putInt("m11md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 11mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 12:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c12hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c12hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m12hd", 0);
                                            maximo += 1;
                                            editor.putInt("m12hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 12hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c12md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c12md", mApuntado);

                                            maximo = mShared.getInt("m12md", 0);
                                            maximo += 1;
                                            editor.putInt("m12md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 12mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                break;
                            case 13:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c13hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c13hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m13hd", 0);
                                            maximo += 1;
                                            editor.putInt("m13hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 13hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c13md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c13md", mApuntado);

                                            maximo = mShared.getInt("m13md", 0);
                                            maximo += 1;
                                            editor.putInt("m13md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 13mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 14:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c14hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {


                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c14hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m14hd", 0);
                                            maximo += 1;
                                            editor.putInt("m14hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 14hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c14md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c14md", mApuntado);

                                            maximo = mShared.getInt("m14md", 0);
                                            maximo += 1;
                                            editor.putInt("m14md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 14mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 15:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c15hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c15hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m15hd", 0);
                                            maximo += 1;
                                            editor.putInt("m15hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 15hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c15md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c15md", mApuntado);

                                            maximo = mShared.getInt("m15md", 0);
                                            maximo += 1;
                                            editor.putInt("m15md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 15mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            case 16:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 1 para añadir en las shared automaticas " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c16hd", false); // miramos en el boolean de la clase en las shared

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                                    } else {
                                        if (mListUsuarios.mListUsuarios.size() < nAforoCarmelo) {

                                            // lo añado a la lista de usuario
                                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(hoyCalendar+h.hora+"d", mListUsuarios.toJson());

                                            // cambiamos el valor a true
                                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                                            // lo gurdo en la shared
                                            editor.putBoolean("c16hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase

                                            maximo = mShared.getInt("m16hd", 0);
                                            maximo += 1;
                                            editor.putInt("m16hd", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 16hdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c16md", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (listaUsuariosManana.mListUsuariosMañana.size() < nAforoCarmelo) {
                                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                                            usuariosFechas.add(nuevoUsuario);

                                            // lo guardo en las shared como un string con la clase json
                                            editor.putString(mananaCalendar+h.hora+"d", listaUsuariosManana.toJson());

                                            // cambio el valor a true
                                            mApuntado = true;

                                            editor.putBoolean("c16md", mApuntado);

                                            maximo = mShared.getInt("m16md", 0);
                                            maximo += 1;
                                            editor.putInt("m16md", maximo);
                                            editor.apply();

                                            Log.i("complu", "valor de lo que guardo en shared 16mdojo: " + mListUsuarios.toJson());
                                            Toast.makeText(this, getString(R.string.Te_has_apuntado_en_esta_clase), Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(this, R.string.aforo_completo, Toast.LENGTH_LONG).show();
                                        }
                                    }

                                }

                                break;
                            default:
                                Toast.makeText(this, "No hay mas clases", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                }
            }

        }else {
            if(nombre.isEmpty()){
                Toast.makeText(this,"Tienes que escribír tu nombre",Toast.LENGTH_LONG).show();
            }
        }

    }
}