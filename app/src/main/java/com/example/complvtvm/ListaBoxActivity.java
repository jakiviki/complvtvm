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
    ListUsuarios mListUsuarios;
    Usuario mUsuario;
    int itemAsignado;
    Boolean mApuntado = false;
    ListaOk mlistOK;
    Ok ok;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_box);

        editText = findViewById(R.id.id_editText_lisBox);
        boton = findViewById(R.id.id_botonBox);
        listView = findViewById(R.id.listaUsuarios);
        mUsuario = new Usuario();
        usuariosFechas = new ArrayList<>();
        mListUsuarios = new ListUsuarios();
        mlistOK = new ListaOk();

        // recupero las sharedPreferences
        mShared = getSharedPreferences("complutum",MODE_PRIVATE);
        mEditor = mShared.edit();



        // recupero el intent
        Intent intent = getIntent();
        itemAsignado = intent.getIntExtra("item",0);
        Log.d("log","itemAsignado es: "+itemAsignado);



        switch (itemAsignado+1){
            case 1:
                // recupero el json de las shared
                String json = mShared.getString("clase1_box","");
                if(!json.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 2:
                // recupero el json de las shared
                String json2 = mShared.getString("clase2_box","");
                if(!json2.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json2);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 3:
                // recupero el json de las shared
                String json3 = mShared.getString("clase3_box","");
                if(!json3.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json3);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 4:
                // recupero el json de las shared
                String json4 = mShared.getString("clase4_box","");
                if(!json4.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json4);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 5:
                // recupero el json de las shared
                String json5 = mShared.getString("clase5_box","");
                if(!json5.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json5);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 6:
                // recupero el json de las shared
                String json6 = mShared.getString("clase6_box","");
                if(!json6.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json6);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 7:
                // recupero el json de las shared
                String json7 = mShared.getString("clase7_box","");
                if(!json7.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json7);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 8:
                // recupero el json de las shared
                String json8 = mShared.getString("clase8_box","");
                if(!json8.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json8);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 9:
                // recupero el json de las shared
                String json9 = mShared.getString("clase9_box","");
                if(!json9.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json9);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 10:
                // recupero el json de las shared
                String json10 = mShared.getString("clase10_box","");
                if(!json10.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json10);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 11:
                // recupero el json de las shared
                String json11 = mShared.getString("clase11_box","");
                if(!json11.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json11);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 12:
                // recupero el json de las shared
                String json12 = mShared.getString("clase12_box","");
                if(!json12.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json12);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 13:
                // recupero el json de las shared
                String json13 = mShared.getString("clase13_box","");
                if(!json13.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json13);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 14:
                // recupero el json de las shared
                String json14 = mShared.getString("clase14_box","");
                if(!json14.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json14);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 15:
                // recupero el json de las shared
                String json15 = mShared.getString("clase15_box","");
                if(!json15.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json15);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
                    }
                }
                break;
            case 16:
                // recupero el json de las shared
                String json16 = mShared.getString("clase16_box","");
                if(!json16.isEmpty()){
                    mListUsuarios = mListUsuarios.fromJson(json16);
                    for(Usuario u: mListUsuarios.mListUsuarios){
                        usuariosFechas.add(new Usuario(u.nombre,u.imagen));
                        Log.i("complu","estoy dentro del for de Box y añado los usuario");
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
        // cojemos el nombre del usuario escrito en el edit
        String nombre = editText.getText().toString();
       // mlistOK = new ListaOk();
        ok = new Ok();
        //mShared = getSharedPreferences("complutum",MODE_PRIVATE);
        //int ok = mShared.getInt("clase_box_bool",0);
        // recupero las sharedPreferences
        //mShared = getSharedPreferences("complutum",MODE_PRIVATE);
        String clave = mShared.getString("clase_box_bool","");
        mlistOK = mlistOK.fromJson(clave);
        //mlistOK = new ListaOk();
        mlistOK.mlistOK.add(ok); // añado algo para que no me diga que no tiene nada

       if(mlistOK.mlistOK.get(itemAsignado).numeroOk == itemAsignado){
           Log.i("complu","EURECAAAAAA SON IGUALES");
       }else{
           Log.i("complu","que coño pasa");
           Log.i("complu","valor de shared: "+mlistOK.mlistOK.get(itemAsignado).numeroOk);
       }
        // valido si ya te has apuntado y le informo que ya esta apuntado
        /*
        cada clase manda un numero igual que su item
        compruebo que si son iguales es que ya estubo dentro y se lo mando
        si es asi y ha puesto algo en el editext le digo que ya esta apuntado
        y si no tiene el numero es que no ha entrado todavia a una clase entonces
        le mando al else y que mande su numero correspondiente
         */
        if(mApuntado && !nombre.isEmpty() && mlistOK.mlistOK.get(itemAsignado).numeroOk == itemAsignado){
            Toast.makeText(this,nombre+" Ya te hás apúntado",Toast.LENGTH_LONG).show();
        }else {

            // compruebo que ha escrito algo y que no esta apuntado
            if (!nombre.isEmpty() & !mApuntado) {      // si esta escribiendo y la variable es todavia false  ejecuto el codigo
                usuariosFechas.add(new Usuario(nombre, R.drawable.iconojpg));

                // creamos un nuevo usuario y le paso el nombre
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.nombre = nombre;
                nuevoUsuario.imagen = R.drawable.iconojpg;

                // lo añado a la lista de usuario
                mListUsuarios.mListUsuarios.add(nuevoUsuario);
                // usamos el swich para dar una clave diferente a las shared
                switch (itemAsignado) {
                    case 0:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase1_box", mListUsuarios.toJson());
                        // mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;

                        ok.numeroOk = 0;
                        mlistOK.mlistOK.add(ok);
                        mEditor.putString("clase_box_bool", mlistOK.toJson());
                        mEditor.apply();
                        break;
                    case 1:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase2_box", mListUsuarios.toJson());
                        //mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;

                        ok.numeroOk= 1;
                        mlistOK.mlistOK.add(ok);
                        mEditor.putString("clase_box_bool",mlistOK.toJson());
                        mEditor.apply();
                        break;
                    case 2:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase3_box", mListUsuarios.toJson());
                        //mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;

                        ok.numeroOk= 2;
                        mlistOK.mlistOK.add(ok);
                        mEditor.putString("clase_box_bool", mlistOK.toJson());
                        mEditor.apply();
                        break;
                    case 3:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase4_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 4);
                        mEditor.apply();
                        break;
                    case 5:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase5_box", mListUsuarios.toJson());
                        //mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 5);
                        mEditor.apply();
                        break;
                    case 6:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase6_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 6);
                        mEditor.apply();
                        break;
                    case 7:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase7_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 7);
                        mEditor.apply();
                        break;
                    case 8:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase8_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 8);
                        mEditor.apply();
                        break;
                    case 9:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase9_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 9);
                        mEditor.apply();
                        break;
                    case 10:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase10_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1) + " " + nombre, Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 10);
                        mEditor.apply();
                        break;
                    case 11:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase11_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 11);
                        mEditor.apply();
                        break;
                    case 12:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase12_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        mEditor.putInt("clase_box_bool", 12);
                        mEditor.apply();
                        break;
                    case 13:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase13_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        break;
                    case 14:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase14_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        break;
                    case 15:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase15_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        break;
                    case 16:
                        // lo guardo en las shared como un string con la clase json
                        mEditor.putString("clase16_box", mListUsuarios.toJson());
                        mEditor.apply();
                        Toast.makeText(this, nombre + " te hás apuntado a la clase: " + (itemAsignado + 1), Toast.LENGTH_LONG).show();
                        // cambiamos el valor a true
                        mApuntado = true;
                        break;
                    default:
                        Toast.makeText(this, "No hay mas clases", Toast.LENGTH_LONG).show();
                        break;
                }


            } else {   // si viene vacio le saco un Toast para que lo rellene
                if (nombre.isEmpty()) {
                    Toast.makeText(this, "Tienes que escribír tu nombre", Toast.LENGTH_LONG).show();
                }
            }

        }

    }
}
