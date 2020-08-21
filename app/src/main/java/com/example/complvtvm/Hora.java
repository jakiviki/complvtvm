package com.example.complvtvm;

import com.google.gson.Gson;

public class Hora {
    public String hora;
    public int claveHora = 0;


    public int getClaveHora() {
        return claveHora;
    }

    public void setClaveHora(int claveHora) {
        this.claveHora = claveHora;
    }



    public Hora(String hora){
        this.hora = hora;
    }

    public Hora(){

    }

    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Fecha fromJson(String json){
        Gson gson = new Gson();
        Fecha fromJson = gson.fromJson(json,Fecha.class);
        return fromJson;
    }

    // seter
    public void setHora(String hora){
        this.hora = hora;
    }
    // geter
    public String getHora(){
        return hora;
    }
}
