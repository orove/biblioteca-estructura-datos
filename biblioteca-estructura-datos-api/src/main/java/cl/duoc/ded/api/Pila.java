/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.api;

import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.ElementoDuplicadoException;
import cl.duoc.ded.exception.ElementoNoExisteException;
import cl.duoc.ded.exception.VisorException;

/**
 * Interfaz que define el contrato para el tipo de dato abstracto de <b>Pila</b>.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 *         &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato correspondiente a los elementos que se desea guardar en la pila.
 * 
 */
public interface Pila<T> {
    
    
    /**
     * Introduce (apila) un elemento en la Pila.
     * @param elemento El elemento a introducir dentro de la pila.
     * @throws ElementoDuplicadoException si el elemento ya se encuentra dentro de la pila.
     */
    public void push(T elemento);
    
    
    /**
     * Retorna y quita de la Pila el &uacute;ltimo elemento apilado.
     * @return &Uacute;ltimo elemento apilado.
     * @throws ElementoNoExisteException si el m&eacute;todo es llamado cuando
     * la pila se encuentra vac&iacute;a.
     */
    public T pop();
    
    
    /**
     * Devuelve el &uacute;ltimo elemento apilado sin quitarlo de la pila. Si la pila
     * se encuentra vac&iacute;a, el m&eacute;todo retorna <i>null</i>.
     * @return &Uacute;ltimo elemento introducido en la pila o nulo si no hubiese ninguno.
     */
    public T verTope();
    
    
    /**
     * Indica si la pila no tiene ning&uacute;n elemento.
     * @return <tt>true</tt> si la pila no tiene elementos y <tt>false</tt> en caso contrario
     */
    public boolean isVacia();
    
    
    /**
     * Indica si la pila ha alcanzado su m&aacute;xima capacidad.
     * @return <tt>true</tt> si la pila no puede seguir apilando elementos y 
     * <tt>false</tt> en caso contrario. Para el caso de una implementaci&oacute;n
     * de la Pila con memoria din&aacute;mica, este m&eacute;todo debiese retornar <tt>false</tt>
     * siempre.
     */
    public boolean isLlena();
    
    /**
     * Muestra el contenido de la Pila de acuerdo a la funcionalidad definida por el visor.
     * 
     * @param visor Objeto con la implementaci&oacute;n para visualizar el contenido de la pila.
     * @throws VisorException si ocurre alg&uacute;n error al visualizar la pila.
     */ 
    public void visualizar(Visualizable<Pila> visor) throws VisorException;
}
