/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoed;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author iperez10954
 */
public class ProyectoED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = crearListaArboles("./");
        lista.recorrer();
        
    }
    
    public static Lista crearListaArboles(String directorio) {
        Lista lista = new Lista();
        File folder = new File(directorio);
        File[] listOfFiles = folder.listFiles();
        String line;
        DatoArbol datoarbol;
        Arbol arbol;

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try{
                    try (Scanner fileIn = new Scanner(new FileReader(file))) {
                        arbol = new Arbol();
                        while(fileIn.hasNextLine()){
                            line = fileIn.nextLine();
                            String [] datos=line.split(" ");
                            datoarbol = new DatoArbol(datos[1], Integer.parseInt(datos[0]));
                            arbol.addNodo(new NodoArbol(datoarbol, null, null));
                        }
                        fileIn.close();
                    }
                    lista.insertar(new NodoLista(file.getName().substring(0, file.getName().length()-4), arbol, null));
                    
                }catch(IOException ex){
                    System.out.println("Error en la apertura del fichero"+
                            ex.getMessage());
                }
            }
        }
        return lista;
    }
    
}
