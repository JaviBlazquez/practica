/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import iluminacionyfecha.Iluminacion;

/**
 *
 * @author javib
 */
final class PoblacionBacterias {
   private float temperatura;
   private String nombre;
   private int numerobacterias;
   private Iluminacion luminosidad;
   private Comida comidas;
    
    public void settemperatura(float _temp){
        this.temperatura=_temp;
    }
    public float gettemperatura(){
        return this.temperatura;
    }
    public void setcomidas(Comida c1){
        this.comidas=c1;
    }
    public Comida getcomidas(){
        return this.comidas;
    }
    public void setnombre(String _name){
        this.nombre=_name;
    }
    public String getnombre(){
        return this.nombre;
    }
    public void setnumerobacterias(int _numbac){
        this.numerobacterias=_numbac;
    }
    public int getnumerobacterias(){
        return this.numerobacterias;
    }
    public void setluminosidad(Iluminacion _ilum){
        this.luminosidad=_ilum;
    }
    public Iluminacion getluminosidad(){
        return this.luminosidad;
    }
    
    /**
     *
     * @return
     */
    /*This toString reads the values of the variables*/
    @Override
    public String toString(){
      return "\nLa poblacion se llama: "+this.nombre+"\nHay: "+this.numerobacterias+
              " bacterias"+"\nLa temperatura es: "+this.temperatura+"º"+"\nLa luminosidad es: "
              +this.luminosidad+"\n----La comida es----\n"+comidas.toString();
    }
}
