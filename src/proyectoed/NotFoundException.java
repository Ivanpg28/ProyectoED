/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoed;

/**
 *
 * @author ivanp
 */
class NotFoundException extends Exception {    
    public NotFoundException(){
        
    }
    public NotFoundException(String msg){
        super(msg+" No se ha encontrado el nodo.");
    }
    
}
