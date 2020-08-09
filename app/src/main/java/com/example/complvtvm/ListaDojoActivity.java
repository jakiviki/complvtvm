package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaDojoActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<UsuarioFecha> usuariosFechas;
    EditText editText;
    Button boton;
    SharedPreferences sharedPreferences;
    int itemAsignado;
    int horario0 = 0;
    int horario1 = 1;
    int horario2 = 2;
    int horario3 = 3;
    int horario4 = 4;
    int horario5 = 5;
    UsuarioFecha nuevoUsuario;
    String nom0;
    String nom1;
    String nom2;
    String nom3;
    String nom4;
    String nom5;
    ArrayList<String> nombres2 = new ArrayList<>();
    Boolean vacio = true;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dojo);
        editText = findViewById(R.id.id_edit_nom_dojo);
        boton = findViewById(R.id.id_boton_apun_dojo);
        listView = findViewById(R.id.id_lisView_apun_dojo);
        //nuevoUsuario = new UsuarioFecha();
        nombres2.add("javi");


        // recupero las sharedPreferences
        sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);
        nom0 = sharedPreferences.getString("nombre_clase0_dojo","");
        nom1 = sharedPreferences.getString("nombre_clase1_dojo","");
        nom2 = sharedPreferences.getString("nombre_clase2_dojo","");
        nom3 = sharedPreferences.getString("nombre_clase3_dojo","");
        nom4 = sharedPreferences.getString("nombre_clase4_dojo","");
        nom5 = sharedPreferences.getString("nombre_clase5_dojo","");


        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        Log.d("log","itemAsignado es: "+itemAsignado);

        usuariosFechas = new ArrayList<>();
        usuariosFechas.add(new UsuarioFecha("Carmelo",R.drawable.iconojpg));




        if( horario0 == itemAsignado & !nom0.isEmpty()){
            String nomUsuario = sharedPreferences.getString("nombre_clase0_dojo","");
            usuariosFechas.add(new UsuarioFecha(nom0,R.drawable.iconojpg));
            Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
        }else{
            if(horario1 == itemAsignado & !nom1.isEmpty()){
                String nomUsuario = sharedPreferences.getString("nombre_clase1_dojo","");
                usuariosFechas.add(new UsuarioFecha(nom1,R.drawable.iconojpg));
                Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
            }else{
                if(horario2 == itemAsignado & !nom2.isEmpty()){
                    String nomUsuario = sharedPreferences.getString("nombre_clase2_dojo","");
                    usuariosFechas.add(new UsuarioFecha(nom2,R.drawable.iconojpg));
                    Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                }else{
                    if(horario3 == itemAsignado & !nom3.isEmpty()){
                        String nomUsuario = sharedPreferences.getString("nombre_clase3_dojo","");
                        usuariosFechas.add(new UsuarioFecha(nom3,R.drawable.iconojpg));
                        Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                    }else{
                        if(horario4 == itemAsignado & !nom4.isEmpty()){
                            String nomUsuario = sharedPreferences.getString("nombre_clase4_dojo","");
                            usuariosFechas.add(new UsuarioFecha(nom4,R.drawable.iconojpg));
                            Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                        }else {
                            if(horario5 == itemAsignado & !nom5.isEmpty()){
                                String nomUsuario = sharedPreferences.getString("nombre_clase5_dojo","");
                                usuariosFechas.add(new UsuarioFecha(nom5,R.drawable.iconojpg));
                                Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                            }
                        }
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

        // valido si estoy en otro horario si son diferntes creo una nueva shared con otro numero
        if (horario0 == itemAsignado){
            String nombre = editText.getText().toString();
            nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
            usuariosFechas.add(nuevoUsuario);
            // shared para guardar el intem y el nombre
            sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nombre_clase0_dojo", nombre);
            editor.apply();
            Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();
        }else{
            if(horario1 == itemAsignado){
                String nombre = editText.getText().toString();
                nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                usuariosFechas.add(nuevoUsuario);
                // shared para guardar el intem y el nombre
                sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nombre_clase1_dojo", nombre);
                // editor.putInt("shared_item_uno", itemAsignado);
                editor.apply();
                Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

            }else{
                if(horario2 == itemAsignado){
                    String nombre = editText.getText().toString();
                    nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                    usuariosFechas.add(nuevoUsuario);
                    // shared para guardar el intem y el nombre
                    sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nombre_clase2_dojo", nombre);
                    // editor.putInt("shared_item_uno", itemAsignado);
                    editor.apply();
                    Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

                }else{
                    if(horario3 == itemAsignado){
                        String nombre = editText.getText().toString();
                        nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                        usuariosFechas.add(nuevoUsuario);
                        // shared para guardar el intem y el nombre
                        sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nombre_clase3_dojo", nombre);
                        // editor.putInt("shared_item_uno", itemAsignado);
                        editor.apply();
                        Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

                    }else{
                        if(horario4 == itemAsignado){
                            String nombre = editText.getText().toString();
                            nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                            usuariosFechas.add(nuevoUsuario);
                            // shared para guardar el intem y el nombre
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("nombre_clase4_dojo", nombre);
                            // editor.putInt("shared_item_uno", itemAsignado);
                            editor.apply();
                            Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

                        }else {
                            if(horario5 == itemAsignado){
                                String nombre = editText.getText().toString();
                                nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                                usuariosFechas.add(nuevoUsuario);
                                // shared para guardar el intem y el nombre
                                sharedPreferences = getSharedPreferences("shared_horas_dojo",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("nombre_clase5_dojo", nombre);
                                // editor.putInt("shared_item_uno", itemAsignado);
                                editor.apply();
                                Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
        }
    }
}