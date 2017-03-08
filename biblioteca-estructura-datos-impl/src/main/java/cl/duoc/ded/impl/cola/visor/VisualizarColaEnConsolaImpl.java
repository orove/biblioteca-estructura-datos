/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.cola.visor;

import cl.duoc.ded.api.Cola;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.impl.cola.ColaImpl;
import java.lang.reflect.Field;
/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * para poder visualizar el contenido de una Cola por la consola (salida est&aacute;ndar).
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0.
 */
public class VisualizarColaEnConsolaImpl implements Visualizable<Cola> {

    @Override
    public void ver(Cola cola) throws VisorException{
                
        System.out.println("================================================");
        System.out.println("Visualizando Cola por Consola");
        System.out.println("------------------------------------------------");
        
        try {
            Cola colaCopiada = this.copiarCola(cola);         
            
            // si existen más elementos, se imprimen en este bucle.
            while(!colaCopiada.isVacia()) {
                System.out.println("         ["+colaCopiada.desencolar()+"]");
            }
        } catch (Exception ex) {
            throw new VisorException("no se pudo visualizar el contenido de la cola: "+ex.getMessage(), ex);
        }
        
    }
    
    /**
     * M&eacute;todo que permite crear una nueva Cola a partir del contenido 
     * de otra sin modificar el contenido de esta &uacute;litima utilizando 
     * la API Reflection que provee java desde su versi&oacute;n 1.5.
     * 
     * @param cola Cola original
     * @return Cola copiada.
     * @throws Exception 
     */
    private Cola copiarCola(Cola cola) throws Exception {
        Cola p = new ColaImpl();
        
        Field field = ColaImpl.class.getDeclaredField("lista");
        field.setAccessible(true);                
        Lista lista = (Lista)field.get(cola);

        for(int i=0; i < lista.getTotalElementos() ; i++) {
            p.encolar(lista.getElemento(i));
        }
        
        return p;
    } 
    
}
