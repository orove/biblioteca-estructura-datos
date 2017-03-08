/**
 * DUOC UC
 * Escuela de Inform&aacute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol.visitador;

import cl.duoc.ded.api.util.Visitador;

/**
 *
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visitador}
 * que permite ver en la consola (salida est&aacute;ndar) cada elemento visitado.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato del elemento a visitar.
 *
 */
public class VisitarImprimiendoEnConsola<T> implements Visitador<T> {

    @Override
    public void visitar(T elemento) {
        System.out.println("["+elemento+"]");
    }
    
}
