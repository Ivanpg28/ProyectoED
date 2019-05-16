/* To change this license header, choose License Headers in Project Properties.
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
    
    public void addNodo(NodoArbol raiz) {
        if(this.raiz == null) {
            this.raiz = raiz;
        }
        else {
            NodoArbol nodo = this.raiz;
            while (nodo != null) {
                if (raiz.getDato().getClave().compareTo(nodo.getDato().getClave()) < 0) {
                    if(nodo.getHojaIzquierda() == null) {
                        nodo.setHojaIzquierda(raiz);
                        break;
                    }
                    else {
                        nodo = nodo.getHojaIzquierda();
                    }
                }
                else if ((raiz.getDato().getClave().compareTo(nodo.getDato().getClave()) > 0)) {
                    if(nodo.getHojaDerecha() == null) {
                        nodo.setHojaDerecha(raiz);
                        break;
                    }
                    else {
                        nodo = nodo.getHojaIzquierda();
                    }
                }
                else {
                    System.out.println(nodo.getDato().getClave());
                    break;
                }
            }
        }
    }
    
    public NodoArbol eliminarNodo(NodoArbol raiz) {
        return raiz;
    }
   
    //Recibe la clave del arbol que se va a recorrer
    public static void recorrer(String clave) {
    //Funcion que recorre un arbol en preord llamando a recorrer de nodoArbol... 
    //...para recorrer los nodos 
    }
    
}
