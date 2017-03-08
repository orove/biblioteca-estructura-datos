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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArbolBinarioImplTest {
    
    public ArbolBinarioImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recorrerEnPreOrden method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testRecorrerEnPreOrden() {
    }

    /**
     * Test of recorrerEnPostOrden method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testRecorrerEnPostOrden() {
    }

    /**
     * Test of recorrerEnOrden method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testRecorrerEnOrden() {
    }

    /**
     * Test of recorrerEnAmplitud method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testRecorrerEnAmplitud() {
    }

    /**
     * Test of agregarElemento method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testAgregarElemento() {
    }

    /**
     * Test of existe method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testExiste() {
        ArbolBinarioRecursivoImpl<Integer> arbol = new ArbolBinarioRecursivoImpl<Integer>();
        arbol.agregarElemento(new Integer(1));
        arbol.agregarElemento(new Integer(2));
        arbol.agregarElemento(new Integer(3));
        arbol.agregarElemento(new Integer(4));
        
        assertFalse("El metodo existe retorna true cuando el elemento no existe!",arbol.existe(new Integer(5)));
        assertTrue("El metodo existe retorna false cuando el elemento si existe!", arbol.existe(new Integer(3)));
    }

    /**
     * Test of eliminarElemento method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testEliminarElemento() {
    }

    /**
     * Test of agregar method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testAgregar() {
    }

    /**
     * Test of isPodado method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testIsPodado() {
        Arbol<Character> arbol = new ArbolBinarioRecursivoImpl();

        arbol.agregarElemento('M');
        arbol.agregarElemento('D');
        arbol.agregarElemento('A');
        arbol.agregarElemento('E');
        arbol.agregarElemento('R');
        arbol.agregarElemento('O');
         
        
        assertFalse(arbol.isPodado());
        
        arbol.agregarElemento('S');
        assertTrue(arbol.isPodado());
    }

    /**
     * Test of visualizar method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testVisualizar() {
    }

    /**
     * Test of isPerfecto method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testIsPerfecto() {
         Arbol<Character> arbol = new ArbolBinarioRecursivoImpl();

        arbol.agregarElemento('M');
        
        arbol.agregarElemento('D');
        arbol.agregarElemento('R');
        
        arbol.agregarElemento('A');
        arbol.agregarElemento('F');

        assertFalse(arbol.isPerfecto());
        
        arbol.agregarElemento('O');     
        arbol.agregarElemento('S');
        assertTrue(arbol.isPerfecto());
    }

    /**
     * Test of isEquilibrado method, of class ArbolBinarioRecursivoImpl.
     */
     @Test
    public void testIsEquilibrado() {
        
        Arbol<String> arbol = new ArbolBinarioRecursivoImpl();
       
        arbol.agregarElemento("Manzana");
        arbol.agregarElemento("Pera");          
        arbol.agregarElemento("Kiwi");          
        arbol.agregarElemento("Melón");          
        
        assertTrue("El metodo equilibrado retorna True cuando el arbol esta equilibrado",arbol.isEquilibrado(0) == true);
        assertFalse("El metodo equilibrado retorna False cuando el arbol no esta equilibrado",arbol.isEquilibrado(0) == false);

    }

    /**
     * Test of getPeso method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testGetPeso() {
    }

    /**
     * Test of getAltura method, of class ArbolBinarioRecursivoImpl.
     */
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
        
      assertEquals(4, arbol.getAltura());
    }

    /**
     * Test of getCamino method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testGetCamino() {
    }

    /**
     * Test of calcularPeso method, of class ArbolBinarioRecursivoImpl.
     */
    @Test
    public void testCalcularPeso() {
    }
    
}
