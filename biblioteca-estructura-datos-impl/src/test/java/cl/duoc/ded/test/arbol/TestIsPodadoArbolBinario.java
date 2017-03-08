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

/**
 *
 * @author Alfredo
 */
public class TestIsPodadoArbolBinario {

    @Test
    public void testIsPodado() {

        Arbol<Character> arbol = new ArbolBinarioRecursivoImpl();

        arbol.agregarElemento('M');
        arbol.agregarElemento('D');
        arbol.agregarElemento('A');
        arbol.agregarElemento('E');
        arbol.agregarElemento('R');
        arbol.agregarElemento('O');

        Assert.assertFalse("El arbol no está podado", arbol.isPodado());

        arbol.agregarElemento('S');
        Assert.assertTrue("Arbol esta podado", arbol.isPodado());

    }
}
