/**
 * DUOC UC
 * Escuela de Inform&acute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol;

import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.api.util.Visitador;

/**
 *
 * @author nombre del alumno
 * @version 1.0
 * @param <T> Tipo de dato del elemento a almacenar en el &acute;rbol.
 */
public class ArbolNarioImpl<T extends Comparable> implements Arbol<T> {

    @Override
    public void recorrerEnPreOrden(Visitador<T> operacion) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public void recorrerEnPostOrden(Visitador<T> operacion) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public void recorrerEnOrden(Visitador<T> operacion) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public void recorrerEnAmplitud(Visitador<T> operacion) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public void agregarElemento(T nuevoElemento) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public boolean eliminarElemento(T elemento) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public boolean existe(T elemento) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public boolean isPodado() {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public boolean isPerfecto() {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public boolean isEquilibrado(int tolerancia) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public int getPeso() {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public int getAltura() {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public Lista<T> getCamino(T destino) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }

    @Override
    public void visualizar(Visualizable<Arbol> visor) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }
    
}
