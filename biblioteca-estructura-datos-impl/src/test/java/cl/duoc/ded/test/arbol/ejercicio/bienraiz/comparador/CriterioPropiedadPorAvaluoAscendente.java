/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol.ejercicio.bienraiz.comparador;

import cl.duoc.ded.test.arbol.ejercicio.bienraiz.dominio.BienRaiz;

import java.util.Comparator;


public class CriterioPropiedadPorAvaluoAscendente implements Comparator<BienRaiz>{

    @Override
    public int compare(BienRaiz o1, BienRaiz o2) {
        return o1.getAvaluo().compareTo(o2.getAvaluo());
    }
    
    
}
