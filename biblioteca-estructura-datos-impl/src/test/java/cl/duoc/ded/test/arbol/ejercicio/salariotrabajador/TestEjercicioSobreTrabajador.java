/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol.ejercicio.salariotrabajador;

import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.impl.arbol.ArbolBinarioRecursivoImpl;
import cl.duoc.ded.test.arbol.ejercicio.salariotrabajador.comparador.CriterioTrabajadorSalarioAscendente;
import cl.duoc.ded.test.arbol.ejercicio.salariotrabajador.dominio.Trabajador;
import cl.duoc.ded.impl.arbol.visitador.VisitadorEnLista;
import cl.duoc.ded.impl.arbol.visitador.VisitarImprimiendoEnConsola;
import cl.duoc.ded.test.arbol.ejercicio.salariotrabajador.comparador.CriterioTrabajadorSalarioDescendente;
import cl.duoc.ded.impl.lista.ListaEnlazadaSimpleImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Enunciado disponible en el Ambiente Virtual de Aprendizaje.
 * {@link http://campusvirtual.duoc.cl}
 * 
 * @author Osvaldo Rodríguez
 */
public class TestEjercicioSobreTrabajador {
    
    private Lista<Trabajador> generarTrabajadores() {
        Lista<Trabajador> empleados = new ListaEnlazadaSimpleImpl<>();
        Trabajador t;
        
        t = new Trabajador(123L,"Pedro","Pérez",850000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(634L,"Pablo","Poblete",650000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(105L,"Marcelo","Muñoz",1550000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(257L,"Francisco","Fernández",450000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(456L,"Sandra","Silva",1450000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(398L,"José","Jorquera",980000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(845L,"Antonia","Antúnez",1850000);
        empleados.agregarElemento(t);
        
        t = new Trabajador(233L,"Rodrigo","Ramírez",850000);
        empleados.agregarElemento(t);
        
        
        return empleados;
    }
    
    @Test
    public void testIndiceTrabajadoresPorSalarioAscendente() {
        System.out.println("=======================================================");
        System.out.println("Iniciando testIndiceTrabajadoresPorSalarioAscendente");
        
        Arbol<Trabajador> ab = new ArbolBinarioRecursivoImpl<>(new CriterioTrabajadorSalarioAscendente());
        
        Lista<Trabajador> trabajadores = this.generarTrabajadores();
        
        for(Trabajador x: trabajadores) {
            ab.agregarElemento(x);
        }
        
        VisitadorEnLista<Trabajador> listaRecorrido =  new VisitadorEnLista();
        ab.recorrerEnOrden(listaRecorrido);
        ab.recorrerEnOrden(new VisitarImprimiendoEnConsola());
        
        Integer menorSalario = listaRecorrido.getLista().getElemento(0).getSalario();
        
        for(Trabajador x: listaRecorrido.getLista()) {
            assertTrue("el trabajador "+x+" no está en el orden requerido", x.getSalario().compareTo(menorSalario) >= 0);
        }
    }
    
    
    @Test
    public void testIndiceTrabajadoresPorSalarioDescendente() {
        System.out.println("=======================================================");
        System.out.println("Iniciando testIndiceTrabajadoresPorSalarioDescendente");
        Arbol<Trabajador> arbolBinario = new ArbolBinarioRecursivoImpl<>(new CriterioTrabajadorSalarioDescendente());
        
        Lista<Trabajador> trabajadores = this.generarTrabajadores();
        
        for(Trabajador trabajador: trabajadores){
            arbolBinario.agregarElemento(trabajador);
        }
        
        VisitadorEnLista<Trabajador> trabajadoresOrdenadosPorSalarioDescendente = new VisitadorEnLista();
        arbolBinario.recorrerEnOrden(trabajadoresOrdenadosPorSalarioDescendente);
        arbolBinario.recorrerEnOrden(new VisitarImprimiendoEnConsola());
        
        Integer salario = trabajadoresOrdenadosPorSalarioDescendente.getLista().getElemento(0).getSalario();
        
        for(Trabajador trabajador: trabajadoresOrdenadosPorSalarioDescendente.getLista()){
            assertTrue("el trabajador "+trabajador+" no está en el orden requerido", trabajador.getSalario().compareTo(salario) <= 0);
            salario = trabajador.getSalario();
        }
    }
}
