package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaBoxActivity extends AppCompatActivity {

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
    List<String> nombres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_box);

        editText = findViewById(R.id.id_editText_lisBox);
        boton = findViewById(R.id.id_botonBox);
        listView = findViewById(R.id.listaUsuarios);
        nuevoUsuario = new UsuarioFecha();


        // recupero las sharedPreferences
        sharedPreferences = getSharedPreferences("shared_horas_box",MODE_PRIVATE);
        nom0 = sharedPreferences.getString("nombre_clase0","");
        nom1 = sharedPreferences.getString("nombre_clase1","");
        nom2 = sharedPreferences.getString("nombre_clase2","");
        nom3 = sharedPreferences.getString("nombre_clase3","");
        nom4 = sharedPreferences.getString("nombre_clase4","");
        nom5 = sharedPreferences.getString("nombre_clase5","");


        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        Log.d("log","itemAsignado es: "+itemAsignado);

        usuariosFechas = new ArrayList<>();

        if( horario0 == itemAsignado & !nom0.isEmpty() ){
            String nomUsuario = sharedPreferences.getString("nombre_clase0","");
            usuariosFechas.add(new UsuarioFecha(nomUsuario,R.drawable.iconojpg));
            Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
        }else{
            if(horario1 == itemAsignado & !nom1.isEmpty()){
                String nomUsuario = sharedPreferences.getString("nombre_clase1","");
                usuariosFechas.add(new UsuarioFecha(nomUsuario,R.drawable.iconojpg));
                Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
            }else{
                if(horario2 == itemAsignado & !nom2.isEmpty()){
                    String nomUsuario = sharedPreferences.getString("nombre_clase2","");
                    usuariosFechas.add(new UsuarioFecha(nomUsuario,R.drawable.iconojpg));
                    Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                }else{
                    if(horario3 == itemAsignado & !nom3.isEmpty()){
                        String nomUsuario = sharedPreferences.getString("nombre_clase3","defaul");
                        usuariosFechas.add(new UsuarioFecha(nomUsuario,R.drawable.iconojpg));
                        Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                    }else{
                        if(horario4 == itemAsignado & !nom4.isEmpty()){
                            String nomUsuario = sharedPreferences.getString("nombre_clase4","defaul");
                            usuariosFechas.add(new UsuarioFecha(nomUsuario,R.drawable.iconojpg));
                            Log.d("log","registrado el usuario "+nomUsuario+" en el horario: "+itemAsignado);
                        }else {
                            if(horario5 == itemAsignado & !nom5.isEmpty()){
                                String nomUsuario = sharedPreferences.getString("nombre_clase5","defaul");
                                usuariosFechas.add(new UsuarioFecha(nomUsuario,R.drawable.iconojpg));
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
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nombre_clase0", nombre);
            editor.apply();
            Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();
        }else{
            if(horario1 == itemAsignado){
                String nombre = editText.getText().toString();
                nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                usuariosFechas.add(nuevoUsuario);
                // shared para guardar el intem y el nombre
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nombre_clase1", nombre);
                // editor.putInt("shared_item_uno", itemAsignado);
                editor.apply();
                Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

            }else{
                if(horario2 == itemAsignado){
                    String nombre = editText.getText().toString();
                    nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                    usuariosFechas.add(nuevoUsuario);
                    // shared para guardar el intem y el nombre
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nombre_clase2", nombre);
                    // editor.putInt("shared_item_uno", itemAsignado);
                    editor.apply();
                    Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

                }else{
                    if(horario3 == itemAsignado){
                        String nombre = editText.getText().toString();
                        nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                        usuariosFechas.add(nuevoUsuario);
                        // shared para guardar el intem y el nombre
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nombre_clase3", nombre);
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
                            editor.putString("nombre_clase4", nombre);
                            // editor.putInt("shared_item_uno", itemAsignado);
                            editor.apply();
                            Toast.makeText(this,"Te has apuntado a esta clase"+itemAsignado,Toast.LENGTH_LONG).show();

                        }else {
                            if(horario5 == itemAsignado){
                                String nombre = editText.getText().toString();
                                nuevoUsuario = new UsuarioFecha(nombre, R.drawable.iconojpg);
                                usuariosFechas.add(nuevoUsuario);
                                // shared para guardar el intem y el nombre
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("nombre_clase5", nombre);
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
// todo intenta separara los inten asignado para darle un valor diferencte y ya esta!!!