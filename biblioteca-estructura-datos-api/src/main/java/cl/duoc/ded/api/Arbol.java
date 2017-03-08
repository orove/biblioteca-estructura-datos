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
import cl.duoc.ded.exception.ElementoNuloException;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.api.util.Visitador;

/**
 * Interfaz que define el contrato para el tipo de dato abstracto de <b>&Aacute;rbol</b>.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato de los elementos a manipular en el &aacute;rbol. El tipo de dato
 * debe implementar la interfaz {@link java.lang.Comparable} para determinar el comparador de
 * comparaci&oacute;n entre un elemento y otro.
 */
public interface Arbol<T extends Comparable> {
    
    /**
     * Recorre el &aacute;rbol en <i>pre-orden</i>: 
     * <ol>
     *     <li>visitar el elemento dentro del nodo,</li>
     *     <li>luego recorrer en <i>pre-order</i> la rama izquierda y</li>
     *     <li>finalmente recorrer en <i>pre-order</i> la(s) rama(s) de la derecha.</li>
     * </ol>
     * 
     * @param operacion Objeto que implementa la interfaz
     * {@link cl.duoc.ded.api.util.Visitador} y que define la acci&oacute;n a ejecutar 
     * cuando se visita un nodo del &aacute;rbol.
     */
    public void recorrerEnPreOrden(Visitador<T> operacion);
    
    
    /**
     * Recorre el &aacute;rbol en <i>post-orden</i>: 
     * <ol>
     *     <li>recorrer en <i>post-orden</i> la rama izquierda,</li>
     *     <li>luego recorrer en <i>post-orden</i> la(s) rama(s) de la derecha</li>
     *     <li>y finalmente visitar el elemento dentro del nodo.</li>     
     * </ol>
     * 
     * @param operacion Objeto que implementa la interfaz
     * {@link cl.duoc.ded.api.util.Visitador} y que define la acci&oacute;n a ejecutar 
     * cuando se visita un nodo del &aacute;rbol.
     */
    public void recorrerEnPostOrden(Visitador<T> operacion);
    
    
    /**
     * Recorre el &aacute;rbol en <i>en-orden</i>: 
     * <ol>
     *     <li>recorrer en <i>en-orden</i> la rama izquierda,</li>
     *     <li>visitar el elemento dentro del nodo</li>   
     *     <li>y recorrer <i>en-orden</i> la(s) rama(s) de la derecha</li>       
     * </ol>
     * 
     * @param operacion Objeto que implementa la interfaz
     * {@link cl.duoc.ded.api.util.Visitador} y que define la acci&oacute;n a ejecutar 
     * cuando se visita un nodo del &aacute;rbol.
     */
    public void recorrerEnOrden(Visitador<T> operacion);
    
    
    /**
     * Recorre el &aacute;rbol por niveles, es decir:
     * <ol>
     *     <li>visitar el elemento del primer nivel (ra&iacute;z), </li>
     *     <li>bajar y visitar todos los hijos del nodo ra&iacute;z,</li>
     *     <li>luego seguir bajando para visitar todos los nietos</li>
     *     <li>y as&iacute; sucesivamente.</li>
     * </ol>
     * @param operacion Objeto que implementa la interfaz
     * {@link cl.duoc.ded.api.util.Visitador} y que define la acci&oacute;n a ejecutar 
     * cuando se visita un nodo del &aacute;rbol.
     */
    public void recorrerEnAmplitud(Visitador<T> operacion);
    
    
    /**
     * Agrega un nuevo elemento dentro del &aacute;rbol.
     * @param nuevoElemento Elemento a introducir en &aacute;rbol.
     * @throws ElementoNuloException si el elemento es nulo.
     * @throws ElementoDuplicadoException dependiendo de la implementaci&oacute;n, 
     *         si se detecta que el elemento ya existeentonces se lanza esta exception.
     */
    public void agregarElemento(T nuevoElemento);
       
    
    /**
     * Elimina un elemento del &aacute;rbol.
     * 
     * @param elemento El elemento a eliminar del &aacute;rbol.
     * @return <tt>true</tt> si el elemento es eliminado exitosamente y <tt>false</tt> si el elemento no existe o no se pudo eliminar &aacute;rbol.
     */
    public boolean eliminarElemento(T elemento);

    
    /**
     * Indica si el elemento se encuentra dentro del árbol.
     * 
     * @param elemento elemento a buscar
     * @return <tt>true</tt> si el elemento existe en el árbol y <tt>false</tt> en caso contrario.
     */
    public boolean existe(T elemento);
    
    
    /**
     * Indica si el &aacute;rbol tiene dos hijos en todos los nodos que no son hojas (nodos no terminales).
     * 
     * @return <tt>true</tt> si el &aacute;rbol está podado, <tt>false</tt> en caso contrario.
     */
    public boolean isPodado();
    
    
    /**
     * Indica si el &aacute;rbol adem&aacute;s de podado tiene todas 
     * sus hojas a la misma altura.
     * 
     * @return <tt>true</tt> si el &aacute;rbol es perfecto
     */
    public boolean isPerfecto();
    
    
    /**
     * Indica si el &aacute;rbol est&aacute; balanceado, es decir, si el valor absoluto de
     * la diferencia entre la altura de los sub&aacute;rboles de la rama izquierda
     * y la rama derecha es igual o menor a una valor de <i>tolerancia</i>.
     * 
     * @param tolerancia valor absoluto para el c&aacute;lculo del factor de equilibrio.
     * @return <tt>true</tt> si el &aacute;rbol est&aacute; equilibrado, <tt>false</tt> en caso
     * contrario.
     */
    public boolean isEquilibrado(int tolerancia);
    
    
    /**
     * Devuelve la cantidad de elementos que tiene el &aacute;rbol.
     * 
     * @return n&uacute;mero de elementos contenidos en el &aacute;rbol.
     */
    public int getPeso();
    
    
    /**
     * Devuelve el m&aacute;ximo nivel del &aacute;rbol menos uno, tambi&eacute;n
     * se conoce omo <b>profundidad</b>.
     * 
     * @return valor entero con la altura del &aacute;rbol.
     */
    public int getAltura();                
    
    /**
     * Devuelve una lista con todos los elementos del &aacute;rbol que
     * conectan la ra&iacute;z con el elemento de <tt>destino</tt>.
     * 
     * @param destino El elemento de destino.
     * @return lista de elementos que se debe visitar para llegar al elemento de destino.
     */
    public Lista<T> getCamino(T destino);
    
    
    /**
     * Muestra el contenido del &aacute;rbol dependiendo de la l&oacute;gica implementada
     * por el visor.
     * 
     * @param visor Objeto con la implementaci&oacute;n para visualizar el contenido de la lista.
     * @throws VisorException si ocurre alg&uacute;n error al visualizar el contenido del &aacute;rbol.
     */
    public void visualizar(Visualizable<Arbol> visor) throws VisorException;
    
    
}
