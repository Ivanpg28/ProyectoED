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
    private NodoLista nodo;

    public NodoLista() {
        clave = null;
        raiz = null;
        nodo = null;
    }

    public NodoLista(String clave, Arbol raiz, NodoLista nodo) {
        this.clave = clave;
        this.raiz = raiz;
        this.nodo = nodo;
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

    public NodoLista getNodo() {
        return nodo;
    }

    public void setNodo(NodoLista nodo) {
        this.nodo = nodo;
    }
    
    
}
