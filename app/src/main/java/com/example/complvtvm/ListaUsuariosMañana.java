package com.example.complvtvm;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaUsuariosMañana {
    public ArrayList<Usuario> mListUsuariosMañana;

    // constructor que instancia el ArrayList
    public ListaUsuariosMañana(){
        mListUsuariosMañana = new ArrayList<>();
    }

    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public ListaUsuariosMañana fromJson(String json){
        Gson gson = new Gson();
        ListaUsuariosMañana listaUsu = gson.fromJson(json,ListaUsuariosMañana.class);
        return listaUsu;
    }
}
