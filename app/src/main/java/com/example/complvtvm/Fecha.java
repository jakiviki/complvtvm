package com.example.complvtvm;

import com.google.gson.Gson;

public class Fecha {
    private String hora;
    private int dia;
    private int mes;
    private int anio;

    public Fecha(){}

    public Fecha (String hora,int dia,int mes,int anio){
       this.hora = hora;
       this.dia = dia;
       this.mes = mes;
       this.anio = anio;
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



    public void setHora(String hora){
        this.hora = hora;
    }

    public String getHora(){
        return hora;
    }
    public void setDia(int dia){
        this.dia = dia;
    }

    public int getDia(){
        return dia;
    }
    public void setMes(int mes){
        this.mes = mes;
    }

    public int getMes(){
        return mes;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }

    public int getAnio(){
        return anio;
    }
}
