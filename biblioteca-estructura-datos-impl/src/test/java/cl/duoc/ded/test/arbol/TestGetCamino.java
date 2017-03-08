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

import cl.duoc.ded.api.Lista;
import cl.duoc.ded.impl.arbol.ArbolBinarioRecursivoImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CETECOM
 */
public class TestGetCamino {

    /**
     * Test of getCamino method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testGetCamino1() {
        
        //Instancio un ArbolBinario  
        ArbolBinarioRecursivoImpl arbolEnteros = new ArbolBinarioRecursivoImpl();
        //Asigno Valores 
        arbolEnteros.agregarElemento(6);
        arbolEnteros.agregarElemento(3);
        arbolEnteros.agregarElemento(1);
        arbolEnteros.agregarElemento(4);
        arbolEnteros.agregarElemento(12);
        arbolEnteros.agregarElemento(10);
        arbolEnteros.agregarElemento(9);
        arbolEnteros.agregarElemento(7);
        arbolEnteros.agregarElemento(8);
        arbolEnteros.agregarElemento(11);
        arbolEnteros.agregarElemento(19);
        
        //esta prueba sera NUll ya que getCamino retorna null cuando no encuentra el numero por paramentro
        Lista<Integer> camino = arbolEnteros.getCamino(10);
        
        assertNotNull(camino); 
        
        assertEquals(3, camino.getTotalElementos());
        
        assertEquals(new Integer(6), camino.getElemento(0));
        assertEquals(new Integer(12), camino.getElemento(1));
        assertEquals(new Integer(10), camino.getElemento(2));
        
    }
    
    @Test
    public void testGetCamino2() {
        
        //Instancio un ArbolBinario  
        ArbolBinarioRecursivoImpl arbolEnteros = new ArbolBinarioRecursivoImpl();
        //Asigno Valores 
        arbolEnteros.agregarElemento(6);
        arbolEnteros.agregarElemento(3);
        arbolEnteros.agregarElemento(1);
        arbolEnteros.agregarElemento(4);
        arbolEnteros.agregarElemento(12);
        arbolEnteros.agregarElemento(10);
        arbolEnteros.agregarElemento(9);
        arbolEnteros.agregarElemento(7);
        arbolEnteros.agregarElemento(8);
        arbolEnteros.agregarElemento(11);
        arbolEnteros.agregarElemento(19);
        
        //esta prueba sera NUll ya que getCamino retorna null cuando no encuentra el numero por paramentro
        Lista<Integer> camino = arbolEnteros.getCamino(8);
        
        assertNotNull(camino); 
        
        assertEquals(6, camino.getTotalElementos());
        
        assertEquals(new Integer(6), camino.getElemento(0));
        assertEquals(new Integer(12), camino.getElemento(1));
        assertEquals(new Integer(10), camino.getElemento(2));
        assertEquals(new Integer(9), camino.getElemento(3));
        assertEquals(new Integer(7), camino.getElemento(4));
        assertEquals(new Integer(8), camino.getElemento(5));
        
    }

    @Test
    public void testGetCaminoSinCamino() {
        
        //Instancio un ArbolBinario  
        ArbolBinarioRecursivoImpl arbolEnteros = new ArbolBinarioRecursivoImpl();
        //Asigno Valores 
        arbolEnteros.agregarElemento(6);
        arbolEnteros.agregarElemento(3);
        arbolEnteros.agregarElemento(1);
        arbolEnteros.agregarElemento(4);
        arbolEnteros.agregarElemento(12);
        arbolEnteros.agregarElemento(10);
        arbolEnteros.agregarElemento(9);
        arbolEnteros.agregarElemento(7);
        arbolEnteros.agregarElemento(8);
        arbolEnteros.agregarElemento(11);
        arbolEnteros.agregarElemento(19);
        
        //esta prueba sera NUll ya que getCamino retorna null cuando no encuentra el numero por paramentro
        Lista<Integer> camino = arbolEnteros.getCamino(20);
        
        assertNull(camino);         
        
    }

    
}
