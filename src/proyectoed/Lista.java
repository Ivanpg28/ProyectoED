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
        while(actual!=null){
            System.out.println("\nClave: "+actual.getClave());
            actual.getRaiz().recorrer(actual.getRaiz());
            actual = actual.getSiguiente();
        }
    }
    
    public NodoLista buscar(String clave){
        NodoLista actual;
        for(actual = inicio ; actual != null && !actual.getClave().equals(clave);actual=actual.getSiguiente());
        return actual;
    }

    public void insertar(NodoLista nodo) {
        if(inicio == null) {
            inicio = nodo;
            fin = inicio;
        }
        else {
            NodoLista actual = inicio;
            while(actual != null) {
                if(actual == fin) {
                    fin.setSiguiente(nodo);
                    fin = nodo;
                    return;
                }
                else if(actual.getSiguiente().getClave().compareTo(nodo.getClave()) > 0) {
                    nodo.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(nodo);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }
    }
    
    public void eliminar(String clave){
        //Se podrian aniadir las excepciones lista vacia o un solo elto. en lista
        boolean salir = false;
        NodoLista actual = buscar(clave);
        if (actual != null){
            
            //COntemplar los diferentes casos de eliminacion de lista
            //Si es el ultimo elemento
            if ((actual.getSiguiente())==null){
                //Recorrer lista hasta encontrar el elto. que apunte a actual
                NodoLista actual2 = inicio;
                while (!salir){
                    if (actual2.getSiguiente()==actual){
                        actual2.setSiguiente(null);
                        fin = actual2;
                        salir=true;
                    }else{
                        actual2=actual2.getSiguiente();
                    }
                }
            }else {
                if (inicio==actual) { //Es el primer nodo de la lista
                    inicio=actual.getSiguiente();
                }else{//actual se encuentra en el medio
                    //Recorrrer la lista hasta encontrar el elto. que aputnte a 
                    //actual, y hacer que su puntero apunte a actual.Siguiente
                    //Eliminando de esa forma acttual y dejando la lista enlzada
                    NodoLista actual2 = inicio;
                    while (!salir){
                        if (actual2.getSiguiente()==actual){
                            actual2.setSiguiente(actual.getSiguiente());
                            salir=true;
                        }else{
                            actual2=actual2.getSiguiente();
                        }
                    }
                }
            }
            
        } else { 
            System.out.println("No se ha encontrado ese arbol");    
        }                
    }
}