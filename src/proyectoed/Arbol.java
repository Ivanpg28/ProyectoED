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
public class Arbol {
    private NodoArbol raiz;
    
    public NodoArbol addNodo(NodoArbol raiz) {
        if(this.raiz == null) {
            this.raiz = raiz;
        }
        else {
            if (raiz.getDato().getClave().compareTo(this.raiz.getDato().getClave()) > 0) {
                raiz.setHojaIzquierda(this.addNodo(raiz.getHojaIzquierda()));
            }
            else if ((raiz.getDato().getClave().compareTo(this.raiz.getDato().getClave()) < 0)) {
                raiz.setHojaDerecha(this.addNodo(raiz.getHojaDerecha()));
            }
            else {
                System.out.println("Item duplicado");
            }
        }
        return raiz;
    }
    
    public NodoArbol eliminarNodo(NodoArbol raiz) {
        return raiz;
    }
    
    public void recorrer() {
        
    }
    
}
