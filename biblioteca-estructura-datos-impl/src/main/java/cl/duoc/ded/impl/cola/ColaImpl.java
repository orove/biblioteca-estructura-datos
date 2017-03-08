/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.cola;


import cl.duoc.ded.api.Cola;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.impl.lista.ListaArregloImpl;
import cl.duoc.ded.impl.lista.ListaEnlazadaDobleImpl;


/**
 * Implementaci&oacute;n de la estructura de dato abstracta de Cola utilizando listas.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> tipo de dato del elemento a almacenar en la cola
 */
public class ColaImpl<T> implements Cola<T> {

    private final Lista<T> lista;    
    
    /**
     * Constructor para crear una Cola de tama&ntilde;o din&aacute;mico utilizando
     * una lista doblemente enlazada.
     */
    public ColaImpl() {
        this.lista = new ListaEnlazadaDobleImpl();        
    }
    
    /**
     * Constructor para crear una Cola de tama&ntilde;o fijo utilizando
     * una lista est&aacute;tica.
     * 
     * @param cantidadMaximaElementos 
     */
    public ColaImpl(int cantidadMaximaElementos) {
        this.lista = new ListaArregloImpl(cantidadMaximaElementos);
    }

    @Override
    public void encolar(T elemento) {
        this.lista.agregarElemento(elemento);
    }

    @Override
    public T desencolar() {
        return this.lista.eliminar(0);
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
    public T verProximo() {
        if(this.lista.getTotalElementos() > 0) {
            return this.lista.getElemento(0);
        } else {
            return null;
        }            
    }    

    @Override
    public void visualizar(Visualizable<Cola> visor) throws VisorException {
        visor.ver(this);
    }
 
    
}
