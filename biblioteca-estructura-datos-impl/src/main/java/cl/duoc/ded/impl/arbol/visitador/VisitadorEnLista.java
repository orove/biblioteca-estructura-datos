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

import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visitador;
import cl.duoc.ded.impl.lista.ListaEnlazadaSimpleImpl;

/**
 *
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visitador}
 * que permite introducir en una {@link cl.duoc.ded.api.Lista} cada elemento visitado.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato del elemento a visitar.
 *
 */
public class VisitadorEnLista<T> implements Visitador<T> {
    
    Lista<T> lista = new ListaEnlazadaSimpleImpl<>();

    @Override
    public void visitar(T elemento) {
        this.lista.agregarElemento(elemento);
    }
  
    /**
     * Devuelve la {@link cl.duoc.ded.api.Lista} con los elementos visitados en su interior.
     *
     * @return {@link cl.duoc.ded.api.Lista} con los elementos visitados.
     */
    public Lista<T> getLista() {
        return this.lista;
    }
}
