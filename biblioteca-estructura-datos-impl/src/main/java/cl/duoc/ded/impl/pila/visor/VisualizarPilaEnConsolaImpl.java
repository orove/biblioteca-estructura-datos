/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.pila.visor;

import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.Pila;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.impl.pila.PilaImpl;
import java.lang.reflect.Field;

/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * para poder visualizar el contenido de una Pila por la consola (salida est&aacute;ndar).
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0.
 */
public class VisualizarPilaEnConsolaImpl implements Visualizable<Pila> {

    @Override
    public void ver(Pila pila) throws VisorException{
                
        System.out.println("================================================");
        System.out.println("Visualizando Pila en Consola");
        System.out.println("------------------------------------------------");
        
        try {
            Pila p = this.copiarPila(pila);
            
            // sólo para imprimir el último elemento, el cual es el tope
            // de la pila.
            if(!p.isVacia()) {
                System.out.println(" tope -> ["+p.pop()+"]");
            }
            
            // si existen más elementos, se imprimen en este bucle.
            while(!p.isVacia()) {
                System.out.println("         ["+p.pop()+"]");
            }
        } catch (Exception ex) {
            throw new VisorException("no se pudo visualizar el contenido de la pila: "+ex.getMessage(), ex);
        }
        
    }
    
    /**
     * M&eacute;todo que permite crear una nueva Pila a partir del contenido 
     * de otra sin modificar el contenido de esta &uacute;litima, utilizando 
     * la API Reflection que provee java desde su versi&oacute;n 1.5.
     * 
     * @param pila Pila original
     * @return Pila clonada.
     * @throws Exception 
     */
    private Pila copiarPila(Pila pila) throws Exception {
        Pila p = new PilaImpl();
        
        Field field = PilaImpl.class.getDeclaredField("lista");
        field.setAccessible(true);                
        Lista lista = (Lista)field.get(pila);

        for(Object elemento: lista) {
            p.push(elemento);
        }
        
        return p;
    }    
}
