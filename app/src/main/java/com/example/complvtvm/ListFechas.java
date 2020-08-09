package com.example.complvtvm;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListFechas {
    public List<Fecha> fechas;

    public ListFechas(){
        fechas = new ArrayList<>();
    }

    // metodo para combertir a json
    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    // metodo para pasar un json a objeto
    public ListFechas fromJson(String json){
        Gson gson = new Gson();
        ListFechas listFechas = gson.fromJson(json,ListFechas.class);
        return listFechas;
    }
}
