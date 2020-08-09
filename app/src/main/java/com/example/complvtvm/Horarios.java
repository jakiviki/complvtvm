package com.example.complvtvm;

public class Horarios {
    private String hora;

    public Horarios(String hora){
        this.hora = hora;
    }

    public Horarios(){

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
