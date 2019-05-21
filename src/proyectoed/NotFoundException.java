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