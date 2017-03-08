/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.lista;

import cl.duoc.ded.exception.ElementoDuplicadoException;

/**
 * Implementaci&oacute;n de {@link cl.duoc.ded.api.Lista} utilizando  
 * nodos doblemente enlazados.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @param <T> tipo de dato del elemento a manipular en la lista.
 * @see cl.duoc.ded.api.Lista
 */
public class ListaEnlazadaDobleSinDuplicadosImpl<T> extends ListaEnlazadaDobleImpl<T> {
        
    @Override
    public void agregarElemento(T elemento) {
                
        if(this.existe(elemento)) {
            throw new ElementoDuplicadoException("la lista no permite agregar elementos duplicados");
        }
        
        super.agregarElemento(elemento);
    }

    
    @Override
    public void insertarElemento(T elemento) {
        
        if(this.existe(elemento)) {
            throw new ElementoDuplicadoException("la lista no permite agregar elementos duplicados");
        }
        
        super.insertarElemento(elemento);
    }
        
}
