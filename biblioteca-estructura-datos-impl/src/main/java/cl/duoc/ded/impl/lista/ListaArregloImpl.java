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
import cl.duoc.ded.exception.CapacidadExcedidaException;
import cl.duoc.ded.exception.ElementoNuloException;
import cl.duoc.ded.exception.VisorException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementaci&oacute;n de {@link cl.duoc.ded.api.Lista} que 
 * utiliza un arreglo de tama&ntilde;o fijo.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @param <T> tipo de dato del elemento a guardar en la lista
 * @see cl.duoc.ded.api.Lista
 */
public class ListaArregloImpl<T> implements Lista<T> {
    
    // atributo privado con el arreglo de elementos
    private Object[] arreglo;
    private int cantidadElementosIngresados = 0;
    
    /**
     * Constructor para crear una lista de tama&ntilde;o est&aacute;tico.
     * @param cantidadElementos n&uacute;mero m&aacute;ximo de elementos que puede almacenar la lista.
     * @throws ArgumentoInvalidoException si el valor del par&aacute;metro <b>cantidadElementos</b> es
     * negativo &oacute; igual a cero.
     */
    public ListaArregloImpl(int cantidadElementos) {
        // genera el arreglo con la capacidad indicada y
        // trunca o rellena con nulos todo su contenido
        
        if(cantidadElementos < 1) {
            throw new ArgumentoInvalidoException("imposible crear lista con "+cantidadElementos+" elementos, el número debe ser un valor positivo mayor que cero.");
        }
        
        this.arreglo = new Object[cantidadElementos];
    }
    
    @Override
    public boolean isVacia() {
        return (this.cantidadElementosIngresados == 0);
    }
       
    @Override
    public boolean isLlena() {
        return (this.cantidadElementosIngresados == this.arreglo.length);
    }

    @Override
    public int getTotalElementos() {
        return this.cantidadElementosIngresados;
    }

    @Override
    public void agregarElemento(T elemento) {
        
        if(elemento == null) {
            throw new ElementoNuloException("la lista no soporta agregar elementos nulos");
        }
        
        if(this.cantidadElementosIngresados +1 > this.arreglo.length) {
            throw new CapacidadExcedidaException("la lista ha excedido el límite de su capacidad");
        }
        
        this.arreglo[this.cantidadElementosIngresados++] = elemento;
        
    }

    @Override
    public void insertarElemento(T registro) {
        
        if(registro == null) {
            throw new ElementoNuloException("la lista no soporta insertar elementos nulos");
        }
        
        if(this.cantidadElementosIngresados +1 > this.arreglo.length) {
            throw new CapacidadExcedidaException("la lista ha excedido el límite de su capacidad");
        }
        
        for(int i = this.cantidadElementosIngresados+1; i>1; i--) {
            this.arreglo[i-1] = this.arreglo[i-2];
        }
        
        this.arreglo[0] = registro;
        cantidadElementosIngresados++;
        
    }

    @Override
    public T eliminarElemento(T registro) {
        int posicion = -1;
        T eliminado = null;
        
        for(int i=0; i<this.cantidadElementosIngresados; i++ ){
            if(this.arreglo[i].equals(registro)) {
                posicion = i;
                break;
            }
        }
        
        if(posicion != -1) {
            eliminado = (T)this.arreglo[posicion];
            
            for(int i=posicion; i<this.cantidadElementosIngresados; i++) {
                if(i+1 == this.cantidadElementosIngresados) {
                    this.arreglo[i] = null;
                } else {
                    this.arreglo[i] = this.arreglo[i+1];
                }
            }
            
            this.cantidadElementosIngresados--;
        }
        
        return eliminado;
    }

    @Override
    public T eliminar(int posicion) {
        T eliminado;
        
        if(posicion <0 || posicion >= this.cantidadElementosIngresados) {
            throw new ArgumentoInvalidoException("el valor para la posición ("+posicion+") del elemento a eliminar no es válida");
        }
        
        eliminado = (T)this.arreglo[posicion];
            
        for(int i=posicion; i<this.cantidadElementosIngresados; i++) {
            if(i+1 == this.cantidadElementosIngresados) {
                this.arreglo[i] = null;
            } else {
                this.arreglo[i] = this.arreglo[i+1];
            }
        }

        this.cantidadElementosIngresados--;
        
        return eliminado;
    }


    @Override
    public void vaciar() {
        for(int i=0; i<this.arreglo.length; i++) {
            this.arreglo[i] = null;
        }
        
        this.cantidadElementosIngresados = 0;
    }

    @Override
    public boolean existe(T registro) {
        for(int i=0; i<this.cantidadElementosIngresados; i++) {
            if(this.arreglo[i].equals(registro)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public T getPrimerElemento() {
        if(this.cantidadElementosIngresados == 0) {
            return null;
        }
        
        return (T)this.arreglo[0];
    }

    @Override
    public T getUltimoElemento() {
        if(this.cantidadElementosIngresados == 0) {
            return null;
        }
        
        return (T)this.arreglo[this.cantidadElementosIngresados-1];
    }    

    @Override
    public T getElemento(int posicion) {
        if(posicion < 0 || this.cantidadElementosIngresados <= posicion) {
            throw new ArgumentoInvalidoException("la lista no tiene elementos en la posición "+posicion);
        }
        
        return (T)this.arreglo[posicion];
    }

    
    @Override
    public void visualizar(Visualizable<Lista> visor) throws VisorException {
        visor.ver(this);        
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaArregloIterator<>(this);
    }
    
    private class ListaArregloIterator<T> implements Iterator<T> {
        private int posicionActual = 0;
        private final ListaArregloImpl<T> lista;
        
        public ListaArregloIterator(ListaArregloImpl<T> lista) {
            this.lista = lista;
        }
        
        @Override
        public boolean hasNext() {
            return this.posicionActual < this.lista.cantidadElementosIngresados;
        }

        @Override
        public T next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException("no hay más elementos");
            }
            
            T elemento = (T)this.lista.arreglo[this.posicionActual++];
           
            return elemento;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    
    }
 
}
