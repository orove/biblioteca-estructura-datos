/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.lista;

import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.ArgumentoInvalidoException;
import cl.duoc.ded.exception.ElementoNuloException;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.impl.lista.nodos.NodoEnlaceSimple;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementaci&oacute;n de {@link cl.duoc.ded.api.Lista} utilizando  
 * nodos doblemente enlazados.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @param <T> tipo de dato del elemento a manipular en la lista.
 * @see cl.duoc.ded.api.Lista
 */
public class ListaEnlazadaSimpleImpl<T> implements Lista<T> {
    private Integer cantidadElementos = 0;
    private NodoEnlaceSimple<T> primerNodo;
    private NodoEnlaceSimple<T> ultimoNodo; 
    
    
    @Override
    public boolean isVacia() {
        return this.cantidadElementos == 0;
    }
    
    
    @Override
    public boolean isLlena() {
        return false;
    }
    

    @Override
    public int getTotalElementos() {
        return this.cantidadElementos;
    }

    
    @Override
    public void agregarElemento(T elemento) {
        
        if(elemento == null) {
            throw new ElementoNuloException("la lista no permite agregar elementos nulos");
        }
        
        if(this.cantidadElementos == 0) {
            this.primerNodo = new NodoEnlaceSimple();
            this.primerNodo.setElemento(elemento);
            this.ultimoNodo = this.primerNodo;
        } else {
            NodoEnlaceSimple<T> nuevoNodo = new NodoEnlaceSimple();
            nuevoNodo.setElemento(elemento);
            this.ultimoNodo.setSiguiente(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        } 
        
        this.cantidadElementos++;
    }

    
    @Override
    public void insertarElemento(T elemento) {
        
        if(elemento == null) {
            throw new ElementoNuloException("la lista no permite agregar elementos nulos");
        }
        
        if(this.cantidadElementos == 0) {
            this.primerNodo = new NodoEnlaceSimple();
            this.primerNodo.setElemento(elemento);
            this.ultimoNodo = this.primerNodo;
        } else {
            NodoEnlaceSimple<T> nuevoNodo = new NodoEnlaceSimple();
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setSiguiente(this.primerNodo);
            this.primerNodo = nuevoNodo;
        }
        
        this.cantidadElementos++;
    }

    
    @Override
    public T eliminarElemento(T elemento) {                
        NodoEnlaceSimple<T> nodoAnterior = null;
        NodoEnlaceSimple<T> nodo;
        T eliminado = null;
        
        for(nodo = this.primerNodo; nodo!=null; nodo = nodo.getSiguiente()) {
            
            if(nodo.getElemento().equals(elemento)) {
                
                if(nodoAnterior == null) {                    
                    this.primerNodo = nodo.getSiguiente();
                } else {
                    nodoAnterior.setSiguiente(nodo.getSiguiente());
                    
                    if(nodo.getSiguiente() == null) {
                        this.ultimoNodo = nodoAnterior;
                    }
                }
                
                eliminado = nodo.getElemento();
                
                nodo.setElemento(null);
                nodo.setSiguiente(null);
                
                this.cantidadElementos--;
                
                break;
            }
            
            nodoAnterior = nodo;
        }
        
        return eliminado;
    }

    
    @Override
    public T eliminar(int posicion) {        
        NodoEnlaceSimple<T> nodo = this.primerNodo;  
        NodoEnlaceSimple<T> nodoAnterior = null;
        T eliminado = null;
        int i;
        
        if(posicion < 0 || posicion >= this.cantidadElementos) {
            throw new ArgumentoInvalidoException("la lista no tiene elementos en la posición "+posicion);
        }
        
        
        for(i=0; i< posicion; i++) {   
            nodoAnterior = nodo;
            nodo = nodo.getSiguiente();
        }
        
        if(nodo != null) {                            
            if(i == 0) {                    
                this.primerNodo = nodo.getSiguiente();                
            } else if(nodoAnterior!=null){
                nodoAnterior.setSiguiente(nodo.getSiguiente());
                
                if(nodo.getSiguiente() == null) {
                    this.ultimoNodo = nodoAnterior;
                }
            }

            eliminado = nodo.getElemento();
            
            nodo.setElemento(null);
            nodo.setSiguiente(null);
            
            this.cantidadElementos--;
        }
        
        return eliminado;
    }

    
    @Override
    public void vaciar() {
        NodoEnlaceSimple<T> nodo = this.primerNodo;
                
        while(nodo!=null) {
            NodoEnlaceSimple<T> nodoAux = nodo.getSiguiente();
            nodo.setElemento(null);
            nodo.setSiguiente(null);
            nodo = nodoAux;
        }
        
        this.cantidadElementos = 0;
    }

    @Override
    public boolean existe(T elemento) {        
        NodoEnlaceSimple<T> nodo = this.primerNodo;
        boolean existe = false;
                
        while(nodo!=null) {
            if(nodo.getElemento().equals(elemento)) {
                existe = true;
                break;
            }
            
            nodo = nodo.getSiguiente();
        }
        
        return existe;
    }

    @Override
    public T getPrimerElemento() {
        T elemento = null;
        
        if(this.primerNodo != null) {
            elemento = this.primerNodo.getElemento();
        }
        
        return elemento;
    }

    @Override
    public T getUltimoElemento() {
        T elemento = null;
        
        if(this.ultimoNodo != null) {
            elemento = this.ultimoNodo.getElemento();
        }
        
        return elemento;
    }

    @Override
    public T getElemento(int posicion) {        
        NodoEnlaceSimple<T> nodo = this.primerNodo;        
        T buscado = null;
        int i;        
        
        if(posicion < 0 || posicion >= this.cantidadElementos) {
            throw new ArgumentoInvalidoException("la lista no tiene elementos en la posición "+posicion);
        }
        
        for(i=0; i< posicion; i++) {            
            nodo = nodo.getSiguiente();
        }

        if(nodo != null) {
            buscado = nodo.getElemento();
        }

        return buscado;
    }

    @Override
    public void visualizar(Visualizable<Lista> visor) throws VisorException {
        visor.ver(this);
    }
 
    @Override
    public Iterator<T> iterator() {
        return new ListaEnlazadaSimpleIterator<>(this);
    }
    
    
    private class ListaEnlazadaSimpleIterator<T> implements Iterator<T> {
        private NodoEnlaceSimple<T> nodoActual = null;
        private final ListaEnlazadaSimpleImpl<T> lista;
        
        public ListaEnlazadaSimpleIterator(ListaEnlazadaSimpleImpl<T> lista) {
            this.lista = lista;
            this.nodoActual = this.lista.primerNodo;
        }
        
        @Override
        public boolean hasNext() {
            return this.nodoActual != null;
        }

        @Override
        public T next() {
            
            if(!this.hasNext()) {
                throw new NoSuchElementException("no hay más elementos");
            }
            
            T elemento = this.nodoActual.getElemento();
            this.nodoActual = this.nodoActual.getSiguiente();
           
            return elemento;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    
    }
 
}
