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
 * al agregar un elemento cuando la capacidad m&aacute;xima de la estructura
 * ya ha sido alcanzada.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class CapacidadExcedidaException extends RuntimeException {
  
    public CapacidadExcedidaException(String msg) {
        super(msg);
    }
    
    public CapacidadExcedidaException(String msg, Throwable t) {
        super(msg, t);
    }
    
}
