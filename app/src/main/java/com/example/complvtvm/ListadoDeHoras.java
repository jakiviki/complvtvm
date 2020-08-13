package com.example.complvtvm;

import com.google.gson.Gson;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class ListadoDeHoras {
    public ArrayList<Hora> mListHorarios;

    public ListadoDeHoras(){
        mListHorarios = new ArrayList<>();
    }

    // metodo para pasar a json
    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    // metodo para pasar a objeto de un json
    public ListadoDeHoras fromJson(String json){
        Gson gson = new Gson();
        ListadoDeHoras listadoDeHoras = gson.fromJson(json,ListadoDeHoras.class);
        return listadoDeHoras;
    }
}
