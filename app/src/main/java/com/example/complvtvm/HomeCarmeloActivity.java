package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeCarmeloActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // creamos el array para mostrar horarios
    ArrayList<String> horarios = new ArrayList<>();
    ListView listView;
    Button btn;
    int  nAforo;
    ListadoDeHoras mHoras;
    int position;
    int tope;
    private String texto;

    // DECLARACION DE LAS SHAREDPREFERENCES
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    // todo hacer que todas las variables tengan el valor de las shared


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_carmelo);

        mPrefs= getSharedPreferences("complutum",MODE_PRIVATE);  // INSTANCIAMOS LAS SHARED
        mEditor = mPrefs.edit();
        horarios = new ArrayList<>();                                   // INSTANCIAMOS EL ARRAY DE STRING
        listView = findViewById(R.id.listv_horarios_carmelo);
        btn = findViewById(R.id.btn_añadir_carmelo);

        // MIRAMOS EN LAS SHARED Y SI NO LO HARCODEAMOS
        String json = mPrefs.getString("horarios_shared","");


        if (!json.isEmpty()){
            mHoras = new ListadoDeHoras();
            mHoras = mHoras.fromJson(json); // le paso el String de las shared
            for(Hora h: mHoras.mListHorarios){
                horarios.add(h.hora);
            }
            Log.i("complu","dentro del if ..añadios a la lista harcodeada el valor de mHoras para la vista del activity = "+json);

        }else{
            //////////////// msj //////////////
            Toast.makeText(this,"Añade una hora",Toast.LENGTH_LONG).show();
            mHoras= new ListadoDeHoras();

        }

        ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.item,horarios);
        // añadimos a la vista el adapter con su metodo
        listView.setAdapter(adapter);
        // añadimos un evento click a la listView
        listView.setOnItemClickListener(this);


    }

    // metodo para borrar los horarios de la lista
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        position = i+1;   // i = 0

        tope = mPrefs.getInt("topClass",0);

        // intento extraer el string
        TextView textView = view.findViewById(R.id.mi_item);
        String textoTxv = textView.getText().toString();
        texto = textoTxv;

        //COMPRUEBO EL CONTENIDO DE LOS HORARIOS EN LAS SHARED
        String contenidoHoras = mPrefs.getString("horarios_shared","");
        Log.i("complu","/////////contenido_de_las_shared_antes_de_eliminar"+contenidoHoras);

        Log.i("complu","homeCarmelo/onitemclick  position vale = "+position);
        Log.i("complu","homeCarmelo/onitemclick  tope vale = "+tope);
        // llamanos al dialog para preguntar si quiere eliminar
        DialogEliminar dialogEliminar = new DialogEliminar();
        dialogEliminar.show(getSupportFragmentManager(),"eliminar_horario");

    }

    public void añadirHorarioCarmelo (View v){
        DialogCarmelo dialogCarmelo = new DialogCarmelo();
        dialogCarmelo.show(getSupportFragmentManager(),"nuevo_horario");
    }


    public void eliminarHorario(){

        /// lo borro de la vista del usuario
        if ( horarios.size() > 0){
            horarios.remove(position-1);
            ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
            adapter.notifyDataSetChanged();

            // lo eliminamos de las lista
            mHoras.mListHorarios.remove(position-1);

            // y lo guardamos en las shared
            mPrefs= getSharedPreferences("complutum",MODE_PRIVATE);
            mEditor = mPrefs.edit();
            mEditor.putString("horarios_shared",mHoras.toJson());
            mEditor.apply();
        }else {
            Log.i("complu","homCarmelo el valor de posicion es  "+position);

        }


    }

    public void añadirAforoCarmelo(View v){
        DialogAforo dialogAforo = new DialogAforo();
        dialogAforo.show(getSupportFragmentManager(),"nuevo_aforo");
    }


    // METODO PARA AÑADIR UN HORARIO DESDE EL DIALOG DE ESTA ACTIVITY
    public void nuevoHorario(String hora){


        // llamamos a las shared
        mPrefs= getSharedPreferences("complutum",MODE_PRIVATE);
        mEditor = mPrefs.edit();

        // compruebo el tope de las shared para limitar el numero de clases del profesor obligandole a borrar y usar las claves en el oncreate/añadir
        tope = mPrefs.getInt("topClass",0);  // leeo las shared

        if(tope <16){
            tope +=1;
            mEditor.putInt("topClass",tope);
            mEditor.apply();
            Log.i("complu","//////subiendo_el_tope Valor de el tope de clases = "+tope);
                while (tope > 14){
                    Toast.makeText(this, R.string.estas_consumiendo_mucha_memoria,Toast.LENGTH_LONG).show();
                    break;
                }


            // crear un objeto hora y le paso la hora y la clave desde el dialog
           Hora nuevaHora = new Hora();
           nuevaHora.hora= hora;

           int clave = 1;
           int claveShared = mPrefs.getInt("clave",0);

               if (claveShared == 0){
                   nuevaHora.setClaveHora(clave);  // le paso la clave 1 al primer horario
                   int nuevaClave = claveShared +1;
                   mEditor.putInt("clave",nuevaClave);
                   mEditor.apply();
                   Log.i("complu","HomeCarmelo/agregar  Añadiendo una clave nueva= "+nuevaHora.getClaveHora());
               } else
                    {
                       if(claveShared <16){
                           int nuevaClave = claveShared +1;
                           nuevaHora.setClaveHora(nuevaClave);
                           mEditor.putInt("clave",nuevaClave);
                           mEditor.apply();
                           Log.i("complu","////////subiendo_el_valor de la claveHora valor= "+nuevaClave);

                        } else
                                {
                                    if(claveShared >= 16){
                                        int nuevaClave =  1;
                                        nuevaHora.setClaveHora(nuevaClave);
                                        mEditor.putInt("clave", nuevaClave);
                                        mEditor.apply();
                                        Log.i("complu", "/////////////bajando_el_valor_de_la_claveHora valor = " + nuevaClave);

                                    }
                                }
                    }

                horarios.add(hora);
                Log.i("complu","la hora que llega es "+hora);

                // lo metemos en el listado de horas
                mHoras.mListHorarios.add(nuevaHora);

                // y lo guardamos en las shared
                mEditor.putString("horarios_shared",mHoras.toJson());
                mEditor.apply();

                ////////////// mensajes ///////////
                Log.i("complu","/////////////////homeCarmelo/nuevoHorario////////AÑADO_NUEVA_HORA////////");
                Log.i("complu","homeCarmelo/nuevohorario guardo en las shared = "+mHoras.toJson());
                Log.i("complu","homecarmelo/nuevoHorario  valor del mhoras.mlisthorarios.size = "+mHoras.mListHorarios.size());
        }else
            {
                Toast.makeText(this, R.string.elimina_un_horario_antes_de_añadir_otro,Toast.LENGTH_LONG).show();
            }


    }

    public void nuevoAforo(String aforo){   // desde el dialog le paso el string y lo guardo en aforo
        mPrefs = getSharedPreferences("complutum",MODE_PRIVATE);
        mEditor = mPrefs.edit();
        mEditor.putString("aforo",aforo);
        // combierto el aforo String en integer para usarlo en las clases
        nAforo =Integer.parseInt(aforo);
        mEditor.putInt("nAforo",nAforo);
        mEditor.apply();
    }

    // metodo que llamo en el dialog una vez que posicion ya tiene el valor del item selecionado
    public void eliminarShared(){

        // convoco a las shared
        SharedPreferences prefs = getSharedPreferences("complutum",MODE_PRIVATE);   // lectura
        SharedPreferences.Editor editor = prefs.edit();                        // edicion en disco

        tope = prefs.getInt("topClass",0);
        String horaR = mPrefs.getString("horarios_shared", "");
        mHoras = mHoras.fromJson(horaR);

        Log.i("complu","////////homeCarmelo/eliminar___lo_que_viene_de_las_shared y quiero borrar "+horaR);

        if(tope >= 0){
            tope -=1;
            editor.putInt("topClass",tope);
            editor.apply();
            Log.i("complu","//////////bajando_1_el_tope valor de tope = "+tope);
        }

        for (Hora h: mHoras.mListHorarios) {

            if(h.hora.equals(texto)) {

                Log.i("complu", "/////////////borrando_las_personas_de_las_clases " +h.hora);
                switch (h.getClaveHora()) {
                    ////////////////prueba para buscasr en el tab de las shared//////////

                    case 1:
                        String clase =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c1h");
                        editor.remove("c1m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 1 ya borrado = "+prefs.getString(clase,""));

                        break;
                    case 2:
                        String clase2 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 2 = " + prefs.getString(clase2,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c2h");
                        editor.remove("c2m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 2 ya borrado  = "+prefs.getString(clase2,""));

                        break;
                    case 3:
                        String clase3 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 3 = " + prefs.getString(clase3,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c3h");
                        editor.remove("c3m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 3 ya borrado = "+prefs.getString(clase3,""));

                        break;
                    case 4:
                        String clase4 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 4 = " + prefs.getString(clase4,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c4h");
                        editor.remove("c4m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 4 ya borrado  = "+prefs.getString(clase4,""));

                        break;
                    case 5:
                        String clase5 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase5,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c5h");
                        editor.remove("c5m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 5 ya borrado = "+prefs.getString(clase5,""));

                        break;
                    case 6:
                        String clase6 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase6,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c6h");
                        editor.remove("c6m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 6 ya borrado = "+prefs.getString(clase6,""));

                        break;
                    case 7:
                        String clase7 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase7,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c7h");
                        editor.remove("c7m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 7 ya borrado = "+prefs.getString(clase7,""));

                        break;
                    case 8:
                        String clase8 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase8,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c8h");
                        editor.remove("c8m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 8 ya borrado  = "+prefs.getString(clase8,""));

                        break;
                    case 9:
                        String clase9 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase9,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c9h");
                        editor.remove("c9m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 9 ya borrado = "+prefs.getString(clase9,""));

                        break;
                    case 10:
                        String clase10 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase10,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c10h");
                        editor.remove("c10m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 10 ya borrado = "+prefs.getString(clase10,""));

                        break;
                    case 11:
                        String clase11 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase11,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c11h");
                        editor.remove("c11m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 11 ya borrado = "+prefs.getString(clase11,""));

                        break;
                    case 12:
                        String clase12 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase12,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c12h");
                        editor.remove("c12m");
                        editor.apply();
                        Log.i("complu","/////////valor_de_la_clase 12 ya borrado = "+prefs.getString(clase12,""));
                        break;
                    case 13:
                        String clase13 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase13,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c13h");
                        editor.remove("c13m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 13 ya borrado = "+prefs.getString(clase13,""));

                        break;
                    case 14:
                        String clase14 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase14,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c14h");
                        editor.remove("c14m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 14 ya borrado = "+prefs.getString(clase14,""));

                        break;
                    case 15:
                        String clase15 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase15,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c15h");
                        editor.remove("c15m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 15 ya borrado = "+prefs.getString(clase15,""));

                        break;
                    case 16:
                        String clase16 =  h.getHora()+"h";
                        Log.i("complu", "/////////////borrandoooo personas de las clases 1 = " + prefs.getString(clase16,""));
                        Log.i("complu", "valor del h.gethora() =" + h.getHora());

                        editor.remove(h.getHora() + "h");
                        editor.remove(h.getHora() + "m");    ////seguir por aquiii
                        editor.remove(h.getHora() + "dh");
                        editor.remove(h.getHora() + "dm");
                        editor.remove("c16h");
                        editor.remove("c16m");
                        editor.apply();

                        Log.i("complu","/////////valor_de_la_clase 16 ya borrado = "+prefs.getString(clase16,""));

                        break;
                    default:
                        Toast.makeText(this, "No hay mas clases", Toast.LENGTH_LONG).show();
                        break;


                }
            }else{
                Log.i("complu","//////////no_entra_en_el_swith porque no valida el if,porque h.hora es: "+h.hora+" y texto es: "+texto);
            }

        }
    }

    // metodo para eliminar la actividad y que cuando salga de esta no se muestre el dialog

}
