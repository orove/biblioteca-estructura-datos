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
import cl.duoc.ded.impl.arbol.visitador.VisitadorEnLista;
import cl.duoc.ded.impl.arbol.ArbolBinarioRecursivoImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Osvaldo Rodríguez
 */
public class TestEliminarElementoArbolBinario {         
    
    private Arbol crearArbolBinario() {
        Arbol<Integer> ab = new ArbolBinarioRecursivoImpl<>();
        
        ab.agregarElemento(33);
        ab.agregarElemento(30);
        ab.agregarElemento(66);
        ab.agregarElemento(29);
        ab.agregarElemento(31);
        ab.agregarElemento(58);
        ab.agregarElemento(75);
        ab.agregarElemento(55);
        ab.agregarElemento(61);
        ab.agregarElemento(62);
               
        return ab;
    }
 
    @Test
    public void eliminarElementoCaso1() {
        //TODO: crear prueba unitaria para eliminar el elemento del caso 1
        
        Arbol<Integer> ab = this.crearArbolBinario();
        
        assertTrue("error al eliminar elemento 31", ab.eliminarElemento(31));
        
        VisitadorEnLista<Integer> lista = new VisitadorEnLista<>();
        ab.recorrerEnOrden(lista);        
        
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 29", lista.getLista().getElemento(0).equals(29));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 30", lista.getLista().getElemento(1).equals(30));        
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 33", lista.getLista().getElemento(2).equals(33));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 55", lista.getLista().getElemento(3).equals(55));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 58", lista.getLista().getElemento(4).equals(58));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 61", lista.getLista().getElemento(5).equals(61));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 62", lista.getLista().getElemento(6).equals(62));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 66", lista.getLista().getElemento(7).equals(66));
        assertTrue("la eliminación de 31 no dejó bien ubicado el elemento 75", lista.getLista().getElemento(8).equals(75));
 
    }
    
    @Test
    public void eliminarElementoCaso2() {
        //TODO: crear prueba unitaria para eliminar el elemento del caso 2
        Arbol<Integer> ab =this.crearArbolBinario();
        
        assertTrue("error al eliminar elemento 58", ab.eliminarElemento(58));
        
        VisitadorEnLista<Integer> lista = new VisitadorEnLista<>();
        ab.recorrerEnOrden(lista);

        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 29", lista.getLista().getElemento(0).equals(29));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 30", lista.getLista().getElemento(1).equals(30));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 31", lista.getLista().getElemento(2).equals(31));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 33", lista.getLista().getElemento(3).equals(33));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 55", lista.getLista().getElemento(4).equals(55));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 61", lista.getLista().getElemento(5).equals(61));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 62", lista.getLista().getElemento(6).equals(62));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 66", lista.getLista().getElemento(7).equals(66));
        assertTrue("la eliminación de 58 no dejó bien ubicado el elemento 75", lista.getLista().getElemento(8).equals(75));
    }
    
    @Test
    public void eliminarElementoCaso3() {
        //TODO: crear prueba unitaria para eliminar el elemento del caso 3
       Arbol<Integer> ab =this.crearArbolBinario();
       
       assertTrue("error al eliminar elemento 66", ab.eliminarElemento(66));       
       
        VisitadorEnLista<Integer> lista = new VisitadorEnLista<>();
        ab.recorrerEnOrden(lista);

        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 29", lista.getLista().getElemento(0).equals(29));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 30", lista.getLista().getElemento(1).equals(30));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 31", lista.getLista().getElemento(2).equals(31));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 33", lista.getLista().getElemento(3).equals(33));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 55", lista.getLista().getElemento(4).equals(55));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 58", lista.getLista().getElemento(5).equals(58));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 61", lista.getLista().getElemento(6).equals(61));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 62", lista.getLista().getElemento(7).equals(62));
        assertTrue("la eliminación de 66 no dejó bien ubicado el elemento 75", lista.getLista().getElemento(8).equals(75));
    }
    
    @Test
    public void eliminarElementoCaso4() {
        //TODO: crear prueba unitaria para eliminar los elementos del caso 5   
        Arbol<Integer> ab = this.crearArbolBinario();
        
        assertTrue("error al eliminar elemento 33", ab.eliminarElemento(33));
        
        VisitadorEnLista<Integer> lista = new VisitadorEnLista<>();        
        ab.recorrerEnOrden(lista);

        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 29", lista.getLista().getElemento(0).equals(29));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 30", lista.getLista().getElemento(1).equals(30));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 31", lista.getLista().getElemento(2).equals(31));        
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 55", lista.getLista().getElemento(3).equals(55));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 58", lista.getLista().getElemento(4).equals(58));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 61", lista.getLista().getElemento(5).equals(61));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 62", lista.getLista().getElemento(6).equals(62));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 66", lista.getLista().getElemento(7).equals(66));
        assertTrue("la eliminación de 33 no dejó bien ubicado el elemento 75", lista.getLista().getElemento(8).equals(75));
    }
    
    @Test
    public void eliminarElementoCaso5() {
        //TODO: crear prueba unitaria para eliminar los elementos del caso 4   
        Arbol<Integer> ab = this.crearArbolBinario();
        
        assertTrue("error al eliminar en cascada elemento 31", ab.eliminarElemento(31));
        assertTrue("error al eliminar en cascada elemento 58", ab.eliminarElemento(58));
        assertTrue("error al eliminar en cascada elemento 66", ab.eliminarElemento(66)); 
        assertTrue("error al eliminar en cascada elemento 33", ab.eliminarElemento(33));
        
        VisitadorEnLista<Integer> lista = new VisitadorEnLista<>();        
        ab.recorrerEnOrden(lista);

        assertTrue("la eliminación en cascada no dejó bien ubicado el elemento 29", lista.getLista().getElemento(0).equals(29));
        assertTrue("la eliminación en cascada no dejó bien ubicado el elemento 30", lista.getLista().getElemento(1).equals(30));                
        assertTrue("la eliminación en cascada no dejó bien ubicado el elemento 55", lista.getLista().getElemento(2).equals(55));        
        assertTrue("la eliminación en cascada no dejó bien ubicado el elemento 61", lista.getLista().getElemento(3).equals(61));
        assertTrue("la eliminación en cascada no dejó bien ubicado el elemento 62", lista.getLista().getElemento(4).equals(62));        
        assertTrue("la eliminación en cascada no dejó bien ubicado el elemento 75", lista.getLista().getElemento(5).equals(75));
    }
    
}
