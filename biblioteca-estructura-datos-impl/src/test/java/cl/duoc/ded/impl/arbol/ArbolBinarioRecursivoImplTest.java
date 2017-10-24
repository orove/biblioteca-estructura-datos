/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.ded.impl.arbol;

import cl.duoc.ded.api.Arbol;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CETECOM
 */
public class ArbolBinarioRecursivoImplTest {
    
    public ArbolBinarioRecursivoImplTest() {
    }

    @Test
    public void testEqualsOk() {
        Arbol<String> a = new ArbolBinarioRecursivoImpl();
        Arbol<String> b = new ArbolBinarioRecursivoImpl();
        
        a.agregarElemento("A");
        a.agregarElemento("B");
        a.agregarElemento("C");
        a.agregarElemento("D");
        a.agregarElemento("E");
        a.agregarElemento("F");
        
        b.agregarElemento("A");
        b.agregarElemento("B");
        b.agregarElemento("C");
        b.agregarElemento("D");
        b.agregarElemento("E");
        b.agregarElemento("F");
        
        assertTrue("El método equals del árbol no está detectando 2 árboles iguales", a.equals(b));
    }
    
    @Test
    public void testEqualsOk2() {
        Arbol<Integer> a = new ArbolBinarioRecursivoImpl();
        Arbol<Integer> b = new ArbolBinarioRecursivoImpl();
        
        a.agregarElemento(50);
        a.agregarElemento(25);
        a.agregarElemento(10);
        a.agregarElemento(30);
        a.agregarElemento(80);
        a.agregarElemento(60);
        
        b.agregarElemento(50);
        b.agregarElemento(25);
        b.agregarElemento(10);
        b.agregarElemento(30);
        b.agregarElemento(80);
        b.agregarElemento(60);
        
        assertTrue("El método equals del árbol no está detectando 2 árboles iguales", a.equals(b));
    }
    
    @Test
    public void testEqualsFalse() {
        Arbol<String> a = new ArbolBinarioRecursivoImpl();
        Arbol<String> b = new ArbolBinarioRecursivoImpl();
        
        a.agregarElemento("A");
        a.agregarElemento("B");
        a.agregarElemento("C");
        a.agregarElemento("D");
        a.agregarElemento("E");
        
        b.agregarElemento("A");
        b.agregarElemento("B");
        b.agregarElemento("C");
        b.agregarElemento("D");
        b.agregarElemento("E");
        b.agregarElemento("F");
        
        assertFalse("El método equals del árbol no está detectando 2 árboles iguales", a.equals(b));
    }
    
}
