package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

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

public class ListaBoxActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Usuario> usuariosFechas;
    EditText editText;
    Button boton;
    SharedPreferences mShared;
    SharedPreferences.Editor mEditor;
    ListUsuarios listUsuarios;
    ListaUsuariosMañana listaUsuManana;
    Usuario nuevoUsuario;
    int itemAsignado;
    Boolean mApuntado = false;
    ListaOk mlistOK;
    ListadoDeHoras listadoDeHoras;
    Ok ok;
    String dia;
    String mTextoT;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_box);

        editText = findViewById(R.id.id_editText_lisBox);
        boton = findViewById(R.id.id_botonBox);
        listView = findViewById(R.id.listaUsuarios);
        usuariosFechas = new ArrayList<>();
        listUsuarios = new ListUsuarios();
        listaUsuManana = new ListaUsuariosMañana();
        mlistOK = new ListaOk();
        listadoDeHoras = new ListadoDeHoras();
        ok = new Ok();

        // recupero las sharedPreferences
        mShared = getSharedPreferences("complutum",MODE_PRIVATE);
        mEditor = mShared.edit();

        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        dia = intent.getStringExtra("dia");
        mTextoT = intent.getStringExtra("texto_tv");

        Log.i("complu","listabox/oncreate  recibido textoTV = "+mTextoT);
        Log.i("complu","listabox/oncreate  recibido itemAsignado es: "+itemAsignado);
        Log.i("complu","listabox/oncreate  recibido  valor del inten dia "+dia);


        String horasJson = mShared.getString("horarios_shared","");  // horarios guardados por carmelo
        listadoDeHoras = listadoDeHoras.fromJson(horasJson);

        Log.i("complu","////////listbox/onCreate_creando_las_listas//////////");
        Log.i("complu","/////////////listaBox/oncreate_valorDe_listadoHoras_en_SHARED "+horasJson);

            for(Hora h: listadoDeHoras.mListHorarios) {

                if (h.getHora().equals(mTextoT)) {
                    Log.i("complu", "////////////////////sisiiiiiiiii la hora es " + h.getHora());
                    Log.i("complu", " la clave_hora de hora: "+h.getHora()+" es " + h.getClaveHora()+" tope 16");

                    switch (h.getClaveHora()) {
                        case 1:
                            Log.i("complu", "Listabox/oncreate  entrando en la clase 1");
                            // recupero el json de las shared
                            String json = mShared.getString(h.getHora() + "h", "");
                            String jsonM = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!jsonM.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(jsonM);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 2:
                            Log.i("complu", "listbox/oncreate entrando en la clase 2");
                            // recupero el json de las shared
                            String json2 = mShared.getString(h.getHora() + "h", "");
                            String json2M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json2.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json2);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 2h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de 2h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json2M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json2M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 2m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }

                            break;
                        case 3:
                            Log.i("complu", "listbox/oncreate entrando en la clase 3");
                            // recupero el json de las shared
                            String json3 = mShared.getString(h.getHora() + "h", "");
                            String json3M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json3.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json3);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 3h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json3M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json3M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 3m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 4:
                            Log.i("complu", "listbox/oncreate entrando en la clase 4");
                            // recupero el json de las shared
                            String json4 = mShared.getString(h.getHora() + "h", "");
                            String json4M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json4.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json4);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json4M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json4M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 5:
                            Log.i("complu", "listbox/oncreate entrando en la clase 5");
                            // recupero el json de las shared
                            String json5 = mShared.getString(h.getHora() + "h", "");
                            String json5M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json5.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json5);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json5M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json5M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 6:
                            Log.i("complu", "listbox/oncreate entrando en la clase 6");
                            // recupero el json de las shared
                            String json6 = mShared.getString(h.getHora() + "h", "");
                            String json6M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json6.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json6);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json6M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json6M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 7:
                            Log.i("complu", "listbox/oncreate entrando en la clase 7");
                            // recupero el json de las shared
                            // recupero el json de las shared
                            String json7 = mShared.getString(h.getHora() + "h", "");
                            String json7M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json7.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json7);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json7M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json7M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 8:
                            Log.i("complu", "listbox/oncreate entrando en la clase 8");
                            // recupero el json de las shared
                            // recupero el json de las shared
                            String json8 = mShared.getString(h.getHora() + "h", "");
                            String json8M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json8.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json8);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json8M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json8M);
                                    Log.i("complu", "clase1 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 9:
                            // recupero el json de las shared
                            String json9 = mShared.getString(h.getHora() + "h", "");
                            String json9M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json9.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json9);
                                    Log.i("complu", "clase1 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json9M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json9M);
                                    Log.i("complu", "clase9 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 10:
                            // recupero el json de las shared
                            String json10 = mShared.getString(h.getHora() + "h", "");
                            String json10M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json10.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json10);
                                    Log.i("complu", "clase10 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json10M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json10M);
                                    Log.i("complu", "clase10 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 11:
                            // recupero el json de las shared
                            String json11 = mShared.getString(h.getHora() + "h", "");
                            String json11M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json11.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json11);
                                    Log.i("complu", "clase11 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json11M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json11M);
                                    Log.i("complu", "clase11 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 12:
                            // recupero el json de las shared
                            String json12 = mShared.getString(h.getHora() + "h", "");
                            String json12M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json12.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json12);
                                    Log.i("complu", "clase12 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json12M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json12M);
                                    Log.i("complu", "clase12 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 13:
                            // recupero el json de las shared
                            String json13 = mShared.getString(h.getHora() + "h", "");
                            String json13M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json13.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json13);
                                    Log.i("complu", "clase13 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json13M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json13M);
                                    Log.i("complu", "clase13 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 14:
                            // recupero el json de las shared
                            String json14 = mShared.getString(h.getHora() + "h", "");
                            String json14M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json14.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json14);
                                    Log.i("complu", "clase14 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json14M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json14M);
                                    Log.i("complu", "clase14 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 15:
                            // recupero el json de las shared
                            String json15 = mShared.getString(h.getHora() + "h", "");
                            String json15M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json15.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json15);
                                    Log.i("complu", "clase15 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json15M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json15M);
                                    Log.i("complu", "clase15 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        case 16:
                            // recupero el json de las shared
                            String json16 = mShared.getString(h.getHora() + "h", "");
                            String json16M = mShared.getString(h.getHora() + "m", "");


                            if (dia.equals("h")) {   // valido si es h= hoy
                                if (!json16.isEmpty()) {
                                    listUsuarios = listUsuarios.fromJson(json16);
                                    Log.i("complu", "clase16 listabox valor de json" + listUsuarios);
                                    for (Usuario u : listUsuarios.mListUsuarios) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1h y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de h");
                                }
                            }

                            if (dia.equals("m")) {  // valido si m es = mañana
                                if (!json16M.isEmpty()) {
                                    listaUsuManana = listaUsuManana.fromJson(json16M);
                                    Log.i("complu", "clase16 listabox valor de jsonM" + listaUsuManana);
                                    for (Usuario u : listaUsuManana.mListUsuariosMañana) {
                                        usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                                        Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                                    }
                                    Log.i("complu", "entra en el if de m " + listaUsuManana);
                                }
                            }
                            break;
                        default:
                            Log.i("complu", "default no entra en ningun case");
                            break;
                    }
                }
            }



        // 2 crear el Adapter (pasamos contex, vista, array)
        MiAdapter adapter = new MiAdapter(this,R.layout.mi_layout,usuariosFechas);
        // 3 Asociamos el Adapter a la vista
        listView.setAdapter(adapter);
    }

    // LOGICA PARA IR AGREGANDO CADA PERSONA A LAS CLASES
    public void agregar(View v) {
        Log.i("complu","///////////////// METODO AGREGAR: AÑADE CADA PERSONA A LAS CLASES ");

        // cojemos el nombre del usuario escrito en el edit
        String nombre = editText.getText().toString();



            // compruebo que ha escrito algo y que no esta apuntado
            // if(!nombre.isEmpty() & !mApuntado)
            if (!nombre.isEmpty() ) {      // si esta escribiendo y la variable es todavia false  ejecuto el codigo
                nuevoUsuario = new Usuario(nombre, R.drawable.iconojpg);

                ////////////////prueba para buscasr en el tab de las shared//////////
                listadoDeHoras = new ListadoDeHoras();
                String hora = mShared.getString("horarios_shared", "");
                listadoDeHoras = listadoDeHoras.fromJson(hora);

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
                                    boolean ok = mShared.getBoolean("c1h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());

                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c1h", mApuntado);

                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c1m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c1m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }


                                break;
                            case 2:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 2 para añadir en las shared automatica " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c2h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c2h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 2h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c2m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c2m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 2m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 3:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 3 para añadir en las shared auto " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c3h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c3h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 3h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c3m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c3m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 3m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }


                                break;

                            case 4:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 4 para añadir en las shared auto " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c4h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c4h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 4h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c4m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c4m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 4m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }


                                break;
                            case 5:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 5 para añadir en las shared auto " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c5h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c5h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 5h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c5m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c5m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 5m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 6:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 6 para añadir en las shared auto " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if

                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c6h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c6h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 6h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c6m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c6m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }

                                break;
                            case 7:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 7 para añadir en las shared auto " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c7h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c7h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();
                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c7m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c7m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 8:
                                Log.i("complu", "Listabox/onclick  itemasignado= " + itemAsignado + " entranddo en la clase 8 para añadir en las shared auto " + h.getHora());
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c8h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c8h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c8m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c8m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 9:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c9h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c9h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c9m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c9m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 10:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c10h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c10h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c10m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c10m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 11:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c11h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c11h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c11m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c11m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 12:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c12h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c12h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c12m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c12m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 13:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c13h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c13h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c13m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c13m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 14:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c14h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c14h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c14m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c14m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            case 15:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if
                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c15h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c15h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c15m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c15m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }

                                break;
                            case 16:
                                // miro en las shared para ver si ya se ha registrado
                                // lo guardo en una variable y la valido con un if


                                if (dia.equals("h")) {
                                    boolean ok = mShared.getBoolean("c16h", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en esta clase hoy", Toast.LENGTH_LONG).show();
                                    } else {

                                        // lo añado a la lista de usuario
                                        listUsuarios.mListUsuarios.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "h", listUsuarios.toJson());


                                        // cambiamos el valor a true
                                        mApuntado = true;

                                        // lo gurdo en la shared
                                        mEditor.putBoolean("c16h", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1h: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                if (dia.equals("m")) {
                                    boolean ok = mShared.getBoolean("c16m", false);

                                    if (ok) {
                                        Toast.makeText(this, "Ya estas apuntado en la clase de mañana", Toast.LENGTH_LONG).show();
                                    } else {
                                        listaUsuManana.mListUsuariosMañana.add(nuevoUsuario);
                                        usuariosFechas.add(nuevoUsuario);

                                        // lo guardo en las shared como un string con la clase json
                                        mEditor.putString(h.getHora() + "m", listaUsuManana.toJson());

                                        // cambio el valor a true
                                        mApuntado = true;

                                        mEditor.putBoolean("c16m", mApuntado);
                                        mEditor.apply();

                                        Log.i("complu", "valor de lo que guardo en shared 1m: " + listUsuarios.toJson());
                                        Toast.makeText(this,getString(R.string.Te_has_apuntado_en_esta_clase),Toast.LENGTH_LONG).show();

                                    }

                                }
                                break;
                            default:
                                Toast.makeText(this, "No hay mas clases", Toast.LENGTH_LONG).show();
                                break;
                        }



                    } else {
                        Log.i("complu", "listbox/agregar no entra en el if del swicth valor del itemasignado = " + itemAsignado);
                        Log.i("complu", "listbox/agregar no entra en el if del swicth valor de h.getclave = " + h.getClaveHora());
                        Log.i("complu", "listbox/agregar no coincide la busqueda");
                    }

                }


        } else {   // si viene vacio le saco un Toast para que lo rellene
                if (nombre.isEmpty()) {
                    Toast.makeText(this, "Tienes que escribír tu nombre", Toast.LENGTH_LONG).show();
                }
        }

    }
}
