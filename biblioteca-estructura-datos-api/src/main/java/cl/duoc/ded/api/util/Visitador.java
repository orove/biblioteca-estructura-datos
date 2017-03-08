/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.api.util;


/**
* Interfaz que establece el m&eacute;todo a ejecutar cuando 
* se visita el contenido de un nodo en una estructura de datos.
* @author Osvaldo Rodr&iacute;guez 
* &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
* @version 1.0
* @param <T> Tipo de dato de los elementos que manipula la estructura.
*/
public interface Visitador<T> {
        
        /**
         * Realiza una acci&oacute;n sobre el elemento del &aacute;rbol que se est&aacute;
         * visitando.
         * @param elemento Elemento contenido en el nodo visitado.
         */
        void visitar(T elemento);        
    }
