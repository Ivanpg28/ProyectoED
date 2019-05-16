/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoed;

/**
 *
 * @author iperez10954
 */
public class Lista {
    private NodoLista inicio;
    private NodoLista fin;
    
    public Lista(){
        inicio=null;
        fin=null;
    }

    public Lista(NodoLista inicio, NodoLista fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public NodoLista getInicio() {
        return inicio;
    }

    public void setInicio(NodoLista inicio) {
        this.inicio = inicio;
    }

    public NodoLista getFin() {
        return fin;
    }

    public void setFin(NodoLista fin) {
        this.fin = fin;
    }
    
    /*public void recorrer(){
        NodoLista actual = inicio;
        while(actual.getSiguiente()!=null){
            System.out.println("clave: "+actual.getClave()+"\n");
            System.out.println("Arbol:\n");
            actual.getRaiz().recorrer();
            actual = actual.getSiguiente();
        }
    }*/
    
    public NodoLista buscar(String clave){
        NodoLista actual;
        for(actual = inicio ; actual != null && !actual.getClave().equals(clave);actual=actual.getSiguiente());
        return actual;
    }

    public void insertar(NodoLista nodo) {
        if(inicio == null) {
            inicio = nodo;
            fin = inicio;
        }
        else {
            NodoLista actual = inicio;
            while(actual != null) {
                if(actual == fin) {
                    fin.setSiguiente(nodo);
                    fin = nodo;
                    return;
                }
                else if(actual.getSiguiente().getClave().compareTo(nodo.getClave()) > 0) {
                    nodo.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(nodo);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }
    }
}