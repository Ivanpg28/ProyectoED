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
public class NodoArbol {
    private DatoArbol dato;
    private NodoArbol hojaDerecha = null;
    private NodoArbol hojaIzquierda = null;

    public NodoArbol(DatoArbol dato) {
        this.dato = dato;
    }

    public NodoArbol(DatoArbol dato, NodoArbol hojaDerecha, NodoArbol hojaIzquierda) {
        this.dato = dato;
        this.hojaDerecha = hojaDerecha;
        this.hojaIzquierda = hojaIzquierda;
    }

    public DatoArbol getDato() {
        return dato;
    }

    public void setDato(DatoArbol dato) {
        this.dato = dato;
    }

    public NodoArbol getHojaDerecha() {
        return hojaDerecha;
    }

    public void setHojaDerecha(NodoArbol hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }

    public NodoArbol getHojaIzquierda() {
        return hojaIzquierda;
    }

    public void setHojaIzquierda(NodoArbol hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }
    
    //VISUALIZAR EN PREORDEN
    /*1º se trata el nodo actual
    * 2º se trata el hijo izquierdo del nodo actual
    * 3º se trata el hijo derecho del nodo actual
    * Es decir, 1º se procesa el nodo y luego recursivamente sus hijos
    */
    public void recorrer() {
        System.out.println(dato);    
        if(hojaIzquierda!=null){
            hojaIzquierda.recorrer();
        }
        if(hojaDerecha!=null){
            hojaDerecha.recorrer();
        }
    }
}