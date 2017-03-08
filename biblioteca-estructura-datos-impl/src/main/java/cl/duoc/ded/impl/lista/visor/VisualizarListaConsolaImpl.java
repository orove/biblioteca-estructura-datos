/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.lista.visor;

import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;

/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * que permite visualizar el contenido de una Lista en la consola (salida est&aacute;ndar).
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0.
 */
public class VisualizarListaConsolaImpl implements Visualizable<Lista> {

    @Override
    public void ver(Lista lista) {
        
        System.out.println("================================================");
        System.out.println("Visualizando Lista["+lista.getTotalElementos()+"] por Consola");
        System.out.println("------------------------------------------------");
        
        for(int i=0; i<lista.getTotalElementos(); i++) {
            System.out.println("elemento["+(i+1)+"]: "+lista.getElemento(i));
        }
    }
    
}
