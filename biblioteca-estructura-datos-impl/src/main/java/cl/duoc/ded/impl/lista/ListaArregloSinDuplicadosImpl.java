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

import cl.duoc.ded.exception.ArgumentoInvalidoException;
import cl.duoc.ded.exception.ElementoDuplicadoException;

/**
 * Implementaci&oacute;n de {@link cl.duoc.ded.api.Lista} que 
 * utiliza un arreglo de tama&ntilde;o fijo.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @param <T> tipo de dato del elemento a guardar en la lista
 * @see cl.duoc.ded.api.Lista
 */
public class ListaArregloSinDuplicadosImpl<T> extends ListaArregloImpl<T> {
        
    /**
     * Constructor para crear una lista de tama&ntilde;o est&aacute;tico.
     * @param cantidadElementos n&uacute;mero m&aacute;ximo de elementos que puede almacenar la lista.
     * @throws ArgumentoInvalidoException si el valor del par&aacute;metro <b>cantidadElementos</b> es
     * negativo &oacute; igual a cero.
     */
    public ListaArregloSinDuplicadosImpl(int cantidadElementos) {        
        super(cantidadElementos);
    }
    
    @Override
    public void agregarElemento(T elemento) {
                
        if(this.existe(elemento)) {
            throw new ElementoDuplicadoException("la lista no permite agregar elementos duplicados");
        }
        
        super.agregarElemento(elemento);
    }

    
    @Override
    public void insertarElemento(T elemento) {
        
        if(this.existe(elemento)) {
            throw new ElementoDuplicadoException("la lista no permite insertar elementos duplicados");
        }
        
        super.insertarElemento(elemento);
    }
 
}
