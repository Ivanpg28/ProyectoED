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
public class NodoLista {
    private String clave;
    private Arbol raiz;
    private NodoLista siguiente;

    public NodoLista() {
        clave = null;
        raiz = null;
        siguiente = null;
    }

    public NodoLista(String clave, Arbol raiz, NodoLista siguiente) {
        this.clave = clave;
        this.raiz = raiz;
        this.siguiente = siguiente;
    }
    
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Arbol getRaiz() {
        return raiz;
    }

    public void setRaiz(Arbol raiz) {
        this.raiz = raiz;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
