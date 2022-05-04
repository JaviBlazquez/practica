/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

/**
 *
 * @author javib
 */

final class Experimento {
 private int TAM;
 private PoblacionBacterias[] experimento;
    
 public Experimento(){
     this.TAM=100;
     this.experimento=new PoblacionBacterias[TAM];
 }
public void setexperimento(int pos,PoblacionBacterias _p1){
    this.experimento[pos]=_p1;
}
public PoblacionBacterias getexperimento(int pos){
    return this.experimento[pos];
}
public int getTAM(){
    return this.TAM;
}
public String toString(int pos){
    return " "+this.experimento[pos];
}
}