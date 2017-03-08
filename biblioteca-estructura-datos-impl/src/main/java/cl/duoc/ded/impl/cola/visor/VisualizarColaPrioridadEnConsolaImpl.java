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
import cl.duoc.ded.api.ColaPrioridad;
import cl.duoc.ded.api.ColaPrioridad.Prioridad;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.ArgumentoInvalidoException;
import cl.duoc.ded.exception.VisorException;
import cl.duoc.ded.impl.cola.ColaPrioridadImpl;

import java.lang.reflect.Field;
/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * para poder visualizar el contenido de una Cola de Prioridad por la consola 
 * (salida est&aacute;ndar).
 * 
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0.
 */
public class VisualizarColaPrioridadEnConsolaImpl implements Visualizable<Cola> {

    @Override
    public void ver(Cola cola) throws VisorException{
                
        System.out.println("================================================");
        System.out.println("Visualizando Cola de Prioridad en Consola");
        System.out.println("------------------------------------------------");
        
        if(!(cola instanceof ColaPrioridad)) {
            throw new ArgumentoInvalidoException("El argumento recibido por el visor no contiene una Cola de Prioridad");
        }
              
        ColaPrioridad colaPrioridad = (ColaPrioridad)cola;
        
        try {
            ColaPrioridad copiaElementos = this.copiarCola(colaPrioridad);               
            System.out.println("  [PRIORIDAD] [ELEMENTO]");
            while(!copiaElementos.isVacia()) {
                System.out.println("  "+copiaElementos.desencolar());
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
    private ColaPrioridad copiarCola(ColaPrioridad cola) throws Exception {
        ColaPrioridad<String> copia = new ColaPrioridadImpl();
        
        Field fieldElemento = ColaPrioridadImpl.class.getDeclaredField("listaElementos");
        Field fieldPrioridad = ColaPrioridadImpl.class.getDeclaredField("listaPrioridades");
        
        fieldElemento.setAccessible(true);                
        Lista listaElementos = (Lista)fieldElemento.get(cola);
        
        fieldPrioridad.setAccessible(true);                
        Lista listaPrioridades = (Lista)fieldPrioridad.get(cola);
        
        String simboloPrioridad;
        Prioridad prioridad;

        for(int i=0; i < listaElementos.getTotalElementos() ; i++) {
            prioridad = (Prioridad)listaPrioridades.getElemento(i); 
            //simboloPrioridad = (Prioridad.ALTA.equals(prioridad))? "▲": (Prioridad.BAJA.equals(prioridad)? "▼":"►");
            simboloPrioridad = (Prioridad.ALTA.equals(prioridad))? "[ ! ]": (Prioridad.BAJA.equals(prioridad)? "[ - ]":"[ N ]");
            copia.encolar("  "+simboloPrioridad+"        ["+listaElementos.getElemento(i).toString()+"]", prioridad);
        }
        
        return copia;
    }        
    
}
