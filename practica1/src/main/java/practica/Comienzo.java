/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

/**
 *
 * @author javib
 */
import iluminacionyfecha.Iluminacion;
import iluminacionyfecha.Fecha;
import excepciones.IlumException;
import excepciones.FoodException;
import excepciones.DiaException;
import java.io.*;

abstract class Comienzo{

    public static void main(String[] args)throws DiaException,FoodException{
        int opcion;
        int pos = 0;
        Experimento e1 = new Experimento();
        Fecha f = new Fecha();
        while (true) {
            opcion = menu();
            switch (opcion) {
                case 1:
                    meter(e1, pos, f);
                    pos++;
                    presskey();
                    break;
                case 2:
                    vernombre(e1);
                    presskey();
                    break;
                case 3:
                    borrar(e1);
                    presskey();
                    break;
                case 4:
                    verinfo(e1, f);
                    presskey();
                    break;
                case 5:
                    save(e1,f);
                    presskey();
                    break;
                case 6:
                    saveas(e1, f);
                    presskey();
                    break;
                case 7:
                    System.out.println("Adios");
                    System.exit(0);
            }
        }
    }

    /*This method is called at the beggininh of the while, and shows the console
    and asks for an option for the switch*/
    static int menu() {
        InputStreamReader iptr = null;
        BufferedReader consola = null;
        String stringleida;
        int opcion = 0;
        try {
            iptr = new InputStreamReader(System.in);
            consola = new BufferedReader(iptr);
            System.out.println("\n----Eliga una opción----");
            System.out.println("1º Meter poblacion\n2º Visualizar todos los nombres"
                    + "\n3º Borrar poblacion\n4º Ver informacion de una poblacion"
                    + "\n5º Guardar\n6º Guardar como\n7º Salir");
            stringleida = consola.readLine();
            opcion = Integer.parseInt(stringleida);
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
        return opcion;
    }

    /*This method is called at the end of each case in the switch(excluding case 7),
    and is used to show all the info until you press any key*/
    static void presskey() {
        BufferedReader br = null;
        InputStreamReader iptr = null;
        String sigue;
        try {
            iptr = new InputStreamReader(System.in);
            br = new BufferedReader(iptr);
            System.out.println("Presiona una tecla...");
            sigue = br.readLine();
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
    }

    /*This method is called in opcion 1,and is used to create new popullations*/
    static Experimento meter(Experimento e1, int pos, Fecha f1) throws DiaException,FoodException{
        BufferedReader br = null;
        InputStreamReader iptr = null;
        int diaincremento, ci, cincr, cf, temp, num;
        String stringleida, nombre, ilum;
        try {
            iptr = new InputStreamReader(System.in);
            br = new BufferedReader(iptr);
            PoblacionBacterias p1 = new PoblacionBacterias();
            Comida c1 = new Comida();
            System.out.println("\nDame el dia para la comida maxima (1-30)");
            stringleida = br.readLine();
            diaincremento = Integer.parseInt(stringleida);
            if(diaincremento<0 || 30<diaincremento){
                throw new DiaException("El dia no es valido");
            }else{
                c1.setdiaincremento(diaincremento);
            }
            System.out.println("\nDame la comida inical (0-300)");
            stringleida = br.readLine();
            ci = Integer.parseInt(stringleida);
            if(ci<=0 || ci>300){
                throw new FoodException("La comida no es correcta");
            }else{
               c1.setcomidainicio(ci); 
            }
            System.out.println("\nDame la comida final (0-300)");
            stringleida = br.readLine();
            cf = Integer.parseInt(stringleida);
            if(cf<=0 || cf>300){
                throw new FoodException("La comida no es correcta");
            }else{
              c1.setcomidafinal(cf);  
            }
            System.out.println("\nDame la comida maxima (0-300)");
            stringleida = br.readLine();
            cincr = Integer.parseInt(stringleida);
            if(cincr<=0 ||cincr<ci ||cincr<cf ||cincr>300){
                throw new FoodException("La comida no es correcta");
            }else{
            c1.setcomidaincremento(cincr);
            }
            System.out.println("\nDime su nombre");
            nombre = br.readLine();
            p1.setnombre(nombre);
            try{
                System.out.println("\nCuanta cantidad de luz deseas (alta,media o baja)");
            ilum = br.readLine();
            if (ilum.equalsIgnoreCase("alta")) {
                p1.setluminosidad(Iluminacion.ALTA);
            } else if (ilum.equalsIgnoreCase("media")) {
                p1.setluminosidad(Iluminacion.MEDIA);
            } else if (ilum.equalsIgnoreCase("baja")) {
                p1.setluminosidad(Iluminacion.BAJA);
            }else{
                throw new IlumException("Iluminacion no permitida");
            }
            }catch(Exception e){
                System.out.println(e.getMessage()); 
            }
            System.out.println("\nEspecifique el numero de bacterias");
            stringleida = br.readLine();
            num = Integer.parseInt(stringleida);
            p1.setnumerobacterias(num);
            System.out.println("\nSeñale la temperatura que desea");
            stringleida = br.readLine();
            temp = Integer.parseInt(stringleida);
            p1.settemperatura(temp);
            for (int dia = 0; dia < 30; dia++) {
                c1.setdias(dia);
            }
            p1.setcomidas(c1);
            e1.setexperimento(pos, p1);
            System.out.println(e1.toString(pos));
                c1.DarFecha(f1);
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
        return e1;
    }

    /*This method allows you to visualize every name on the experiment*/
    static void vernombre(Experimento e1) {
        int pos, indicador = 0;
        for (pos = 0; pos < e1.getTAM(); pos++) {
            if (e1.getexperimento(pos) != null) {
                indicador++;
                System.out.println("\nEl nombre " + indicador + " es: " + e1.getexperimento(pos).getnombre());
            }
        }
    }

    /*This method deletes one entire population from the experiment*/
    static void borrar(Experimento e1) {
        InputStreamReader iptr = null;
        BufferedReader consola = null;
        String name;
        try {
            iptr = new InputStreamReader(System.in);
            consola = new BufferedReader(iptr);
            System.out.println("Dame el nombre de la poblacio que deseas borrar: ");
            name = consola.readLine();
            for (int pos = 0; pos < e1.getTAM(); pos++) {
                if (e1.getexperimento(pos) != null) {
                    if (e1.getexperimento(pos).getnombre().equalsIgnoreCase(name)) {
                        e1.setexperimento(pos,null);
                    }
                }
            }
            System.out.println("Poblacion borrada con exito");
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
    }

    /*This method shows the information of the population of the experiment*/
    static void verinfo(Experimento e1, Fecha f1) {
        InputStreamReader iptr = null;
        BufferedReader consola = null;
        String name;
        try {
            iptr = new InputStreamReader(System.in);
            consola = new BufferedReader(iptr);
            System.out.println("Dime el nombre de la poblacion que desea buscar: ");
            name = consola.readLine();
            for (int pos = 0; pos < e1.getTAM(); pos++) {
                if (e1.getexperimento(pos) != null) {
                    if (e1.getexperimento(pos).getnombre().equalsIgnoreCase(name)) {
                        System.out.println(e1.toString(pos) + "\n");
                            e1.getexperimento(pos).getcomidas().DarFecha(f1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
    }
    
    /*This method saves the experiment in the existing experiment,adding the new populations*/
    static void save(Experimento e1,Fecha f1){
        File fich=new File("c:/a/experimento.txt");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw=new FileWriter(fich.getAbsoluteFile(),true);
            bw=new BufferedWriter(fw);
            for(int pos=0;pos<e1.getTAM();pos++){
                if(e1.getexperimento(pos)!=null){
                    bw.write(e1.toString(pos));
                    for (int pos1 = 0; pos1 < 30; pos1++) {
                        bw.newLine();
                       // bw.write(e1.getexperimento(pos).getcomidas().tostring(pos1, f1));
                    }
                }
            }
            System.out.println("Guardado con exito");
        }catch(IOException ex){
            System.out.println("Hubo un error");
        }finally {
        try {
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }      
    
    
    /*This method saves the experiment and writes it down on a file*/
    static void saveas(Experimento e1, Fecha f1) {
        File fich = new File("c:/a/experimento.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fich);
            for (int pos = 0; pos < e1.getTAM(); pos++) {
                if (e1.getexperimento(pos) != null) {
                    pw.println(e1.toString(pos));
                        //pw.println(e1.getexperimento(pos).getcomidas().DarFecha(f1));
                }
            }
            System.out.println("----Archivo guardado con exito----");
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }finally{
            if (pw != null) {
                pw.close();
            }
        }
    }
}
