package com.example.complvtvm;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaOk {
    public ArrayList<Ok> mlistOK;

    public ListaOk(){
        mlistOK = new ArrayList<>();
    }

    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public ListaOk fromJson(String json){
        Gson gson = new Gson();
        ListaOk listaOk = gson.fromJson(json, ListaOk.class);
        return listaOk;
    }
}
