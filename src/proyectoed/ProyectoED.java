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
        int opcion = 0; //Guardaremos la opcion del usuario
        String clave;
 
        while (opcion != 6) {
 
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
                sn.nextLine();
                
                switch (opcion) {
                    case 1:
                        System.out.println("  1. INSERTAR NUEVO ARBOL");
                        System.out.println("Nombre del fichero (directorio del programa)(sin .txt):");
                        String filetxt = sn.nextLine();
                        File fichero = new File(filetxt+".txt");
                        if (fichero.exists()){
                            reinfile(fichero, lista);
                        }else{
                            System.out.println("El fichero no existe");
                        }  
                        break;
                    case 2:
                        System.out.println("  2. ELIMINAR UN ARBOL");                        
                        System.out.println("Nombre del Arbol a eliminar:");
                        clave = sn.nextLine();
                        lista.eliminar(clave);
                        break;
                    case 3:
                        System.out.println("  3. ELIMINAR UN NODO DE UN ARBOL");
                        System.out.println("¿De qué árbol se desea eliminar?");
                        clave = sn.nextLine();
                        System.out.println("Clave del nodo a eliminar:");
                        lista.buscar(clave).getRaiz().eliminarNodo(sn.nextLine());
                        break;
                    case 4:
                        System.out.println("  4. INSERTAR UN NODO EN UN ARBOL");
                        System.out.println("¿En qué árbol desea insertar nodo?");
                        String arbol = sn.nextLine();
                        System.out.println("Posición del nodo a insertar:");
                        //Comprobar que el numero dado no esta en uso en el arbol
                        int posicion = sn.nextInt();
                        sn.nextLine();
                        System.out.println("Clave del nodo a insertar:");
                        clave = sn.nextLine();
                        try{
                            lista.buscar(arbol).getRaiz().addNodo(new NodoArbol(new DatoArbol(clave, posicion)));
                        }catch(NullPointerException ex) {
                            System.out.println("No se ha encontrado el árbol");
                        }
                        break;
                    case 5:
                        System.out.println("  5. MOSTRAR UN ARBOL");
                        System.out.println("Clave del Arbol:");
                        //Se pide la clave del arbol y se muestra en preorden
                        clave = sn.nextLine();
                        NodoLista actual = lista.buscar(clave);
                        try{
                            actual.getRaiz().recorrer(actual.getRaiz());
                        }catch(NullPointerException ex) {
                            System.out.println("No se ha encontrado el árbol");
                        }
                        break;
                    case 6:
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
                    arbol.addNodo(new NodoArbol(datoarbol));
                }
                fileIn.close();
            }
            lista.insertar(new NodoLista(file.getName().substring(0, file.getName().length()-4), arbol));

        }catch(IOException ex){
            System.out.println("Error en la apertura del fichero"+
                    ex.getMessage());
        }
    }
}