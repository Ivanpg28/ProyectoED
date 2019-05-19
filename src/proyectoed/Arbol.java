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
    
    private NodoArbol encontrarMin(NodoArbol raiz){
        if (raiz != null)
            while(raiz.getHojaIzquierda() != null)
                raiz= raiz.getHojaIzquierda();
        return raiz;
    }
    //Necesitamos este metodo removeMin, que sera llamado desde remove
    private NodoArbol eliminarMin(NodoArbol raiz) throws NotFoundException {
        if (raiz == null){
            throw new NotFoundException();
        }
        else {
            if (raiz.getHojaIzquierda() != null){
                raiz.setHojaIzquierda(eliminarMin(raiz.getHojaIzquierda()));
                return raiz;
                }
            else {
                return raiz.getHojaDerecha();
            }
        }
    }
    
    private NodoArbol eliminarNodo (String clave, NodoArbol raiz) throws NotFoundException{    
        if(raiz == null){
           throw new NotFoundException();
        }
        if(clave.compareTo(raiz.getDato().getClave()) < 0) {
            raiz.setHojaIzquierda(eliminarNodo(clave, raiz.getHojaIzquierda()));

        }
        else if(clave.compareTo(raiz.getDato().getClave()) > 0){
            raiz.setHojaDerecha(eliminarNodo(clave, raiz.getHojaDerecha()));
        }
        else if(raiz.getHojaIzquierda() != null && raiz.getHojaDerecha() != null){ //Dos hijos
            raiz.setDato(encontrarMin(raiz.getHojaDerecha()).getDato());
            raiz.setHojaDerecha(eliminarMin(raiz.getHojaDerecha()));
        }
        else
            raiz= (raiz.getHojaIzquierda() != null) ? raiz.getHojaIzquierda()
                    : raiz.getHojaDerecha();     
        return raiz;
    }
    
    public void eliminarNodo(String clave){
        try{
            raiz = eliminarNodo(clave, raiz);
        }catch(NotFoundException nfe){System.out.println(nfe.toString());}
    }
   
    //Recibe la clave del arbol que se va a recorrer
    public void recorrer() {
    //Funcion que recorre un arbol en preord llamando a recorrer de nodoArbol... 
    //...para recorrer los nodos 
    }
    
}
