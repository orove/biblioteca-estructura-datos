/*
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501 DUOC
 *  
 */
package cl.duoc.ded.test.cola;

import cl.duoc.ded.api.Cola;
import cl.duoc.ded.impl.cola.ColaImpl;
import cl.duoc.ded.impl.cola.visor.VisualizarColaEnConsolaImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Osvaldo Rodr&iacute;guez
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 */
public class ColaImplTest {
    
    @Test
    public void testEncolar() {
        System.out.println("iniciando prueba unitaria del método: encolar");
        
        Cola<String> cola = new ColaImpl();
        
        String elemento1 = "Z";
        String elemento2 = "B";
        String elemento3 = "H";
        String elemento4 = "A";
        String elemento5 = "C";
        String elemento6 = "N";
        String elemento7 = "L";
        String elemento8 = "D";
        String elemento9 = "R";
        String elemento10 = "E";
        
        assertTrue("la cola sí está vacía, pero el método isVacia retornó falso.", cola.isVacia());
        
        cola.encolar(elemento1);
        cola.encolar(elemento2);
        cola.encolar(elemento3);
        cola.encolar(elemento4);
        cola.encolar(elemento5);
        cola.encolar(elemento6);
        cola.encolar(elemento7);
        cola.encolar(elemento8);
        cola.encolar(elemento9);
        cola.encolar(elemento10);
        
        assertFalse("la cola no puede estar llena, ya que es dinámica.", cola.isLlena());
        assertFalse("la cola no está vacía, pero el método isVacia retornó true.", cola.isVacia());
        
        String elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento1, elementoDesencolado);
        assertEquals("No se respetó la prioridad al desencolar el primer elemento.", elemento1, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento2);
        assertEquals("No se respetó la prioridad al desencolar el segundo elemento.", elemento2, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento3);
        assertEquals("No se respetó la prioridad al desencolar el tercer elemento.", elemento3, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento4);
        assertEquals("No se respetó la prioridad al desencolar el cuarto elemento.", elemento4, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento5);
        assertEquals("No se respetó la prioridad al desencolar el quinto elemento.", elemento5, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento6);
        assertEquals("No se respetó la prioridad al desencolar el sexto elemento.", elemento6, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento7);
        assertEquals("No se respetó la prioridad al desencolar el séptimo elemento.", elemento7, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento8);
        assertEquals("No se respetó la prioridad al desencolar el octavo elemento.", elemento8, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento9);
        assertEquals("No se respetó la prioridad al desencolar el noveno elemento.", elemento9, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento10);
        assertEquals("No se respetó la prioridad al desencolar el décimo elemento.", elemento10, elementoDesencolado);
              
    }


    @Test
    public void testDesencolar() {
        System.out.println("iniciando prueba unitaria del método: desencolar");
        
        Cola<String> cola = new ColaImpl();
        
        String elemento1 = "Z";
        String elemento2 = "B";
        String elemento3 = "H";
        String elemento4 = "A";
        String elemento5 = "C";
        String elemento6 = "N";
        String elemento7 = "L";
        String elemento8 = "D";
        String elemento9 = "R";
        String elemento10 = "E";
                
        cola.encolar(elemento1);
        cola.encolar(elemento2);
        cola.encolar(elemento3);
        cola.encolar(elemento4);
        cola.encolar(elemento5);
        cola.encolar(elemento6);
        cola.encolar(elemento7);
        cola.encolar(elemento8);
        cola.encolar(elemento9);
        cola.encolar(elemento10);
          
        String elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento1, elementoDesencolado);
        assertEquals("No se respetó la prioridad al desencolar el primer elemento.", elemento1, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento2);
        assertEquals("No se respetó la prioridad al desencolar el segundo elemento.", elemento2, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento3);
        assertEquals("No se respetó la prioridad al desencolar el tercer elemento.", elemento3, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento4);
        assertEquals("No se respetó la prioridad al desencolar el cuarto elemento.", elemento4, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento5);
        assertEquals("No se respetó la prioridad al desencolar el quinto elemento.", elemento5, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento6);
        assertEquals("No se respetó la prioridad al desencolar el sexto elemento.", elemento6, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento7);
        assertEquals("No se respetó la prioridad al desencolar el séptimo elemento.", elemento7, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento8);
        assertEquals("No se respetó la prioridad al desencolar el octavo elemento.", elemento8, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento9);
        assertEquals("No se respetó la prioridad al desencolar el noveno elemento.", elemento9, elementoDesencolado);
        
        elementoDesencolado = cola.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento10);
        assertEquals("No se respetó la prioridad al desencolar el décimo elemento.", elemento10, elementoDesencolado);
              
    }

    @Test
    public void testIsVacia() {
        System.out.println("iniciando prueba unitaria del método: isVacia");
        
        Cola<String> cola = new ColaImpl();
        
        String elemento1 = "Z";
        String elemento2 = "B";
        String elemento3 = "H";
        String elemento4 = "A";
        String elemento5 = "C";
        String elemento6 = "N";
        String elemento7 = "L";
        String elemento8 = "D";
        String elemento9 = "R";
        String elemento10 = "E";
        
        assertTrue("la cola sí está vacía, pero el método isVacia retornó falso.", cola.isVacia());
        
        cola.encolar(elemento1);
        cola.encolar(elemento2);
        cola.encolar(elemento3);
        cola.encolar(elemento4);
        cola.encolar(elemento5);
        cola.encolar(elemento6);
        cola.encolar(elemento7);
        cola.encolar(elemento8);
        cola.encolar(elemento9);
        cola.encolar(elemento10);
        
        assertFalse("la cola no está vacía, pero el método isVacia retornó true.", cola.isVacia());     
    }

    @Test
    public void testIsLlena() {
        System.out.println("iniciando prueba unitaria del método: isLlena");
        
        Cola<String> colaDinamica = new ColaImpl();
        Cola<String> colaEstatica = new ColaImpl(5);
        
        String elemento1 = "Z";
        String elemento2 = "B";
        String elemento3 = "H";
        String elemento4 = "A";
        String elemento5 = "C";
        
        assertFalse("la cola dinamica no está llena, pero el método isLlena retornó true.", colaDinamica.isLlena());
        assertFalse("la cola estatica no está llena, pero el método isLlena retornó true.", colaEstatica.isLlena());
        
        colaDinamica.encolar(elemento1);
        colaDinamica.encolar(elemento2);
        colaDinamica.encolar(elemento3);
        colaDinamica.encolar(elemento4);
        colaDinamica.encolar(elemento5);
        
        colaEstatica.encolar(elemento1);
        colaEstatica.encolar(elemento2);
        colaEstatica.encolar(elemento3);
        colaEstatica.encolar(elemento4);
        colaEstatica.encolar(elemento5);

        assertFalse("la cola dinámica no debería estar llena nunca.", colaDinamica.isLlena());        
        assertTrue("la cola estática debería estar llena.", colaEstatica.isLlena());        
    }

    @Test
    public void testVisualizar() throws Exception {
        System.out.println("iniciando prueba unitaria del método: visualizar");
        
        Cola<String> colaDinamica = new ColaImpl();
        
        String elemento1 = "Z";
        String elemento2 = "B";
        String elemento3 = "H";
        String elemento4 = "A";
        String elemento5 = "C";
        String elemento6 = "N";
        String elemento7 = "L";
        String elemento8 = "D";
        String elemento9 = "R";
        String elemento10 = "E";
        
        colaDinamica.encolar(elemento1);
        colaDinamica.encolar(elemento2);
        colaDinamica.encolar(elemento3);
        colaDinamica.encolar(elemento4);
        colaDinamica.encolar(elemento5);
        colaDinamica.encolar(elemento6);
        colaDinamica.encolar(elemento7);
        colaDinamica.encolar(elemento8);
        colaDinamica.encolar(elemento9);
        colaDinamica.encolar(elemento10);
        
        colaDinamica.visualizar(new VisualizarColaEnConsolaImpl());
    }  
}
