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
    
    private void recorrer() {
        
    }
}
