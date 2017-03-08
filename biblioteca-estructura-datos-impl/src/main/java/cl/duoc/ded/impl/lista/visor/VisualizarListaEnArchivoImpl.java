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
import cl.duoc.ded.exception.VisorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * que permite visualizar el contenido de una Lista en un archivo.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class VisualizarListaEnArchivoImpl implements Visualizable<Lista> {
    private final String uri;
    private Path ruta;
    
    public VisualizarListaEnArchivoImpl(String rutaArchivo) {
        this.uri = rutaArchivo;
    }
    
    @Override
    public void ver(Lista lista) throws VisorException {
        StringBuilder texto = new StringBuilder();
        
        try {
            this.ruta = Paths.get(this.uri);
            
            texto.append("================================================\n");
            texto.append("Mostrando Lista de ");
            texto.append(lista.getTotalElementos());
            texto.append(" elementos\n");
            texto.append("------------------------------------------------\n");

            for(int i=0; i<lista.getTotalElementos(); i++) {
                texto.append("elemento[");
                texto.append((i+1));
                texto.append("]: ");
                texto.append(lista.getElemento(i));
                texto.append("\n");
            }
            
            Files.write(this.ruta, 
                        texto.toString().getBytes("utf-8"), 
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.TRUNCATE_EXISTING);
        } catch(Exception e) {
            throw new VisorException("no se pudo guardar en el archivo la visualización del contenido de la lista: "+e,e);
        }
    }
    
}
