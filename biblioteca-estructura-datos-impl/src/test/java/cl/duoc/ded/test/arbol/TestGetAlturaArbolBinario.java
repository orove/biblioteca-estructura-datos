/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol;

import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.impl.arbol.ArbolBinarioRecursivoImpl;
import org.junit.Assert;
import org.junit.Test;


public class TestGetAlturaArbolBinario {
      
    @Test   
    public void testGetAltura() {
          Arbol<Character> arbol = new ArbolBinarioRecursivoImpl();

          arbol.agregarElemento('M');
          arbol.agregarElemento('D');
          arbol.agregarElemento('A');
          arbol.agregarElemento('E');
          arbol.agregarElemento('F');
          arbol.agregarElemento('R');
          arbol.agregarElemento('N');
          arbol.agregarElemento('O');
          arbol.agregarElemento('T');
          arbol.agregarElemento('W');
          arbol.agregarElemento('U');

          Assert.assertEquals(4, arbol.getAltura());

      }
}