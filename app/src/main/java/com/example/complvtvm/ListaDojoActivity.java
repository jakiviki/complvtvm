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
    Boolean mApuntado = false;
    String dia;
    int itemAsignado;


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
        dia = "h";

        // recupero las sharedPreferences
        mShared = getSharedPreferences("complutum",MODE_PRIVATE);  // lectura de disco
        editor = mShared.edit();                                          // grabar en disco

        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        dia = intent.getStringExtra("dia");

        Log.i("complu","oncreate listabox itemAsignado es: "+itemAsignado);
        Log.i("complu","oncreate listabox valor del inten dia "+dia);

        String jm = mShared.getString("clase1_dojo_h","");
        boolean okborradoCarmelo = mShared.getBoolean("okBorradoCarmelo",true);
        Log.i("complu","listaBox/oncreate  valor de okBorradoCarmelo = "+okborradoCarmelo);




        // usamos el swich para dar una clave diferente a las shared
        switch (itemAsignado){
            case 1:
                // recupero el json de las shared
                String json = mShared.getString("clase1_dojo_h","");
                String jsonM = mShared.getString("clase1_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!jsonM.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(jsonM);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }
                break;
            case 2:
                // recupero el json de las shared
                String json2 = mShared.getString("clase2_dojo_h","");
                String json2M = mShared.getString("clase2_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json2.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json2);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json2M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json2M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }

                break;
            case 3:

                // recupero el json de las shared
                String json3 = mShared.getString("clase3_dojo_h","");
                String json3M = mShared.getString("clase3_dojo_m", "");

                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json3.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json3);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json3M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json3M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }
                break;
            case 4:
                // recupero el json de las shared
                String json4 = mShared.getString("clase4_dojo_h","");
                String json4M = mShared.getString("clase4_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json4.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json4);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json4M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json4M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }
                break;
            case 5:
                // recupero el json de las shared
                String json5 = mShared.getString("clase5_dojo_h","");
                String json5M = mShared.getString("clase5_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json5.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json5);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json5M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json5M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }

                break;
            case 6:
                // recupero el json de las shared
                String json6 = mShared.getString("clase6_dojo_h","");
                String json6M = mShared.getString("clase6_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json6.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json6);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json6M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json6M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }
                break;
            case 7:
                // llamo a las shared para mostrarlas en el activity
                // recupero el json de las shared
                String json7 = mShared.getString("clase7_dojo_h","");
                String json7M = mShared.getString("clase7_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json7.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json7);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json7M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json7M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }
                break;
            case 8:
                // recupero el json de las shared
                String json8 = mShared.getString("clase8_dojo_h","");
                String json8M = mShared.getString("clase8_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json8.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json8);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json8M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json8M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json9 = mShared.getString("clase9_dojo_h","");
                String json9M = mShared.getString("clase9_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json9.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json9);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json9M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json9M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json10 = mShared.getString("clase10_dojo_h","");
                String json10M = mShared.getString("clase10_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json10.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json10);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json10M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json10M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json11 = mShared.getString("clase11_dojo_h","");
                String json11M = mShared.getString("clase11_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json11.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json11);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json11M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json11M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json12 = mShared.getString("clase12_dojo_h","");
                String json12M = mShared.getString("clase12_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json12.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json12);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json12M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json12M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }
                break;
            case 13:
                // llamo a las shared para mostrarlas en el activity
                // recupero el json de las shared
                String json13 = mShared.getString("clase13_dojo_h","");
                String json13M = mShared.getString("clase13_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json13.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json13);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json13M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json13M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json14 = mShared.getString("clase14_dojo_h","");
                String json14M = mShared.getString("clase14_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json14.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json14);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json14M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json14M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json15 = mShared.getString("clase15_dojo_h","");
                String json15M = mShared.getString("clase15_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json15.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json15);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json15M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json15M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
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
                String json16 = mShared.getString("clase16_dojo_h","");
                String json16M = mShared.getString("clase16_dojo_m", "");


                if (dia.equals("h")){   // valido si es h= hoy
                    if(!json16.isEmpty()){
                        mListUsuarios = mListUsuarios.fromJson(json16);
                        Log.i("complu","clase1 listabox valor de json"+mListUsuarios);
                        for(Usuario u: mListUsuarios.mListUsuarios){
                            usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                            Log.i("complu","estoy dentro del for de 1h y añado los usuario");
                        }
                        Log.i("complu","entra en el if de h");
                    }
                }

                if (dia.equals("m")){  // valido si m es = mañana
                    if(!json16M.isEmpty()){
                        listaUsuariosManana = listaUsuariosManana.fromJson(json16M);
                        Log.i("complu","clase1 listabox valor de jsonM"+listaUsuariosManana);
                        for (Usuario u : listaUsuariosManana.mListUsuariosMañana) {
                            usuariosFechas.add(new Usuario(u.nombre, u.imagen));
                            Log.i("complu", "estoy dentro del for de 1m y añado los usuario");
                        }
                        Log.i("complu", "entra en el if de m " + listaUsuariosManana);
                    }
                }

                break;
            default:
                Toast.makeText(this,"No hay mas clases",Toast.LENGTH_LONG).show();
                break;
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

        // compruebo que ya te has apuntado
        if(mApuntado && !nombre.isEmpty()){
            Toast.makeText(this,nombre+" ya te has apuntado",Toast.LENGTH_LONG).show();
        }


        if(!mApuntado && !nombre.isEmpty()) {
            // para mostrar inmediatamente
            nuevoUsuario = new Usuario(nombre, R.drawable.iconojpg);

            // usamos el swich para dar una clave diferente a las shared
            switch (itemAsignado+1){
                case 1:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c1hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase1_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c1hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c1md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase1_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c1md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 2:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c2hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase2_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c2hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c2md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase2_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c2md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }
                    break;
                case 3:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c3hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase3_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c3hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c3md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase3_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c3md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }
                    break;
                case 4:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c4hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase4_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c4hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c4md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase4_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c4md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 5:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c5hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase5_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c5hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c5md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase5_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c5md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 6:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c6hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase6_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c6hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c6md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase6_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c6md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 7:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c7hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase7_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c7hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c7md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase7_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c7md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 8:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c8hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase8_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c8hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c8md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase8_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c8md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 9:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c9hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase9_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c9hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c9md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase9_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c9md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 10:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c10hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase10_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c10hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c10md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase10_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c10md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 11:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c11hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase11_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c11hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c11md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase11_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c11md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 12:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c12hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase12_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c12hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c12md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase12_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c12md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }
                    break;
                case 13:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c13hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase13_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c13hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c13md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase13_box_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c13md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 14:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c14hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase14_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c14hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c14md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase14_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c14md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 15:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c15hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase15_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c15hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c15md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase15_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c15md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                case 16:
                    // miro en las shared para ver si ya se ha registrado
                    // lo guardo en una variable y la valido con un if

                    if(dia.equals("h")) {
                        boolean ok = mShared.getBoolean("c16hd",false); // miramos en el boolean de la clase en las shared

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en esta clase hoy",Toast.LENGTH_LONG).show(); // validamos el boolean de las shared
                        }else {

                            // lo añado a la lista de usuario
                            mListUsuarios.mListUsuarios.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase16_dojo_h", mListUsuarios.toJson());

                            // cambiamos el valor a true
                            mApuntado = true;                           // cambiamos el valor para luego cuando entro en el activity

                            // lo gurdo en la shared
                            editor.putBoolean("c16hd", mApuntado);     // creamos un boolean para validar luego arriba en esta clase
                            editor.apply();

                            Log.i("complu", "valor de lo que guardo en shared 1h: " + mListUsuarios.toJson());
                        }

                    }
                    if (dia.equals("m")) {
                        boolean ok = mShared.getBoolean("c16md",false);

                        if(ok){
                            Toast.makeText(this,"Ya estas apuntado en la clase de mañana",Toast.LENGTH_LONG).show();
                        }else{
                            listaUsuariosManana.mListUsuariosMañana.add(nuevoUsuario);
                            usuariosFechas.add(nuevoUsuario);

                            // lo guardo en las shared como un string con la clase json
                            editor.putString("clase16_dojo_m", listaUsuariosManana.toJson());

                            // cambio el valor a true
                            mApuntado = true;

                            editor.putBoolean("c16md",mApuntado);
                            editor.apply();

                            Log.i("complu","valor de lo que guardo en shared 1m: "+listaUsuariosManana.toJson());
                        }

                    }

                    break;
                default:
                    Toast.makeText(this,"No hay mas clases",Toast.LENGTH_LONG).show();
                    break;
            }

        }else {
            if(nombre.isEmpty()){
                Toast.makeText(this,"Tienes que escribír tu nombre",Toast.LENGTH_LONG).show();
            }
        }

    }
}