package proyectoed;

/**
 *
 * @author iperez10954
 */
public class DatoArbol {
    private String clave;
    private int posicion;

    public DatoArbol() {
        this.clave = null;
        this.posicion = 0;
    }
    

    public DatoArbol(String clave, int posicion) {
        this.clave = clave;
        this.posicion = posicion;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return clave + "    " + posicion;
    }
    
}
