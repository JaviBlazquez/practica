/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iluminacionyfecha;

/**
 *
 * @author javib
 */
import java.time.*;

public class Fecha {
   final LocalDate day=LocalDate.now();
    
    public LocalDate enseñar(){
        return day;
    }
    
    public LocalDate añadir(int pos){
        LocalDate dayplus=day.plusDays(pos);
        return dayplus;
    }
}
