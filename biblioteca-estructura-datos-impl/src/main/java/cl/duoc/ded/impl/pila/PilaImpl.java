/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.pila;

import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.Pila;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.exception.ElementoNoExisteException;
import cl.duoc.ded.impl.lista.ListaArregloImpl;
import cl.duoc.ded.impl.lista.ListaEnlazadaDobleImpl;

/**
 * Implementaci&oacute;n de la estructura de dato abstracta de Pila utilizando listas.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> tipo de dato del elemento a almacenar en la pila
 */
public class PilaImpl<T> implements Pila<T> {
    
    private final Lista<T> lista;
  
    /**
     * Constructor para crear una pila de tama&ntilde;o din&aacute;mico utilizando
     * una lista doblemente enlazada.
     */
    public PilaImpl() {
        this.lista = new ListaEnlazadaDobleImpl();        
    }
    
    /**
     * Constructor para crear una pila de tama&ntilde;o fijo utilizando
     * una lista est&aacute;tica.
     * 
     * @param cantidadMaximaElementos 
     */
    public PilaImpl(int cantidadMaximaElementos) {
        this.lista = new ListaArregloImpl(cantidadMaximaElementos);
    }
    
    @Override
    public void push(T elemento) {             
        this.lista.agregarElemento(elemento);
    }

    @Override
    public T pop() {
        if(isVacia()) {
            throw new ElementoNoExisteException("la pila se encuentra vacía");
        }
        
        T elemento = this.lista.eliminar(this.lista.getTotalElementos() -1);        
        
        return elemento;
    }

    @Override
    public boolean isVacia() {
        return this.lista.isVacia();
    }

    @Override
    public boolean isLlena() {        
        return this.lista.isLlena();
    }

    @Override
    public T verTope() {
        return this.lista.getUltimoElemento();
    }

    @Override
    public void visualizar(Visualizable<Pila> visor) throws VisorException {
        visor.ver(this);
    }
    
}
