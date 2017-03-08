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

/**
 * Interfaz que extiende la estructura abstracta de una Cola al tipo especial de <b>Cola de Prioridad</b>. 
 * La particularidad de este tipo de Cola, es que permite asignar una prioridad al elemento que se 
 * desea encolar, pudiendo as&iacute; un elemento con alta prioridad ser atentido (desencolado)
 * antes que uno ingresado con menor prioridad.
 * 
 * @author Osvaldo Rodr&iacute;guez
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato de los elementos que se desea manipular en la Cola de Prioridad.
 */
public interface ColaPrioridad<T> extends Cola<T> {
    
    /**
     * Enumeraci&oacute;n con los tipos de prioridad que es posible asignar 
     * a los elementos que se introducir&aacute;n en una Cola de Prioridad.
     */
    enum Prioridad {
        /**
         * Prioridad de mayor rango, la cual anteceder&aacute; a todas las dem&aacute;s, es decir,
         * un elemento ingresado con esta prioridad podr&aacute; tomar la posici&oacute;n del elemento
         * m&aacute;s pr&oacute;ximo a ser desencolado mientras &eacute;ste no tenga tambi&eacute;n 
         * prioridad ALTA.
         */
        ALTA(1),
        /**
         * Prioridad regular, que conlleva a que el elemento sea incorporado de igual forma que como se hace 
         * en una cola FIFO.
         */
        NORMAL(0),
        /**
         * Prioridad desplazable, el elemento con esta prioridad se incorpora ubic&aacute;ndose inmediatamente despu&eacute;s
         * del &uacute;ltimo elemento encolado.
         */
        BAJA(-1);
        
        private int valor = 0;
        
        Prioridad(int valor) {
            this.valor = valor;
        }
        
        /**
         * Devuelve la ponderaci&oacute;n como un valor entero asignado a la Prioridad.
         * @return n&uacute;mero entero. Menor que cero si la prioridad es BAJA, cero si
         * es NORMAL y mayor que cero si es ALTA.
         */
        public int getValor() {
            return this.valor;
        }  
        
    }
    
    /**
     * Introduce un nuevo elemento a la cola con prioridad NORMAL
     * por defecto.
     * @param elemento el elemento a introducir.
     */
    @Override
    void encolar(T elemento);
    
    
    /**
     * Introduce un nuevo elemento a la cola con la prioridad 
     * inicada en el segundo par&aacute;metro.
     * @param elemento el elemento a introducir
     * @param prioridad Prioridad del elemento
     */
    void encolar(T elemento, Prioridad prioridad);
    
}
