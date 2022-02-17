package com.uta.caizaguanokevinsupletorio.Entidades;

public class Tarea {

     private String Cedula;
     private  String Tarea;
     private  String Descripcion;
     private  String Tipo;



     public Tarea(){

     }

     public Tarea(String cedula, String tarea, String descripcion, String tipo ) {
          Cedula = cedula;
          Tarea = tarea;
          Descripcion = descripcion;
          Tipo = tipo;

     }

     public String getCedula() {
          return Cedula;
     }

     public void setCedula(String cedula) {
          Cedula = cedula;
     }

     public String getTarea() {
          return Tarea;
     }

     public void setTarea(String tarea) {
          Tarea = tarea;
     }

     public String getDescripcion() {
          return Descripcion;
     }

     public void setDescripcion(String descripcion) {
          Descripcion = descripcion;
     }

     public String getTipo() {
          return Tipo;
     }

     public void setTipo(String tipo) {
          Tipo = tipo;
     }
}
