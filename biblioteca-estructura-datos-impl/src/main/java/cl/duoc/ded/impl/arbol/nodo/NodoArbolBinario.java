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

import java.util.Comparator;

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
    private int factorE;    
    private NodoArbolBinario<T> raiz;
    
   
    
    
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
    
    /**
		 * Obtiene el factor de equilibrio del nodo.
		 * @return factor de equilibrio del nodo.
		 */
		public int getFactorE(){
			int altDer = 0;
			int altIzq = 0;
			if(this.getRamaDerecha()!=null){
		    	altDer = this.getRamaDerecha().getAltura();
		   	}
		   	if(this.getRamaIzquierda()!=null){		    
		   		altIzq = this.getRamaIzquierda().getAltura();
		   	}
			return (altDer - altIzq);
		}
		
		/**
		 * Asigna un valor al factor de equilibrio.
		 * @param fe factor de equilibro para asignar al nodo.
		 */
		public void setFactorE(int fe){
			this.factorE = fe;
		}
		
		/**
		 * Devuelve la altura del nodo.
		 * @return altura del nodo.
		 */	
		public int getAltura(){
			int hIzq = 0;
			int hDer = 0;
			
			if(this.getElemento()==null){
			  return 0;
	    	}
	
	
			if(this.getRamaIzquierda()!=null){	
				hIzq = this.getRamaIzquierda().getAltura();
			}else{
				hIzq = 0;
			}
	    	
	    	if(this.getRamaDerecha()!=null){   
	    		hDer = this.getRamaDerecha().getAltura();
	    	}else{
	    		hDer = 0;
	    	}
	    	return Math.max(hIzq, hDer) + 1;
		}
}


