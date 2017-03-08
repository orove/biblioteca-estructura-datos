/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.api.util;

import cl.duoc.ded.exception.VisorException;

/**
 * Interfaz para ver el contenido de una estructura de datos.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de estructura de datos que se desea visualizar.
 */
public interface Visualizable<T> {
    
    public void ver(T tipoEstructuraDatos) throws VisorException;
    
}
