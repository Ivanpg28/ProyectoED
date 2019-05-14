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
    
    public void recorrer(){
        NodoLista actual = inicio;
        while(actual.getNodo()!=null){
            System.out.println("clave"+actual.getClave()+"\n");
            System.out.println("Arbol:\n");
            actual.getRaiz().recorrer();
            actual = actual.getNodo();
        }
    }
    
    public NodoLista buscar(String clave){
        NodoLista actual;
        for(actual = inicio ; actual != null && !actual.getClave().equals(clave);actual=actual.getNodo());
        return actual;
    }

    void insertar(NodoLista nodo) {
        if(inicio == null) {
            inicio = nodo;
        }
        if(fin != null) {
            fin.setNodo(nodo);
        }
        fin = nodo;
    }
    
}  