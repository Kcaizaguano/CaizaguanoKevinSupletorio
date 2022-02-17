package com.uta.caizaguanokevinsupletorio.Entidades;

public class Usuario {

    private  String cedula;
    private  String contrasenia;

    public Usuario(){

    }

    public Usuario(String cedula, String contrasenia) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
