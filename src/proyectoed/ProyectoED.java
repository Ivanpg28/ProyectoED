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
import java.util.InputMismatchException;


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
        System.out.println("   Arboles Cargados en el Programa:");
        lista.recorrer();
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("\n    - - - MENU - - -");
            System.out.println("1. Insertar nuevo arbol");
            System.out.println("2. Eliminar un arbol");
            System.out.println("3. Elimina un nodo de un arbol");
            System.out.println("4. Inserta un nodo en un arbol");
            System.out.println("5. Mostrar un arbol");
            System.out.println("6. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("  1. INSERTAR NUEVO ARBOL");
                        System.out.println("Nombre del fichero (directorio del programa)(sin .txt):");
                        Scanner sn3 = new Scanner(System.in);
                        String filetxt = sn3.nextLine();
                        File fichero = new File(filetxt+".txt");
                        if (fichero.exists()){
                            reinfile(fichero, lista);
                        }else{
                            System.out.println("El fichero no existe");
                        }  
                        break;
                    case 2:
                        System.out.println("  2. ELIMINAR UN ARBOL");
                        break;
                    case 3:
                        System.out.println("  3. ELIMINAR UN NODO DE UN ARBOL");
                        break;
                    case 4:
                        System.out.println("  4. INSERTAR UN NODO EN UN ARBOL");
                        break;
                    case 5:
                        System.out.println("  5. MOSTAR UN ARBOL");
                        System.out.println("Clave del Arbol:");
                        //Se pide la clave del arbol y se muestra en preorden
                        Scanner sn2 = new Scanner(System.in);
                        String clave = sn2.nextLine();
                        NodoLista actual = lista.buscar(clave);
                        actual.getRaiz().recorrer(actual.getRaiz());
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    
    public static Lista crearListaArboles(String directorio) {
        Lista lista = new Lista();
        File folder = new File(directorio);
        File[] listOfFiles = folder.listFiles();


        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                reinfile(file,lista);
            }
        }
        return lista;
    }
    
    public static void reinfile(File file, Lista lista){
        String line;
        DatoArbol datoarbol;
        Arbol arbol;
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