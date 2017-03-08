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

import cl.duoc.ded.api.Cola;
import cl.duoc.ded.impl.cola.ColaImpl;
import cl.duoc.ded.api.util.Visitador;

/**
 *
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visitador}
 * que introduce cada elemento visitado en una {@link cl.duoc.ded.api.Cola}.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato del elemento a visitar y que ser&aacute; apilado.
 */
public class VisitarEncolando<T> implements Visitador<T> {
    
    Cola<T> cola = new ColaImpl(); 

    @Override
    public void visitar(T elemento) {
        this.cola.encolar(elemento);
    }
    
    /**
     * Devuelve la {@link cl.duoc.ded.api.Cola} con los elementos visitados en su interior.
     *
     * @return {@link cl.duoc.ded.api.Cola} con los elementos visitados.
     */
    public Cola getCola() {
        return this.cola;
    }
}
