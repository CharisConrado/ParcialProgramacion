package com.mycompany.parcial2.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminFichero {
    private File file;
    private FileWriter fw;
    private PrintWriter pw;
    private FileReader fr;
    private BufferedReader buffer;

    public AdminFichero(String fileName,boolean bool) throws IOException {
        this.file = new File(fileName);
        this.fw = new FileWriter(file,bool);
        this.pw = new PrintWriter(fw);
        this.fr = new FileReader(file);
        this.buffer = new BufferedReader(fr);
    }
   
    public void CrearArchivo() throws IOException{
        if(file.createNewFile()){
            System.out.println("Archivo Creado.");
        }else{
            System.out.println("Archivo ya existente.");
        }
    }
   
    public BufferedReader getBufferedReader() {
        return buffer;
    }

    public PrintWriter getPrintWriter() {
        return pw;
    }

    public void close() throws IOException {
        if (fw != null) {
            fw.close();
        }
        if (fr != null) {
            fr.close();
        }
    }
}
