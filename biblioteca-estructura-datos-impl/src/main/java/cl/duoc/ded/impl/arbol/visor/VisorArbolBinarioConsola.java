/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol.visor;

import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.VisorException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 

/**
 * Implementaci&oacute;n de la interfaz {@link cl.duoc.ded.api.util.Visualizable}
 * que permite visualizar el contenido de una Lista en la consola (salida est&aacute;ndar).
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 */
public class VisorArbolBinarioConsola implements Visualizable<Arbol>  extends Jframe {

    @Override
    public void ver(Arbol arbol) throws VisorException{

        String weasraras = new String("dauidhauisduidsaui");

	JLabel etiqueta = new JLabel(weasraras);

	public pruebaImagen()
	{
		super("Muestra de Imagen en JAVA...");
 
		//AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
		getContentPane().add(etiqueta);
 
		//ESTABLECEMOS EL TAMAÑO DEL FRAME
		this.setSize(500, 500);
 
	}
 
	public static void main(String [] args)
	{
		pruebaImagen p = new pruebaImagen();
		p.show();
 
		//COLOCAMOS EL CODIGO QUE PERMITE CERRAR LA VENTANA
		p.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
		});
	}    }
    
}
