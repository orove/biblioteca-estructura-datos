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
 * Clase para reportar una excepci&oacute;n del tipo no chequeada, es decir,
 * aquella que debe ser, en lo posible, evitada program&aacute;ticamentente
 * al agregar un elemento que ya se encuentra en la estructura de datos y 
 * cuando &eacute;sta no soporta elementos duplicados.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class ElementoDuplicadoException extends RuntimeException {
  
    public ElementoDuplicadoException(String msg) {
        super(msg);
    }
    
    public ElementoDuplicadoException(String msg, Throwable t) {
        super(msg, t);
    }
    
}
