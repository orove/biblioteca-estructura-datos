/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.exception;

/**
 * Clase para reportar una excepci&oacute;n ocurrida al intentar visualizar
 * el contenido de una estructura de datos.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class VisorException extends Exception {
  
    public VisorException(String msg) {
        super(msg);
    }
    
    public VisorException(String msg, Throwable t) {
        super(msg, t);
    }
    
}
