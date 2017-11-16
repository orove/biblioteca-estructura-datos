/**
 * DUOC UC
 * Escuela de Inform&aacute;tica y Telecomunicaciones
 * Sede Padre Alonso de Ovalle
 * 
 * Dise&ntilde;o de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.impl.arbol;

import cl.duoc.ded.impl.arbol.nodo.NodoArbolBinario;
import cl.duoc.ded.api.Arbol;
import cl.duoc.ded.api.Lista;
import cl.duoc.ded.api.util.Visualizable;
import cl.duoc.ded.exception.ArgumentoInvalidoException;
import cl.duoc.ded.exception.ElementoNuloException;
import java.util.Comparator;
import cl.duoc.ded.api.util.Visitador;
import cl.duoc.ded.api.Cola;
import cl.duoc.ded.impl.arbol.visitador.VisitadorEnLista;
import cl.duoc.ded.impl.cola.ColaImpl;
import cl.duoc.ded.impl.lista.ListaEnlazadaSimpleImpl;
import java.util.Objects;



/**
 *
 * Implementaci&oacute;n recursiva de un &aacute;rbol binario de b&uacute;squeda.
 * @author Osvaldo Rodr&iacute;guez 
 * &lt;<a href="mailto:o.rodriguezv@profesor.duoc.cl">o.rodriguezv@profesor.duoc.cl</a>&gt;
 * @version 1.0
 * @param <T> Tipo de dato de los elementos que manipular&aacute;a el &aacute;rbol, debe implementar
 *            la interfaz Comparable.
 */
public class ArbolBinarioRecursivoImpl<T extends Comparable> implements Arbol<T> {
    
    /**
     * nodo inicial para recorrer el árbol.
     */
    protected NodoArbolBinario<T> raiz;
    
    /**
     * acción a ejecutar cuando se visita el nodo.
     */
    protected Visitador operacionAlVisitarElemento;
    
    /**
     * comparador de elementos utilizado al momento
     * de agregar un elemento al árbol binario.
     */
    protected final Comparator criterioComparacion;
    
    /**
     * N&uacute;mero de elementos ingresados en el &aacute;rbol.
     */
    private Integer numeroElementos = 0;
    
    /**
     * Número de comparación que permite saber cuando el arbol será rebalanceado.
     * Por defecto comienza en 50.
     */
    private Integer cantidadElementosRebalanceo = 50;
    
    /**
     * Contador de elementos ingresados y/o eliminados, que determina si el
     * el arbol será rebalanceado.
     */
    private Integer contadorElementosRebalanceo = 0;
    
    /**
     * Constructor por defecto que utiliza para la comparación
     * la interfaz comparable que debe tener implementada el elemento T
     * que manejará el árbol binario.
     */
    public ArbolBinarioRecursivoImpl() {
        // se implementa en una clase anónima la interfaz Comparator para el 
        // comparador de comparación por defecto que utilizará el árbol.
        this.criterioComparacion = new Comparator<T>() {
            @Override
            public int compare(T elemento1, T elemento2) {
                // se utiliza el método de la interfaz Comparable, el cual debe
                // estar implementado en los elementos de tipo T
                return elemento1.compareTo(elemento2);
            }
        };
    }
    
    /**
     * Constructor que recibe un comparador de comparaci&oacute;n para ser utilizado por el
     * &aacute;rbol binario cuando se agreguen elementos.
     * @param criterio Objeto con implementaci&oacute;n de la interfaz {@link java.util.Comparator}
     */
    public ArbolBinarioRecursivoImpl(Comparator criterio) {
        if(criterio == null) {
            throw new ArgumentoInvalidoException("el comparador de comparación no puede ser nulo");
        }
        
        this.criterioComparacion = criterio;
    }
    
        
    @Override
    public void recorrerEnPreOrden(Visitador<T> operacion) {
        
        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operación sobre el elemento no está definida");
        }
        
