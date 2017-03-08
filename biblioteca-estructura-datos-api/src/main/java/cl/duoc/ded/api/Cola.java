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
import cl.duoc.ded.exception.VisorException;

/**
 * Interfaz que define el contrato para el tipo de dato abstracto de <b>Cola</b>.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.1
 * @param <T> Tipo de dato de los elementos que se desea manipular en la cola.
 */
public interface Cola<T> {
    
    /**
     * Introduce un nuevo elemento en la cola.
     * @param elemento Corresponde al elemento a encolar.
     */
    public void encolar(T elemento);
    
    /**
     * Retira de la cola el primer elemento introducido.
     * 
     * @return El elemento que se encuentra en el primer lugar de la cola.
     */
    public T desencolar();
    
    /**
     * Indica si la cola tiene no elementos.
     * 
     * @return <tt>true</tt> si la cola no tiene elementos y <tt>false</tt> en caso contrario.
     */
    public boolean isVacia();
    
    
    /**
     * Indica si la cola est&aacute; llena.
     * 
     * @return <tt>true</tt> si la cola no puede seguir encolando elementos y 
     * <tt>false</tt> en caso contrario. Para el caso de una implementaci&oacute;n
     * con memoria din&aacute;mica, este m&eacute;todo debiese retornar siempre <tt>false</tt>.
     */
    public boolean isLlena();
    
    
    /**
     * Devuelve el pr&oacute;ximo elemento a desencolar sin quitarlo de la Cola. Si la cola
     * se encuentra vac&iacute;a, el m&eacute;todo retorna <i>null</i>.
     * @return Pr&oacute;ximo elemento a desencolar.
     */
    public T verProximo();
    
    
    /**
     * Muestra el contenido de la Cola de acuerdo a la l&oacute;gica implementada por el visor.
     * 
     * @param visor Objeto con la implementaci&oacute;n para visualizar el contenido de la cola.
     * @throws VisorException si ocurre alg&uacute;n error al visualizar la cola.
     */ 
    public void visualizar(Visualizable<Cola> visor) throws VisorException;
}
