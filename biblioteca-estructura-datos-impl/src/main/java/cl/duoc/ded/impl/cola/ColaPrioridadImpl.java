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
import cl.duoc.ded.api.ColaPrioridad;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.impl.lista.ListaArregloImpl;
import cl.duoc.ded.impl.lista.ListaEnlazadaDobleImpl;


/**
 * Implementaci&oacute;n de la estructura de dato abstracta de Cola de Prioridad utilizando listas.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> tipo de dato del elemento a almacenar en la cola
 */
public class ColaPrioridadImpl<T> implements ColaPrioridad<T> {

    private final Lista<T> listaElementos;
    private final Lista<Prioridad> listaPrioridades;
    
    /**
     * Constructor para crear una Cola de tama&ntilde;o din&aacute;mico utilizando
     * una lista doblemente enlazada.
     */
    public ColaPrioridadImpl() {
        this.listaElementos = new ListaEnlazadaDobleImpl();  
        this.listaPrioridades = new ListaEnlazadaDobleImpl();
    }
    
    /**
     * Constructor para crear una Cola de tama&ntilde;o fijo utilizando
     * una lista est&aacute;tica.
     * 
     * @param cantidadMaximaElementos 
     */
    public ColaPrioridadImpl(int cantidadMaximaElementos) {
        this.listaElementos = new ListaArregloImpl(cantidadMaximaElementos);
        this.listaPrioridades = new ListaArregloImpl(cantidadMaximaElementos);
    }

    @Override
    public void encolar(T elemento) {        
        this.listaElementos.agregarElemento(elemento);
        this.listaPrioridades.agregarElemento(Prioridad.NORMAL);
    }

    @Override
    public T desencolar() {
        
        int i = buscarPosicionProximoElementoAtender();
        
        if(i >=0 ) {
            this.listaPrioridades.eliminar(i);
            return this.listaElementos.eliminar(i);
        }
        
        return null;
    }

    @Override
    public boolean isVacia() {
        return this.listaElementos.isVacia();
    }

    @Override
    public boolean isLlena() {
        return this.listaElementos.isLlena();
    }

    @Override
    public T verProximo() {
        if(this.listaElementos.getTotalElementos() > 0) {
            int i = buscarPosicionProximoElementoAtender();
        
            if(i >=0 ) {
                return this.listaElementos.getElemento(i);
            }
        }
            
        return null;                  
    }    

    @Override
    public void visualizar(Visualizable<Cola> visor) throws VisorException {
        visor.ver(this);
    }

    @Override
    public void encolar(T elemento, Prioridad prioridad) {
        this.listaElementos.agregarElemento(elemento);
        this.listaPrioridades.agregarElemento(prioridad);
    }
 
    
    private int buscarPosicionProximoElementoAtender() {
        
        if( this.listaPrioridades.getTotalElementos() == 0 ) {
            return -1;
        }
        
        for(int i=0; i<this.listaPrioridades.getTotalElementos(); i++) {
            Prioridad p = (Prioridad)this.listaPrioridades.getElemento(i);
            
            if(Prioridad.ALTA.equals(p)) {
                return i;
            }
        }
        
        for(int i=0; i<this.listaPrioridades.getTotalElementos(); i++) {
            Prioridad p = (Prioridad)this.listaPrioridades.getElemento(i);
            
            if(Prioridad.NORMAL.equals(p)) {
                return i;
            }
        }                
        
        return 0;
    }
}
