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
    Boolean mApuntado = false;
    int itemAsignado;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dojo);
        editText = findViewById(R.id.id_edit_nom_dojo);
        boton = findViewById(R.id.id_boton_apun_dojo);
        listView = findViewById(R.id.id_lisView_apun_dojo);

        // recupero las sharedPreferences
        mShared = getSharedPreferences("complutum",MODE_PRIVATE);  // lectura de disco
        editor = mShared.edit();                                          // grabar en disco

        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        Log.d("log","itemAsignado es: "+itemAsignado);

        usuariosFechas = new ArrayList<>();
        usuariosFechas.add(new Usuario("Carmelo",R.drawable.iconojpg));

        // Instancio la variable listaUsuarios
        mListUsuarios = new ListUsuarios();

        // usamos el swich para dar una clave diferente a las shared
        switch (itemAsignado+1){
            case 1:
                // llamo a las shared para mostrarlas en el activity
                String json = mShared.getString("clase1_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 2:
                // llamo a las shared para mostrarlas en el activity
                String json2 = mShared.getString("clase2_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json2.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json2);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 3:

                // llamo a las shared para mostrarlas en el activity
                String json3 = mShared.getString("clase3_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json3.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json3);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 4:
                // llamo a las shared para mostrarlas en el activity
                String json4 = mShared.getString("clase4_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json4.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json4);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 5:
                // llamo a las shared para mostrarlas en el activity
                String json5 = mShared.getString("clase5_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json5.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json5);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 6:
                // llamo a las shared para mostrarlas en el activity
                String json6 = mShared.getString("clase6_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json6.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json6);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 7:
                // llamo a las shared para mostrarlas en el activity
                String json7 = mShared.getString("clase7_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json7.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json7);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 8:
                // llamo a las shared para mostrarlas en el activity
                String json8 = mShared.getString("clase8_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json8.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json8);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 9:
                // llamo a las shared para mostrarlas en el activity
                String json9 = mShared.getString("clase9_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json9.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json9);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 10:

                // llamo a las shared para mostrarlas en el activity
                String json10 = mShared.getString("clase10_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json10.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json10);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 11:
                // llamo a las shared para mostrarlas en el activity
                String json11 = mShared.getString("clase11_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json11.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json11);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 12:
                // llamo a las shared para mostrarlas en el activity
                String json12 = mShared.getString("clase12_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json12.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json12);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 13:
                // llamo a las shared para mostrarlas en el activity
                String json13 = mShared.getString("clase13_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json13.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json13);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 14:

                // llamo a las shared para mostrarlas en el activity
                String json14 = mShared.getString("clase14_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json14.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json14);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }
                break;
            case 15:
                // llamo a las shared para mostrarlas en el activity
                String json15 = mShared.getString("clase15_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json15.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json15);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                    }
                }

                break;
            case 16:
                // llamo a las shared para mostrarlas en el activity
                String json16 = mShared.getString("clase16_dojo","");
                // miro si viene lleno y lo añado a la lista
                if ( !json16.isEmpty()){
                    mListUsuarios= mListUsuarios.fromJson(json16);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
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
        if(mApuntado){
            Toast.makeText(this,nombre+" ya te has apuntado",Toast.LENGTH_LONG).show();
        }


        if(!mApuntado && !nombre.isEmpty()) {
            nuevoUsuario = new Usuario(nombre, R.drawable.iconojpg);
            usuariosFechas.add(nuevoUsuario);

            // usamos el swich para dar una clave diferente a las shared
            switch (itemAsignado+1){
                case 1:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase1_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;
                    break;
                case 2:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase2_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 3:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase3_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 4:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase4_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 5:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase5_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 6:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase6_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 7:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase7_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 8:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase8_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 9:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase9_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 10:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase10_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 11:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase11_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 12:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase12_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 13:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase13_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 14:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase14_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 15:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase15_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

                    break;
                case 16:
                    // guardo en la lista el nuevo usuario y luego guardo la lista en las shared
                    mListUsuarios.mListUsuarios.add(nuevoUsuario);
                    editor.putString("clase16_dojo", mListUsuarios.toJson());
                    editor.apply();
                    Toast.makeText(this,nombre+" te hás apuntado a la clase: "+(itemAsignado+1),Toast.LENGTH_LONG).show();
                    mApuntado = true;

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