/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import iluminacionyfecha.Fecha;

/**
 *
 * @author javib
 */
final class Comida {

   private float comidainicio;
   private float comidaincremento;
   private float comidafinal;
   private int diaincremento;
   private final float[] dias;

   public Comida(){
       this.dias=new float[30];
   }
    public void setcomidainicio(float _ci) {
        this.comidainicio = _ci;
    }

    public float getcomidainicio() {
        return this.comidainicio;
    }

    public void setcomidaincremento(float _cinc) {
        this.comidaincremento = _cinc;
    }

    public float getcomidaincremento() {
        return this.comidaincremento;
    }

    public void setdiaincremento(int _dinc) {
        this.diaincremento = _dinc;
    }

    public int getdiaincremento() {
        return this.diaincremento;
    }

    public void setcomidafinal(float _cf) {
        this.comidafinal = _cf;
    }

    public float getcomidafinal() {
        return this.comidafinal;
    }

    public void setdias(int dia) {
        if (dia < this.diaincremento) {
            this.dias[dia] = (((this.comidaincremento - this.comidainicio) / (this.diaincremento))
                    * (dia - 0)) + this.comidainicio;
        }
        if (dia >= this.diaincremento) {
            this.dias[dia] = (((this.comidafinal - this.comidaincremento)
                    / (29 - this.diaincremento)) * (dia - this.diaincremento)) + this.comidaincremento;
        }
    }

    public float[] getdias() {
        return dias;
    }

    public void DarFecha(Fecha f1) {
        for(int pos=0;pos<30;pos++){
        System.out.println("\nLa comida en el dia "+f1.añadir(pos)+" sera: "+this.dias[pos]);
        }
    }
    
    @Override
    public String toString() {
        return "La comida inicial sera: " + this.comidainicio + "\nLa comida incremento sera: "
                + this.comidaincremento + "\nLa comida final sera: " + this.comidafinal + "\nEl dia "
                + "incremento sera: " + this.diaincremento;
    }

    
}
