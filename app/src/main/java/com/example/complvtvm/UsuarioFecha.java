package com.example.complvtvm;

public class UsuarioFecha {
    public int imagen;
    public String nombre;
    public int hora;
    public int dia;
    public int mes;
    public int anio;

    public UsuarioFecha(){

    }


    public UsuarioFecha(String nom,int hora,int dia,int mes,int anio){
        this.nombre = nom;
        this.hora = hora;
        this.dia = dia;
        this.anio = anio;
    }

    public UsuarioFecha(String nombre, int imagen){
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public void setImagen(int imagen){
        this.imagen = imagen;
    }

    public int getImagen(){
        return imagen;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setHora(int hora){
        this.hora = hora;
    }

    public int getHora(){
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
