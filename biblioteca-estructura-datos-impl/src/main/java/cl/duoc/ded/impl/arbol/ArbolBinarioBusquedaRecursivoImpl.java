/**
 * DUOC UC
 * Escuela de Inform&aacute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol;


import cl.duoc.ded.exception.ElementoDuplicadoException;
import cl.duoc.ded.exception.ElementoNuloException;

/**
 *
 * Implementaci&oacute;n recursiva de un &aacute;rbol binario de b&uacute;squeda.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato de los elementos que manipular&aacute;a el &aacute;rbol, debe implementar
 *            la interfaz Comparable.
 */
public class ArbolBinarioBusquedaRecursivoImpl<T extends Comparable> extends ArbolBinarioRecursivoImpl<T> {
     
    
    @Override
    public void agregarElemento(T nuevoElemento) {
        
        if(nuevoElemento == null) {
            throw new ElementoNuloException("no se puede agregar elementos nulos al árbol binario");
        }

        if(this.existe(nuevoElemento)) {
            throw new ElementoDuplicadoException("el árbol binario de búsqueda no acepta elementos duplicados.");
        }
        
        super.agregarElemento(nuevoElemento);
        
    }
    
}
