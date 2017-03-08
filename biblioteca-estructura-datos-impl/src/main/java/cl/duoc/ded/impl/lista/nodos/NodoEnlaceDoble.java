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
public class NodoEnlaceDoble<T> {
    
    private T elemento;
    private NodoEnlaceDoble anterior;
    private NodoEnlaceDoble siguiente;

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoEnlaceDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEnlaceDoble anterior) {
        this.anterior = anterior;
    }

    public NodoEnlaceDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEnlaceDoble siguiente) {
        this.siguiente = siguiente;
    }
  
}
