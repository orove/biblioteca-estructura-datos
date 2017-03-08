/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol.ejercicio.salariotrabajador.comparador;

import cl.duoc.ded.test.arbol.ejercicio.salariotrabajador.dominio.Trabajador;
import java.util.Comparator;


/**
 *
 * @author Osvaldo Rodríguez
 */
public class CriterioTrabajadorSalarioAscendente implements Comparator<Trabajador> {

    @Override
    public int compare(Trabajador o1, Trabajador o2) {
        return o1.getSalario().compareTo(o2.getSalario());
    }

}
