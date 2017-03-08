/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol.nodo;

/**
 * Clase con la estructura interna de un nodo para el árbol 
 * binario de búsqueda.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> tipo de dato de los elementos que manipular&aacute; el &aacute;rbol y
 *            que debe implementar la interfaz {@link java.lang.Comparable}.
 */
public class NodoArbolBinario<T extends Comparable> {

    private T elemento;
    private NodoArbolBinario<T> ramaIzquierda;
    private NodoArbolBinario<T> ramaDerecha;

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbolBinario<T> getRamaIzquierda() {
        return ramaIzquierda;
    }

    public void setRamaIzquierda(NodoArbolBinario<T> ramaIzquierda) {
        this.ramaIzquierda = ramaIzquierda;
    }

    public NodoArbolBinario<T> getRamaDerecha() {
        return ramaDerecha;
    }

    public void setRamaDerecha(NodoArbolBinario<T> ramaDerecha) {
        this.ramaDerecha = ramaDerecha;
    }
    
}

