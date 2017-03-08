/*
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501 DUOC
 *  
 */
package cl.duoc.ded.impl.lista.nodos;

/**
 *
 * @author Osvaldo Rodr&iacute;guez
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @param <T> Tipo de dato del elemento a registrar en el nodo.
 */
public class NodoEnlaceSimple<T> {
    
    private T elemento;
    private NodoEnlaceSimple siguiente;

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoEnlaceSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEnlaceSimple siguiente) {
        this.siguiente = siguiente;
    }
  
}
