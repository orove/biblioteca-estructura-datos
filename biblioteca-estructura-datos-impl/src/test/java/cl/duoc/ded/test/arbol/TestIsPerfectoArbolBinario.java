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
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Se agrega clase test de prueba para metodo isPerfecto de Arbol Binario. 
 * Se crea arbol que contiene caracteres para la prueba del metodo.
 * @author isabella
 */
public class TestIsPerfectoArbolBinario {
    @Test
    public void testIsPerfecto() {
        // Se instancia un arbol binario que contiene elementos de tipo Character
        Arbol<Character> arbol = new ArbolBinarioRecursivoImpl();
        // Se agregan los elementos al arbol con el método agregarElemento
        arbol.agregarElemento('M');
        arbol.agregarElemento('D');
        arbol.agregarElemento('R');
        arbol.agregarElemento('A');
        arbol.agregarElemento('F');

        
        assertFalse("El arbol no tiene la condicion de perfecto", arbol.isPerfecto());

        // Se agregan elementos para generar la condicion de perfecto del arbol creado
        arbol.agregarElemento('O');     
        arbol.agregarElemento('S');
        assertTrue("El arbol es perfecto",arbol.isPerfecto());
    }
    
}
