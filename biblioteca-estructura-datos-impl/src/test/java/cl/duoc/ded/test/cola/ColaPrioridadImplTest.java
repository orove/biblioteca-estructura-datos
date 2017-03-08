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

import cl.duoc.ded.api.ColaPrioridad;
import cl.duoc.ded.api.ColaPrioridad.Prioridad;
import cl.duoc.ded.impl.cola.ColaPrioridadImpl;
import cl.duoc.ded.impl.cola.visor.VisualizarColaPrioridadEnConsolaImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Osvaldo Rodr&iacute;guez
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 */
public class ColaPrioridadImplTest {
    

    @Test
    public void testEncolarEnColaDinamica() {
        System.out.println("iniciando prueba unitaria del método: encolar");
        
        ColaPrioridad<String> colaPrioridad = new ColaPrioridadImpl();
        
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
        
        assertTrue("la cola sí está vacía, pero el método isVacia retornó falso.", colaPrioridad.isVacia());
        
        colaPrioridad.encolar(elemento1,Prioridad.BAJA);
        colaPrioridad.encolar(elemento2,Prioridad.ALTA);
        colaPrioridad.encolar(elemento3,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento4,Prioridad.ALTA);
        colaPrioridad.encolar(elemento5,Prioridad.ALTA);
        colaPrioridad.encolar(elemento6,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento7,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento8,Prioridad.ALTA);
        colaPrioridad.encolar(elemento9,Prioridad.BAJA);
        colaPrioridad.encolar(elemento10,Prioridad.ALTA);
        
        assertFalse("la cola no puede estar llena ya que es dinámica.", colaPrioridad.isLlena());
        assertFalse("la cola no está vacía, pero el método isVacia retornó true.", colaPrioridad.isVacia());
        
        String elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento2, elementoDesencolado);
        assertEquals("No se respetó la prioridad al desencolar el primer elemento.", elemento2, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento4);
        assertEquals("No se respetó la prioridad al desencolar el segundo elemento.", elemento4, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento5);
        assertEquals("No se respetó la prioridad al desencolar el tercer elemento.", elemento5, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento8);
        assertEquals("No se respetó la prioridad al desencolar el cuarto elemento.", elemento8, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento10);
        assertEquals("No se respetó la prioridad al desencolar el quinto elemento.", elemento10, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento3);
        assertEquals("No se respetó la prioridad al desencolar el sexto elemento.", elemento3, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento6);
        assertEquals("No se respetó la prioridad al desencolar el séptimo elemento.", elemento6, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento7);
        assertEquals("No se respetó la prioridad al desencolar el octavo elemento.", elemento7, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento1);
        assertEquals("No se respetó la prioridad al desencolar el noveno elemento.", elemento1, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento9);
        assertEquals("No se respetó la prioridad al desencolar el décimo elemento.", elemento9, elementoDesencolado);
              
    }
    
    
    @Test
    public void testEncolarEnColaEstatica() {
        System.out.println("iniciando prueba unitaria del método: encolar");
        
        ColaPrioridad<String> colaPrioridad = new ColaPrioridadImpl(10);
        
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
        
        assertTrue("la cola sí está vacía, pero el método isVacia retornó falso.", colaPrioridad.isVacia());
        
        colaPrioridad.encolar(elemento1,Prioridad.BAJA);
        colaPrioridad.encolar(elemento2,Prioridad.ALTA);
        colaPrioridad.encolar(elemento3,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento4,Prioridad.ALTA);
        colaPrioridad.encolar(elemento5,Prioridad.ALTA);
        colaPrioridad.encolar(elemento6,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento7,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento8,Prioridad.ALTA);
        colaPrioridad.encolar(elemento9,Prioridad.BAJA);
        colaPrioridad.encolar(elemento10,Prioridad.ALTA);
        
        assertTrue("la cola sí está llena.", colaPrioridad.isLlena());
        assertFalse("la cola no está vacía, pero el método isVacia retornó true.", colaPrioridad.isVacia());
        
        String elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento2, elementoDesencolado);
        assertEquals("No se respetó la prioridad al desencolar el primer elemento.", elemento2, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento4);
        assertEquals("No se respetó la prioridad al desencolar el segundo elemento.", elemento4, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento5);
        assertEquals("No se respetó la prioridad al desencolar el tercer elemento.", elemento5, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento8);
        assertEquals("No se respetó la prioridad al desencolar el cuarto elemento.", elemento8, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento10);
        assertEquals("No se respetó la prioridad al desencolar el quinto elemento.", elemento10, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento3);
        assertEquals("No se respetó la prioridad al desencolar el sexto elemento.", elemento3, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento6);
        assertEquals("No se respetó la prioridad al desencolar el séptimo elemento.", elemento6, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento7);
        assertEquals("No se respetó la prioridad al desencolar el octavo elemento.", elemento7, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento1);
        assertEquals("No se respetó la prioridad al desencolar el noveno elemento.", elemento1, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento9);
        assertEquals("No se respetó la prioridad al desencolar el décimo elemento.", elemento9, elementoDesencolado);
              
    }
    
    
    @Test
    public void testEncolarEnColaDinamicaConcurrente() {
        System.out.println("iniciando prueba unitaria del método: encolar");
        
        ColaPrioridad<String> colaPrioridad = new ColaPrioridadImpl();
        
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
        
        assertTrue("la cola sí está vacía, pero el método isVacia retornó falso.", colaPrioridad.isVacia());
        
        colaPrioridad.encolar(elemento1,Prioridad.BAJA);
        colaPrioridad.encolar(elemento2,Prioridad.ALTA);
        colaPrioridad.encolar(elemento3,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento4,Prioridad.ALTA);
        colaPrioridad.encolar(elemento5,Prioridad.ALTA);
        colaPrioridad.encolar(elemento6,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento7,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento8,Prioridad.ALTA);
        colaPrioridad.encolar(elemento9,Prioridad.BAJA);
        colaPrioridad.encolar(elemento10,Prioridad.ALTA);
        
        assertFalse("la cola no puede estar llena ya que es dinámica.", colaPrioridad.isLlena());
        assertFalse("la cola no está vacía, pero el método isVacia retornó true.", colaPrioridad.isVacia());
        
        String elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento2, elementoDesencolado);
        assertEquals("No se respetó la prioridad al desencolar el primer elemento.", elemento2, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento4);
        assertEquals("No se respetó la prioridad al desencolar el segundo elemento.", elemento4, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento5);
        assertEquals("No se respetó la prioridad al desencolar el tercer elemento.", elemento5, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento8);
        assertEquals("No se respetó la prioridad al desencolar el cuarto elemento.", elemento8, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento10);
        assertEquals("No se respetó la prioridad al desencolar el quinto elemento.", elemento10, elementoDesencolado);
        
        colaPrioridad.encolar(elemento4,Prioridad.ALTA);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento4);
        assertEquals("No se respetó la prioridad al desencolar el elemento recien encolado con prioridad Alta.", elemento4, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento3);
        assertEquals("No se respetó la prioridad al desencolar el sexto elemento.", elemento3, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento6);
        assertEquals("No se respetó la prioridad al desencolar el séptimo elemento.", elemento6, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento7);
        assertEquals("No se respetó la prioridad al desencolar el octavo elemento.", elemento7, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento1);
        assertEquals("No se respetó la prioridad al desencolar el noveno elemento.", elemento1, elementoDesencolado);
        
        elementoDesencolado = colaPrioridad.desencolar();
        assertNotNull("La cola devolvió un elemento nulo cuando se esperaba "+elemento9);
        assertEquals("No se respetó la prioridad al desencolar el décimo elemento.", elemento9, elementoDesencolado);
              
    }
    
    
    @Test
    public void testVisualizar() throws Exception {
        System.out.println("iniciando prueba unitaria del método: visualizar");
        
        ColaPrioridad<String> colaPrioridad = new ColaPrioridadImpl();
        
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
        
        assertTrue("la cola sí está vacía, pero el método isVacia retornó falso.", colaPrioridad.isVacia());
        
        colaPrioridad.encolar(elemento1,Prioridad.BAJA);
        colaPrioridad.encolar(elemento2,Prioridad.ALTA);
        colaPrioridad.encolar(elemento3,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento4,Prioridad.ALTA);
        colaPrioridad.encolar(elemento5,Prioridad.ALTA);
        colaPrioridad.encolar(elemento6,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento7,Prioridad.NORMAL);
        colaPrioridad.encolar(elemento8,Prioridad.ALTA);
        colaPrioridad.encolar(elemento9,Prioridad.BAJA);
        colaPrioridad.encolar(elemento10,Prioridad.ALTA);
        
        colaPrioridad.visualizar(new VisualizarColaPrioridadEnConsolaImpl());
    }
}
