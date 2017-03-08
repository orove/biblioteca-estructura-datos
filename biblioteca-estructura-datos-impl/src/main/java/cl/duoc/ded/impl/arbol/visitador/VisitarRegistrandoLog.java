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


import java.util.logging.Level;
import java.util.logging.Logger;
import cl.duoc.ded.api.util.Visitador;


/**
 *
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visitador}
 * que utiliza un {@link java.util.logging.Logger} para registrar cada elemento visitado.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato del elemento a visitar.
 *
 */
public class VisitarRegistrandoLog<T> implements Visitador<T> {

    private static final Logger LOG = Logger.getLogger(VisitarRegistrandoLog.class.getName());


    public VisitarRegistrandoLog() {
        LOG.setLevel(Level.INFO);
    }

    public VisitarRegistrandoLog(Level level) {
        LOG.setLevel(level);
    }

    @Override
    public void visitar(T elemento) {
        String info = "["+elemento+"]";
        LOG.info(info);
    }
    
}
