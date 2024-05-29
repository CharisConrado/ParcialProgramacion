package com.mycompany.parcial2;

public class Parcial2 {

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import parcial.santiagoguevara192203.clases.AdminFichero;


public class SantiagoGuevara192203 {

    public static void main(String[] args) throws IOException {
        AdminFichero af = new AdminFichero("./apartamentos.txt",true);
        af.CrearArchivo();
        AdminFichero pagos = new AdminFichero("./pagos.txt",false);
        pagos.CrearArchivo();
       
        AdminFichero paz = new AdminFichero("./enpazysalvo.txt",false);
        paz.CrearArchivo();
        AdminFichero deuda = new AdminFichero("./deudores.txt",false);
        deuda.CrearArchivo();
       
        Scanner scn = new Scanner(System.in);
       
        System.out.println("Agregar a nuevo inquilino? (1)Si (2)No");
        int quest = scn.nextInt();
        if(quest==1){
           
            System.out.println("Ingrese el nombre del inquilino:");
            String name = scn.next();
            System.out.println("¿En cuàl apartamento està? (apt1,apt2...)");
            String apt = scn.next();
            System.out.println("Agregue las caracterìsticas del apartamento:");
            String caract = scn.next();
            String linea = name + ";" + apt + ";" + caract;
            af.getPrintWriter().println(linea);
            System.out.println("Inquilino nuevo agregado");
        }else{
            System.out.println("Inquilino nuevo no agregado.");
        }
        System.out.println("");
       
       
        System.out.println("Agregar pagos? (1)Si (2)No");
        quest = scn.nextInt();
        if(quest==1){
            String Line2 = "";
            while(Line2 != null){
                Line2 = af.getBufferedReader().readLine();
                if(Line2!=null){
                    System.out.println("El siguiente inquilino pagó? SiPago NoPago:");
                    System.out.println(Line2);
                    String men = scn.next();
                    pagos.getPrintWriter().println(Line2+";"+men);
                }
            }
        }
        pagos.close();
        AdminFichero pagos2 = new AdminFichero("./pagos.txt",true);
        System.out.println("");
        System.out.println("¿Desea conocer el informe de final de mes? (1)Si (2)No");
        quest = scn.nextInt();
        if(quest == 1){
            String Line = "";
            while(Line!= null){
                Line = pagos2.getBufferedReader().readLine();

                if(Line!= null){
                    try{
                        String[] split = Line.split(";");
                       
                        if(split[3].equals("NoPago")){
                            int a = 10/0;
                        }else{
                            paz.getPrintWriter().println(Line);
                            System.out.println("Si pago");
                        }
                    }catch(Exception e){
                        deuda.getPrintWriter().println(Line);
                        System.out.println("Se han encontrado personas sin pagar");
                    }
                }else{
                    System.out.println("Informe generado como archivos de texto");
                    break;
                }
           
        }
        }
        pagos2.close();
        af.close();
        paz.close();
        deuda.close();
       
    }
}
}
