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
 * aquella que debe, en lo posible, ser evitada program&aacute;ticamentente 
 * al recibir un argumento por par&aacute;metro cuyo valor est&aacute; fuera
 * del rango que espera manejar el m&eacute;todo.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class ArgumentoInvalidoException extends RuntimeException {
  
    public ArgumentoInvalidoException(String msg) {
        super(msg);
    }
    
    public ArgumentoInvalidoException(String msg, Throwable t) {
        super(msg, t);
    }
    
}
