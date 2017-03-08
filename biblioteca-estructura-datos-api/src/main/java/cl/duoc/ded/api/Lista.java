/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.api;

import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.ArgumentoInvalidoException;
import cl.duoc.ded.exception.CapacidadExcedidaException;
import cl.duoc.ded.exception.ElementoDuplicadoException;
import cl.duoc.ded.exception.ElementoNuloException;
import cl.duoc.ded.exception.VisorException;

/**
 * Interfaz que define el contrato para el tipo de dato abstracto de <b>Lista</b>.
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato de los elementos que se van a manipular en la lista.
 */
public interface Lista<T> extends Iterable<T> {
    
    /**
     * Retorna verdadero si la lista no contiene elementos.
     * 
     * @return <tt>true</tt> si la lista no contiene ning&uacute;n elemento.
     */    
    public boolean isVacia();
    
    
    /**
     * Retorna verdadero si la lista ha alcanzado su m&aacute;xima capacidad.
     * 
     * @return <tt>true</tt> si ha la lista no se le puede seguir incorporando elementos.
     */    
    public boolean isLlena();
    
    
    /**
     * Retorna el n&uacute;mero de elementos dentro de la lista.
     * 
     * @return Cantidad de elementos en la lista.
     */ 
    public int getTotalElementos();
    
    
    /**
     * Incorpora el elemento especificado al final de la lista.
     * 
     * @param elemento El elemento que se desea incorporar en la lista.
     * @throws ElementoNuloException si el elemento es nulo.
     * @throws CapacidadExcedidaException si la implementaci&oacute;n de 
     * la lista fuese de tipo est&aacute;tica y al intentar agregar el  
     * elemento se excede la capacidad m&aacute;xima definida para la lista.
     * @throws ElementoDuplicadoException si la implementaci&oacute;n de lista 
     * no permitiese incorporar elementos duplicados.
     * 
     */ 
    public void agregarElemento(T elemento);
    
    
    /**
     * Incorpora el elemento especificado al comienzo de la lista.
     * 
     * @param elemento El elemento que se desea incorporar en la lista.    
     * @throws ElementoNuloException si el elemento es nulo.
     * @throws CapacidadExcedidaException si la implementaci&oacute;n de 
     * la lista fuese de tipo est&aacute;tica y al intentar agregar el  
     * elemento se excede la capacidad m&aacute;xima definida para la lista.
     * @throws ElementoDuplicadoException si la implementaci&oacute;n de lista 
     * no permitiese incorporar elementos duplicados.
     */ 
    public void insertarElemento(T elemento);
    
    
    /**
     * Elimina el elemento especificado de la lista.
     * 
     * @param elemento el elemento que se desea quitar de la lista.
     * @return El elemento que ha sido removido de la lista.
     */ 
    public T eliminarElemento(T elemento);        
    
    
    /**
     * Elimina el elemento especificado de la lista.
     * 
     * @param posicion ubicaci&oacute;n del elemento en la lista.
     * @return El elemento removido de la lista.
     */ 
    public T eliminar(int posicion); 
    
    
    /**
     * Elimina todos los elementos de la lista, quedando &eacute;sta vac&iacute;a.
     * 
     */ 
    public void vaciar();
    
    
    /**
     * Retorna verdadero si el elemento ya existe dentro de la lista.
     * 
     * @param elemento El elemento que se desea consultar si existe en la lista.
     * @return <tt>true</tt> si el elemento existe dentro de la lista, <tt>false</tt> en caso contrario.
     */ 
    public boolean existe(T elemento);
    
    
    /**
     * Retorna el primer elemento de la lista.
     * 
     * @return el primer el elemento de la lista.
     */ 
    public T getPrimerElemento();

    
    /**
     * Retorna el &uacute;ltimo elemento de la lista.
     * 
     * @return el &uacute;ltimo  el elemento de la lista.
     */ 
    public T getUltimoElemento();
    
    
    /**
     * Retorna el elemento ubicado en la posici&oacute;n indicada dentro de la lista.
     * 
     * @param posicion ubicaci&oacute;n del elemento en la lista, partiendo desde cero para el 
     * primer elemento.
     * @return devuelve el elemento en la posici&oacute;n indicada.
     * @throws ArgumentoInvalidoException si el valor del par&aacute;metro <b>posicion</b> es
     * negativo o superior a la cantidad de elementos en la lista menos uno.
     */ 
    public T getElemento(int posicion);
            
    
    /**
     * Muestra el contenido de la lista de acuerdo a la funcionalidad definida por el visor.
     * 
     * @param visor Objeto con la implementaci&oacute;n para visualizar el contenido de la lista.
     * @throws VisorException si ocurre alg&uacute;n error al visualizar la lista.
     */ 
    public void visualizar(Visualizable<Lista> visor) throws VisorException;
    
}
