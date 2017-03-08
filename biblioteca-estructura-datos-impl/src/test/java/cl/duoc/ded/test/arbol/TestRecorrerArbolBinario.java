/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol;

import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.impl.arbol.visitador.VisitarApilando;
import cl.duoc.ded.impl.arbol.visitador.VisitadorEnLista;
import cl.duoc.ded.exception.ElementoNuloException;
import cl.duoc.ded.impl.arbol.ArbolBinarioRecursivoImpl;
import cl.duoc.ded.impl.arbol.visitador.VisitarEncolando;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Osvaldo Rodríguez
 */
public class TestRecorrerArbolBinario {         
    
    private Arbol crearArbolBinario() {
        Arbol<Integer> ab = new ArbolBinarioRecursivoImpl<>();
    
        assertNotNull("El árbol binario no ha sido instanciado correctamente", ab);
        
        ab.agregarElemento(6);
        ab.agregarElemento(5);
        ab.agregarElemento(2);
        ab.agregarElemento(4);
        ab.agregarElemento(1);
        ab.agregarElemento(7);
        ab.agregarElemento(3);
        
        return ab;
    }
    
    @Test(expected=ElementoNuloException.class)
    public void testAgregarExceptionArbolBinario() {
        
        Arbol<Integer> ab = new ArbolBinarioRecursivoImpl<>();    
        assertNotNull("El árbol binario no ha sido instanciado correctamente", ab);
        
        ab.agregarElemento(null);
    }
    
    @Test
    public void testRecorridoEnOrden() {
        
        Arbol<Integer> ab = crearArbolBinario();

        VisitadorEnLista<Integer> comando =  new VisitadorEnLista();
        
        ab.recorrerEnOrden(comando); 
        
        Integer menorSalario = comando.getLista().getElemento(0);
        
        for(Integer x: comando.getLista()) {
            System.out.println(menorSalario+" <= "+x);
            assertTrue("el elemento no esta en el orden requerido", x >= menorSalario);
            menorSalario = x;
        }
    }
    
    @Test
    public void testRecorridoEnPreOrden() {
        
        Arbol<Integer> ab = crearArbolBinario();

        VisitarApilando<Integer> apilarRecorrido =  new VisitarApilando();
        
        ab.recorrerEnPreOrden(apilarRecorrido); 
       
        assertEquals(7, apilarRecorrido.getPila().pop());
        assertEquals(3, apilarRecorrido.getPila().pop());
        assertEquals(4, apilarRecorrido.getPila().pop());
        assertEquals(1, apilarRecorrido.getPila().pop());
        assertEquals(2, apilarRecorrido.getPila().pop());
        assertEquals(5, apilarRecorrido.getPila().pop());
        assertEquals(6, apilarRecorrido.getPila().pop());
      
    }
       
    @Test
    public void testRecorridoEnPostOrden() {
        
        Arbol<Integer> ab = crearArbolBinario();

        VisitarApilando<Integer> apilarRecorrido =  new VisitarApilando();
        
        ab.recorrerEnPostOrden(apilarRecorrido); 
     
        assertEquals(new Integer(6), apilarRecorrido.getPila().pop());
        assertEquals(new Integer(7), apilarRecorrido.getPila().pop());
        assertEquals(new Integer(5), apilarRecorrido.getPila().pop());
        assertEquals(new Integer(2), apilarRecorrido.getPila().pop());
        assertEquals(new Integer(4), apilarRecorrido.getPila().pop());
        assertEquals(new Integer(3), apilarRecorrido.getPila().pop());
        assertEquals(new Integer(1), apilarRecorrido.getPila().pop());
      
    }
    
    @Test
    public void testRecorridoEnAmplitud() {
        
        Arbol<Integer> ab = crearArbolBinario();

        VisitarEncolando<Integer> encolarRecorrido =  new VisitarEncolando();
        
        ab.recorrerEnAmplitud(encolarRecorrido); 
     
        assertEquals(6, encolarRecorrido.getCola().desencolar());   
        assertEquals(5, encolarRecorrido.getCola().desencolar());
        assertEquals(7, encolarRecorrido.getCola().desencolar());
        assertEquals(2, encolarRecorrido.getCola().desencolar());
        assertEquals(1, encolarRecorrido.getCola().desencolar());
        assertEquals(4, encolarRecorrido.getCola().desencolar());
      
    }
   
}
