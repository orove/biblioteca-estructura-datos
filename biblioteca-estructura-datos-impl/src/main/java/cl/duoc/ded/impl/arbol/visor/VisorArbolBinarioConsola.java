/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol.visor;

import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;

/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * que permite visualizar el contenido de una Lista en la consola (salida est&aacute;ndar).
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class VisorArbolBinarioConsola implements Visualizable<Arbol> {

    @Override
    public void ver(Arbol arbol) throws VisorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