        this.operacionAlVisitarElemento = operacion;
        this.preOrden(this.raiz);
    }
    
        
    @Override
    public void recorrerEnPostOrden(Visitador<T> operacion) {
        
        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operación sobre el elemento no está definida");
        }
        
        this.operacionAlVisitarElemento = operacion;
        this.postOrden(this.raiz);
    }
    
 
    @Override
    public void recorrerEnOrden(Visitador<T> operacion) {
        
        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operación sobre el elemento no está definida");
        }
        
        this.operacionAlVisitarElemento = operacion;
        this.inOrden(this.raiz);
    }    
      
    
    @Override
    public void recorrerEnAmplitud(Visitador<T> operacion) {

        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operación sobre el elemento no está definida");
        }

        this.operacionAlVisitarElemento = operacion;
        this.enAmplitud(this.raiz);    
    }
      
    
    @Override
    public synchronized void agregarElemento(T nuevoElemento) {
        
        if(nuevoElemento == null) {
            throw new ElementoNuloException("no se puede agregar elementos nulos al árbol binario");
        }

        NodoArbolBinario<T> nuevoNodo = new NodoArbolBinario<>();
        nuevoNodo.setElemento(nuevoElemento);
        
        if(this.raiz == null) {
            this.raiz = nuevoNodo;
        } else {            
            this.agregar(nuevoNodo,this.raiz);            
        }
        
        this.numeroElementos++;
        
        this.verificarRebalanceoPorCantidadElementosIngresados();
    }
    
    
    @Override
    public boolean existe(T elemento) {
        
        if(this.raiz != null) {
            return(this.existe(this.raiz, elemento));
        }
        
        return false;
    }
    
    
    @Override
    public synchronized boolean eliminarElemento(T elemento) {
        
        if(!this.existe(elemento)) {
            return false;            
        }
        
        if(this.criterioComparacion.compare(this.raiz.getElemento(), elemento) == 0) {
            NodoArbolBinario<T> nodo = new NodoArbolBinario();
            nodo.setRamaIzquierda(this.raiz);
            this.eliminar(elemento, this.raiz, nodo);
            this.raiz = nodo.getRamaIzquierda();            
        } else {
            this.eliminar(elemento, this.raiz, null);                
        }
        
        this.numeroElementos--;
        
        return true;
        
    }

    protected void agregar(NodoArbolBinario<T> nuevo, NodoArbolBinario<T> nodoActual) {
        
        if(this.criterioComparacion.compare(nuevo.getElemento(), nodoActual.getElemento()) > 0) {
            if(nodoActual.getRamaDerecha() == null) {
                nodoActual.setRamaDerecha(nuevo);
            } else {
                agregar(nuevo, nodoActual.getRamaDerecha());
            }
        } else if(this.criterioComparacion.compare(nuevo.getElemento(), nodoActual.getElemento()) <= 0) {
            if(nodoActual.getRamaIzquierda() == null) {
                nodoActual.setRamaIzquierda(nuevo);
            } else {
                agregar(nuevo, nodoActual.getRamaIzquierda()); 
            }
        }
    }
    
    private void preOrden(NodoArbolBinario<T> nodo) {
        
        if(nodo == null) {
            return;
        }
        
        this.operacionAlVisitarElemento.visitar(nodo.getElemento());        
        preOrden(nodo.getRamaIzquierda());       
        preOrden(nodo.getRamaDerecha());
    }
    
        
    private void inOrden(NodoArbolBinario<T> nodo) {
        
        if(nodo == null) {
            return;
        }
        
        inOrden(nodo.getRamaIzquierda());
        this.operacionAlVisitarElemento.visitar(nodo.getElemento());        
        inOrden(nodo.getRamaDerecha());        
    }
        
    
    private void postOrden(NodoArbolBinario<T> nodo) {
        
        if(nodo == null) {
            return;
        }
        
        postOrden(nodo.getRamaIzquierda());
        postOrden(nodo.getRamaDerecha());
        this.operacionAlVisitarElemento.visitar(nodo.getElemento());        
    }
    
    
    private void enAmplitud(NodoArbolBinario<T> nodo) {
        
        Cola<NodoArbolBinario> cola = new ColaImpl<>();
        NodoArbolBinario<T> auxNodo; 

        if(nodo == null) {
            return;
        }

        cola.encolar(nodo); 

        while (!cola.isVacia()){ 
            // se desencola el primer nodo para  luego encolar sus ramas
            auxNodo = cola.desencolar();

            // se visita el elemento contenido en el nodo
            this.operacionAlVisitarElemento.visitar(auxNodo.getElemento());

            if (auxNodo.getRamaIzquierda() != null) {
                // y se encola primero, si hubiese, la rama izquierda de árbol
                cola.encolar(auxNodo.getRamaIzquierda());
            }
            
            if (auxNodo.getRamaDerecha()!= null) {
                // y luego, si hubiese, la rama derecha
                cola.encolar(auxNodo.getRamaDerecha()); 
            }
        }
    }
    
    
    private boolean existe(NodoArbolBinario nodo, T elemento) {
        
        if(nodo == null) {
            return false;
        }
        
        if(this.criterioComparacion.compare(elemento, nodo.getElemento()) == 0) {
            return true;
        } else if(this.criterioComparacion.compare(elemento, nodo.getElemento()) > 0) {
            return this.existe(nodo.getRamaDerecha(), elemento);
        } else {
            return this.existe(nodo.getRamaIzquierda(), elemento);
        }        
    }
    
    private boolean eliminar(T elemento, NodoArbolBinario<T> nodoActual, NodoArbolBinario<T> nodoPadre) {
        
        // si el elemento es menor que el elemento del nodo actual, entonces
        // bajar recursivamente por la rama izquierda para eliminar
        if(this.criterioComparacion.compare(elemento, nodoActual.getElemento()) < 0) {
            if(nodoActual.getRamaIzquierda() != null) {                
                return this.eliminar(elemento, nodoActual.getRamaIzquierda(), nodoActual);
            } else {
                return false;
            }
        // si el elemento es mayor que el elemento del nodo actual, entonces
        // bajar recursivamente por la rama derecha para eliminar
        } else if(this.criterioComparacion.compare(elemento, nodoActual.getElemento()) > 0) {
            if(nodoActual.getRamaDerecha()!= null) {                
                return this.eliminar(elemento, nodoActual.getRamaDerecha(), nodoActual);
            } else {
                return false;
            }
        // si el elemento a eliminar se encuentra en el nodo actual
        } else {
            // verificar si el nodo tiene sus dos ramas para así sólo reemplazar el elemento y luego eliminar el menor
            if(nodoActual.getRamaIzquierda()!=null && nodoActual.getRamaDerecha()!=null) {
                // remplazar el elemento del nodo actual con el elemento de menor valor de la rama derecha
                nodoActual.setElemento(this.getElementoConMinimoValor(nodoActual.getRamaDerecha()));
                // eliminar el menor elemento "por ahora duplicado" de la rama derecha del nodo actual
                this.eliminar(nodoActual.getElemento(), nodoActual.getRamaDerecha(), nodoActual);                
            // si le falta alguna rama, se deben enlazar la rama que tenga el nodo actual con la rama del nodo padre que 
            // que apunta al nodo actual que se eliminara
            } else if(nodoPadre.getRamaIzquierda() == nodoActual) {
                nodoPadre.setRamaIzquierda((nodoActual.getRamaIzquierda() != null)? nodoActual.getRamaIzquierda():nodoActual.getRamaDerecha());            
            } else if(nodoPadre.getRamaDerecha() == nodoActual) {
                nodoPadre.setRamaDerecha((nodoActual.getRamaIzquierda() != null)? nodoActual.getRamaIzquierda():nodoActual.getRamaDerecha());
            }
            
            return true;
        }        
    }
    
    private T getElementoConMinimoValor(NodoArbolBinario<T> nodo) {
        if(nodo.getRamaIzquierda() == null) {
            return nodo.getElemento();
        } else {
            return this.getElementoConMinimoValor(nodo.getRamaIzquierda());
        }
    }
    
    @Override
    public boolean isPodado() {
        Cola<NodoArbolBinario> cola = new ColaImpl();        
        NodoArbolBinario nodoArbol = this.raiz;
        
        if(nodoArbol!=null) {
            cola.encolar(nodoArbol);
            
            while(!cola.isVacia()) {
                NodoArbolBinario<T> nodo = cola.desencolar();          
                    
                if(nodo.getRamaIzquierda() != null && nodo.getRamaDerecha() != null) {
                    cola.encolar(nodo.getRamaIzquierda());
                    cola.encolar(nodo.getRamaDerecha());
                } else if(nodo.getRamaIzquierda() != nodo.getRamaDerecha() ) {
                    return false;
                }                                
            }
        } else {
            return false;
        }
        
        return true;
    }

    @Override
    public void visualizar(Visualizable<Arbol> visor) {
        throw new UnsupportedOperationException("funcionalidad no implementada");
    }
    
    @Override
    public boolean isPerfecto() {
        //
        // @Sebastian He, Sebastian Valenzuela. DED
        // En caso de que el arbol tenga un nivel de tolerancia = 0 al momento de equilibrarlo 
        // y además este podado
        // el metodo retornará un true, caso contrario retorna false.
        //
        return this.isPodado() && this.isEquilibrado(0);
    }

    /**
     * 
     * @param subArbol
     * @return Método recursivo que retorna la altura de un subArbol, el cual es ingresado como parametro de entrada
     * dependiendo de cual de sus ramas posea una mayor cantidad de hijos(subArboles).
     */
    private int getAlturaPorRama(NodoArbolBinario<T> subArbol) {
        
        if(subArbol == null) {
            return 0;
        }

        int alturaRamaIzquierda = 0;
        int alturaRamaDerecha = 0;
        
        alturaRamaIzquierda = 1 + this.getAlturaPorRama(subArbol.getRamaIzquierda());
        alturaRamaDerecha = 1 + this.getAlturaPorRama(subArbol.getRamaDerecha());
        
        if(alturaRamaIzquierda >= alturaRamaDerecha) {
            return alturaRamaIzquierda;
        } else {
            return alturaRamaDerecha;
        }        
    }
    
    @Override
    public boolean isEquilibrado(int tolerancia) {
        int ramaIzquierda;
        int ramaDerecha;
               
        if(tolerancia < 0){
            throw new ArgumentoInvalidoException("El valor de tolerancia debe ser un número positivo");
        }
        
        ramaIzquierda = this.getAlturaPorRama(this.raiz.getRamaIzquierda());
        ramaDerecha = this.getAlturaPorRama(this.raiz.getRamaDerecha());
        
        //Se realiza la operación para obtener la diferencia entre ramas y se 
        //compara con el valor de tolerancia
        //Si el valor de la operación es menor o igual al valor de tolerancia, 
        //entonces el árbol está equilibrado. 
        return ((ramaIzquierda - ramaDerecha) <= tolerancia);     
    }

    @Override
    public int getPeso() {
        return this.numeroElementos;            
    }
    
    private int calcularPesoSubArbol(NodoArbolBinario<T> t){

        if (t == null) {
            return 0;
        }

        int c1 = calcularPesoSubArbol(t.getRamaIzquierda());
        int c2 = calcularPesoSubArbol(t.getRamaDerecha());
        int c3 = c1+c2+1;

        return c3;
    
    }
    

    @Override
    public int getAltura() {
        NodoArbolBinario<T> nodo = raiz;
        int altura = 0;
        
        if(this.calcularPesoSubArbol(nodo.getRamaDerecha()) == 0 && this.calcularPesoSubArbol(nodo.getRamaIzquierda()) == 0) {
            return 0;
        }
        
        for(int i = 0; i < this.calcularPesoSubArbol(raiz); i++){
            if(this.calcularPesoSubArbol(nodo.getRamaDerecha()) > this.calcularPesoSubArbol(nodo.getRamaIzquierda())){
                nodo = nodo.getRamaDerecha();
                altura++;
            } else if(this.calcularPesoSubArbol(nodo.getRamaDerecha()) < this.calcularPesoSubArbol(nodo.getRamaIzquierda())){
                nodo = nodo.getRamaIzquierda();
                altura++;
            }
        }
        
       return altura;
    }

    @Override
    public Lista<T> getCamino(T elemento) {
        
        if(!this.existe(elemento)) {
            return null;
        }
        
        Lista<T> lista = new ListaEnlazadaSimpleImpl<>();
       
               
        return this.getCamino(lista, this.raiz, elemento);
    }
    
    private Lista<T> getCamino(Lista<T> camino, NodoArbolBinario<T> nodo, T elemento) {
        
        if(nodo.getElemento().equals(elemento)) {
            camino.agregarElemento(elemento);
            return camino;
        }
        
        if(elemento.compareTo(nodo.getElemento()) < 0) {
            camino.agregarElemento(nodo.getElemento());
            return this.getCamino(camino, nodo.getRamaIzquierda(), elemento);
        } else {
            camino.agregarElemento(nodo.getElemento());
            return this.getCamino(camino, nodo.getRamaDerecha(), elemento);
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean sonIguales = false;
        
        // Verificar que obj es de tipo Arbol
        if(obj != null && obj instanceof Arbol) {
            Arbol arbol = (Arbol) obj;
            
            // mismo peso
            if(this.getPeso() == arbol.getPeso()) {
                
                // mismo recorrido en pre-orden
                VisitadorEnLista<T> visitador = new VisitadorEnLista<>();
                this.recorrerEnPreOrden(visitador);
                Lista<T> listaPreOrdenArbol1 = visitador.getLista();
                
                visitador = new VisitadorEnLista<>();
                arbol.recorrerEnPreOrden(visitador);
                Lista<T> listaPreOrdenArbol2 = visitador.getLista();
                                
                return listaPreOrdenArbol1.equals(listaPreOrdenArbol2);
            }
        }
        
        
        return sonIguales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeroElementos);
        return hash;
    }
     
    /**
     * Método encargado de reordenar la estructura del árbol de tal forma
     * que al finalizar su ejecución se llamase al método isEquilibrado con 
     * tolerancia 1, este debe retornar verdadeo.
     */
    private void rebalancearArbolBinario() {
        // TODO: implementación del rebalanceo        
    }
    
    /**
     * Método encargado de validar cuando el arbol será rebalanceado
     * según la cantidad de elementos ingresados y/o eliminados.
     */
    private void verificarRebalanceoPorCantidadElementosIngresados(){
        this.contadorElementosRebalanceo++;
        if(this.cantidadElementosRebalanceo >= this.contadorElementosRebalanceo){
            this.rebalancearArbolBinario();
            this.contadorElementosRebalanceo = 0;
        }
    }
}
