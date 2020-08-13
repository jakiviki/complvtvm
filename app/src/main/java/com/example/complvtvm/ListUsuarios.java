package com.example.complvtvm;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListUsuarios {
    public ArrayList<Usuario> mListUsuarios;

    // constructor que instancia el ArrayList
    public ListUsuarios(){
        mListUsuarios = new ArrayList<>();
    }

    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public ListUsuarios fromJson(String json){
        Gson gson = new Gson();
        ListUsuarios listUsuarios = gson.fromJson(json,ListUsuarios.class);
        return listUsuarios;
    }
}
