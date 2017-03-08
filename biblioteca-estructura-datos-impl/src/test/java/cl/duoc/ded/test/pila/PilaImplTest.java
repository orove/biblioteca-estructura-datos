/*
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501 DUOC
 *  
 */

package cl.duoc.ded.test.pila;

import cl.duoc.ded.api.Pila;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.CapacidadExcedidaException;
import cl.duoc.ded.impl.pila.PilaImpl;
import cl.duoc.ded.impl.pila.visor.VisualizarPilaEnConsolaImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Clase con pruebas unitarias de la implementaci&oacute;n de Pila.
 * 
 * @author Osvaldo Rodr&iacute;guez
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 */
public class PilaImplTest {
    
    @Test
    public void testPilaImpl(){
        System.out.println("prueba unitaria del constructor: PilaImpl");
        PilaImpl<String> pila = new PilaImpl();
        
        assertNotNull("el constructor dinamico de la pila devolvio una pila nula",pila);
        assertTrue("la pila dinámica no tiene elementos y el método isVacia retornó falso",pila.isVacia());
        
        pila = new PilaImpl(4);
        
        assertNotNull("el constructor estático de la pila devolvio una pila nula",pila);
        assertTrue("la pila estática no tiene elementos y el método isVacia retornó falso",pila.isVacia());
    }
    
    
    @Test
    public void testPush() {
        System.out.println("prueba unitaria del método: push");
        String elemento1 = "primero en llegar último en salir";
        String elemento2 = "segundo en llegar";
        String elemento3 = "tercero en llegar";
        String elemento4 = "último en llegar primero en salir";
        
        PilaImpl<String> pila = new PilaImpl();               
        
        pila.push(elemento1);

        assertFalse("La pila (dinámica) no debería estar vacía, pues tiene un elemento", pila.isVacia());
        
        try {            
            pila = new PilaImpl(3); 
            pila.push(elemento1);
            
            assertFalse("La pila (estática) no debería estar vacía, pues tiene un elemento", pila.isVacia());
            
            pila.push(elemento2);
            pila.push(elemento3);            
            pila.push(elemento4);
            
            fail("se esperaba execpción por superar la cantidad definida por el constructor");
        } catch(Exception e) {
            assertTrue("La excepción arrojada no es del tipo esperado", e instanceof CapacidadExcedidaException);
        }
    }

    @Test
    public void testPop() {
        System.out.println("prueba unitaria del método: pop");
        String elemento1 = "primero en llegar último en salir";
        String elemento2 = "segundo en llegar";
        String elemento3 = "tercero en llegar";
        String elemento4 = "último en llegar primero en salir";
        
        PilaImpl<String> pila = new PilaImpl();
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        String elemento = pila.pop();
        assertEquals("el elemento desapilado usando una pila dinámica no corresponde",elemento4, elemento);
        
        pila = new PilaImpl(4);
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        elemento = pila.pop();
        assertEquals("el elemento desapilado usando una pila estática no corresponde",elemento4, elemento);
    }

    @Test
    public void testIsVacia() {
        System.out.println("prueba unitaria del método: isVacia");
        String elemento1 = "primero en llegar último en salir";
        String elemento2 = "segundo en llegar";
        String elemento3 = "tercero en llegar";
        String elemento4 = "último en llegar primero en salir";
        
        PilaImpl<String> pila = new PilaImpl();
        
        assertTrue("La pila (dinámica) no tiene elmentos y el método dice que sí", pila.isVacia());
        
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        assertFalse("La pila (dinámica) tiene elmentos y el método dice que no", pila.isVacia());
        
        pila = new PilaImpl(4);
        
        assertTrue("La pila (estática) no tiene elmentos y el método dice que sí", pila.isVacia());
        
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        assertFalse("La pila (estática) tiene elmentos y el método dice que no", pila.isVacia());
    }

    @Test
    public void testIsLlena() {
        System.out.println("prueba unitaria del método: isLlena");
        String elemento1 = "primero en llegar último en salir";
        String elemento2 = "segundo en llegar";
        String elemento3 = "tercero en llegar";
        String elemento4 = "último en llegar primero en salir";
        
        PilaImpl<String> pila = new PilaImpl(4);
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        assertTrue("La pila (estática) sí está llena y el método dice que no", pila.isLlena());
        
    }

    @Test
    public void testVerTope() {
        System.out.println("prueba unitaria del método: verTope");
        String elemento1 = "primero en llegar último en salir";
        String elemento2 = "segundo en llegar";
        String elemento3 = "tercero en llegar";
        String elemento4 = "último en llegar primero en salir";
        
        PilaImpl<String> pila = new PilaImpl();
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        String tope = pila.verTope();
        
        assertEquals("el elemento en el tope de la pila (dinámica) no corresponde",elemento4, tope);
        
        pila = new PilaImpl(5);
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        tope = pila.verTope();
        
        assertEquals("el elemento en el tope de la pila (estática) no corresponde",elemento4, tope);
    }

    @Test
    public void testVisualizar() throws Exception {
        System.out.println("prueba unitaria del método: visualizar");
        String elemento1 = "primero en llegar último en salir";
        String elemento2 = "segundo en llegar";
        String elemento3 = "tercero en llegar";
        String elemento4 = "último en llegar primero en salir";
        
        PilaImpl<String> pila = new PilaImpl();
        
        pila.push(elemento1);
        pila.push(elemento2);
        pila.push(elemento3);
        pila.push(elemento4);
        
        Visualizable<Pila> visor = new VisualizarPilaEnConsolaImpl();
        pila.visualizar(visor);
        
        assertTrue("la pila ha sido modificada",!pila.isVacia());        
    }    
}
