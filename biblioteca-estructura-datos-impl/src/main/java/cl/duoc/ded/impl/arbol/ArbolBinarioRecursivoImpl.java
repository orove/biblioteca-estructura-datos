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
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;



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
     * nodo inicial para recorrer el Ã¡rbol.
     */
    protected NodoArbolBinario<T> raiz;
    
    /**
     * acciÃ³n a ejecutar cuando se visita el nodo.
     */
    protected Visitador operacionAlVisitarElemento;
    
    
    
    /**
     * N&uacute;mero de elementos ingresados en el &aacute;rbol.
     */
    private Integer numeroElementos = 0;
    
   
    
   
    
        
    @Override
    public void recorrerEnPreOrden(Visitador<T> operacion) {
        
        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operaciÃ³n sobre el elemento no estÃ¡ definida");
        }
        
        this.operacionAlVisitarElemento = operacion;
        this.preOrden(this.raiz);
    }
    
        
    @Override
    public void recorrerEnPostOrden(Visitador<T> operacion) {
        
        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operaciÃ³n sobre el elemento no estÃ¡ definida");
        }
        
        this.operacionAlVisitarElemento = operacion;
        this.postOrden(this.raiz);
    }
    
 
    @Override
    public void recorrerEnOrden(Visitador<T> operacion) {
        
        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operaciÃ³n sobre el elemento no estÃ¡ definida");
        }
        
        this.operacionAlVisitarElemento = operacion;
        this.inOrden(this.raiz);
    }    
      
    
    @Override
    public void recorrerEnAmplitud(Visitador<T> operacion) {

        if(operacion == null) {
            throw new ArgumentoInvalidoException("la operaciÃ³n sobre el elemento no estÃ¡ definida");
        }

        this.operacionAlVisitarElemento = operacion;
        this.enAmplitud(this.raiz);    
    }
      
    
    @Override
    public synchronized void agregarElemento(T nuevoElemento) {
        
        if(nuevoElemento == null) {
            throw new ElementoNuloException("no se puede agregar elementos nulos al Ã¡rbol binario");
        }

        NodoArbolBinario<T> nuevoNodo = new NodoArbolBinario<>();
        nuevoNodo.setElemento(nuevoElemento);
        
        if(this.raiz == null) {
            this.raiz = nuevoNodo;
        } else {            
            this.agregar(nuevoNodo,this.raiz);            
        }
        
        this.numeroElementos++;
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
                // y se encola primero, si hubiese, la rama izquierda de Ã¡rbol
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
            // verificar si el nodo tiene sus dos ramas para asÃ­ sÃ³lo reemplazar el elemento y luego eliminar el menor
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
        // y ademÃ¡s este podado
        // el metodo retornarÃ¡ un true, caso contrario retorna false.
        //
        return this.isPodado() && this.isEquilibrado(0);
    }

    /**
     * 
     * @param subArbol
     * @return MÃ©todo recursivo que retorna la altura de un subArbol, el cual es ingresado como parametro de entrada
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
            throw new ArgumentoInvalidoException("El valor de tolerancia debe ser un nÃºmero positivo");
        }
        
        ramaIzquierda = this.getAlturaPorRama(this.raiz.getRamaIzquierda());
        ramaDerecha = this.getAlturaPorRama(this.raiz.getRamaDerecha());
        
        //Se realiza la operaciÃ³n para obtener la diferencia entre ramas y se 
        //compara con el valor de tolerancia
        //Si el valor de la operaciÃ³n es menor o igual al valor de tolerancia, 
        //entonces el Ã¡rbol estÃ¡ equilibrado. 
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
     * comparador de elementos utilizado al momento
     * de agregar un elemento al Ã¡rbol binario.
     */
    public final Comparator criterioComparacion;
    
   /**
     * Constructor por defecto que utiliza para la comparaciÃ³n
     * la interfaz comparable que debe tener implementada el elemento T
     * que manejarÃ¡ el Ã¡rbol binario.
     */
    public ArbolBinarioRecursivoImpl() {
        // se implementa en una clase anÃ³nima la interfaz Comparator para el 
        // comparador de comparaciÃ³n por defecto que utilizarÃ¡ el Ã¡rbol.
        this.criterioComparacion = new Comparator<T>() {
            @Override
            public int compare(T elemento1, T elemento2) {
                // se utiliza el mÃ©todo de la interfaz Comparable, el cual debe
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
            throw new ArgumentoInvalidoException("el comparador de comparaciÃ³n no puede ser nulo");
        }
        
        this.criterioComparacion = criterio;
    }

    /**
     
     * @param e - element whose presence in this collection is to be ensured.
     * @return true if this collection changed as a result of the call.
     * @throws ClassCastException - if the class of the specified element prevents it from being added to this collection 
     * @throws NullPointerException - if the specified element is null and this collection does not permit null elements 
     * @throws IllegalStateException - if the element cannot be added at this time due to insertion restrictions
     */
    public boolean annadir(T e) throws ClassCastException, NullPointerException, IllegalStateException{
    	ArbolBinarioRecursivoImpl<T> Nodo = new ArbolBinarioRecursivoImpl<T>();
    	boolean salir = false;
    	boolean der = false;
    	NodoArbolBinario<T> raizTmp = this.getRaiz();

    	int altIzq, altDer;

    	//no existía arbol
    	if(raizTmp == null){
    		this.raiz = raiz;
    		return true;
    	}else
    	
    	//estaba ya en el arbol?
    	if(this.contains(Nodo.getElementoConMinimoValor(raiz))){
    		return false;
    	}
    	
    	//no estaba antes en el arbol
    	else{    	
    		while(!salir){

    			//es mayor el nodo a insertar que la raiz?    				
		    	if(this.compararDato(Nodo.getElementoConMinimoValor(raiz), raizTmp.getElemento())>0){
		    		if(raizTmp.getRamaDerecha()!=null){
		    			raizTmp = raizTmp.getRamaDerecha();	
		    		}else{
		    			salir = true;
		    			der = true;
		    		}
		    			    		
		    	}
		    	//el nodo es menor que la raiz
		    	else{
		    		if(raizTmp.getRamaIzquierda()!=null){
		    			raizTmp = raizTmp.getRamaIzquierda();
		    		}else{
		    			salir = true;
		    		}
		    	}
    		}
    		
    		//tengo que insertarlo a la derecha?
    		if(der){
    			raizTmp.setRamaDerecha(raizTmp);
    		}
    		
    		//lo inserto a la izquierda
    		else{
    			raizTmp.setRamaIzquierda(raizTmp);
    		}
	
    		//mientras no este equilibrado el arbol	miramos donde reestructurar
    		while(equilibrado(this.getRaiz())<0){
				raizTmp = padre(raizTmp);
    		
    			if(raizTmp.getRamaDerecha()==null){
	    			altDer = 0;
	    		}else{
	    			altDer = raizTmp.getRamaDerecha().getAltura();
	    		}
	    		
	    		if(raizTmp.getRamaIzquierda()==null){
	    			altIzq = 0;
	    		}else{
	    			altIzq = raizTmp.getRamaIzquierda().getAltura();
	    		}
	    		
    			NodoArbolBinario<T> cambiar = estructurar(raizTmp, altIzq, altDer);
    			NodoArbolBinario<T> superior = padre(raizTmp);
	
    			//si los nodos modificados tenian un padre anteriormente
    			if(compararDato(superior.getElemento(), raizTmp.getElemento())!=0){
    				if(superior.getRamaIzquierda()!=null && compararDato(superior.getRamaIzquierda().getElemento(), raizTmp.getElemento())==0){
	    				superior.setRamaIzquierda(cambiar);		
		    		}
		    		else if(superior.getRamaDerecha()!=null && compararDato(superior.getRamaDerecha().getElemento(), raizTmp.getElemento())==0){
	    				superior.setRamaDerecha(cambiar);
	    			}
    			}else{
    				this.raiz = cambiar;
    			}
    		}
    		return true;
    	}
    }
    
    /**
     * Estructura el arbol haciendo las rotaciones necesarias.
     * Rotacion simple derecha, rotacion compuesta derecha izquierda, rotacion simple
     * izquierda y rotacion compuesta izquierda derecha.
     * @param nodo nodo con factor de equilibro 2.
     * @param altIzq altura izquierda del nodo pasado por parametro.
     * @param altDer altura derecha del nodo pasado por parametro.
     *
     * @return nodo nodo que pasa a ser la raiz del subarbol estructurado.
     */
    private NodoArbolBinario<T> estructurar(NodoArbolBinario<T> nodo, int altIzq, int altDer){
		if(extraeFactorE(nodo)==2){
			if( extraeFactorE(nodo.getRamaDerecha())==1  || extraeFactorE(nodo.getRamaDerecha()) == 0){
				nodo = rotacionSimpleIzquierda(nodo);
			}
			
			else if(extraeFactorE(nodo.getRamaDerecha())==-1){
				nodo = rotacionCompuestaDerecha(nodo);
			}
		}
		else if(extraeFactorE(nodo)==-2){
			if(extraeFactorE(nodo.getRamaIzquierda())==-1 || extraeFactorE(nodo.getRamaDerecha())==0){
				nodo = rotacionSimpleDerecha(nodo);
			}
			
			else if(extraeFactorE(nodo.getRamaIzquierda())==1){
				nodo = rotacionCompuestaIzquierda(nodo);
			}
		}

		return nodo;	
    }
    
    /**
     * Extrae el factor de equilibrio del nodo pasado por parametro.
     * @param nodo nodo del que se desea extraer el factor de equilibrio.
     * 
     * @return factor de equilibrio.
     */
    public int extraeFactorE(NodoArbolBinario<T> nodo){
    	if(nodo!=null){
    		return nodo.getFactorE();
    	}else{
    		return 0;
    	}
    }

	/**
	 * Realiza la operacion de rotacion simple izquierda en el subarbol 
	 * que tiene como raiz el nodo pasado por parametro.
	 * @param nodo raiz del subarbol a rotar.
	 *
	 * @return nodo nodo que pasa a ser la raiz del subarbol estructurado.
	 */
    public NodoArbolBinario<T> rotacionSimpleIzquierda(NodoArbolBinario<T> nodo){
		NodoArbolBinario<T> nodoTmp = nodo;
		
    	nodo = nodoTmp.getRamaDerecha(); //clone??
		nodoTmp.setRamaDerecha(nodo.getRamaIzquierda());

		nodo.setRamaIzquierda(nodoTmp);

		return nodo;
    }

	/**
	 * Realiza la operacion de rotacion simple derecha en el subarbol .
	 * que tiene como raiz el nodo pasado por parametro.
	 * @param nodo raiz del subarbol a rotar.
	 *
	 * @return nodo nodo que pasa a ser la raiz del subarbol estructurado.
	 */
    public NodoArbolBinario<T> rotacionSimpleDerecha(NodoArbolBinario<T> nodo){
    	NodoArbolBinario<T> nodoTmp = nodo;
    	nodo = nodoTmp.getRamaIzquierda();

		nodoTmp.setRamaDerecha(nodo.getRamaDerecha());
		nodo.setRamaIzquierda(nodoTmp);

		return nodo;
    }

	/**
	 * Realiza la operacion de rotacion compeusta izquierda-derecha en el subarbol .
	 * que tiene como raiz el nodo pasado por parametro.
	 * @param nodo raiz del subarbol a rotar.
	 *
	 * @return nodo nodo que pasa a ser la raiz del subarbol estructurado.
	 */
    public NodoArbolBinario<T> rotacionCompuestaIzquierda(NodoArbolBinario<T> nodo){
    	NodoArbolBinario<T> nodoTmp = nodo; //57

        nodoTmp = rotacionSimpleIzquierda(nodoTmp.getRamaIzquierda()); //param 42 | sale: 54
        
		nodo.setRamaIzquierda(nodoTmp); //param 54

		nodoTmp = rotacionSimpleDerecha(nodo); //param 54  | sale: 54
		
		return nodoTmp;
    }

	/**
	 * Realiza la operacion de rotacion compuesta derecha-izquierda en el subarbol 
	 * que tiene como raiz el nodo pasado por parametro.
	 * @param nodo raiz del subarbol a rotar.
	 *
	 * @return nodo nodo que pasa a ser la raiz del subarbol estructurado.
	 */
    public NodoArbolBinario<T> rotacionCompuestaDerecha(NodoArbolBinario<T> nodo){
    	NodoArbolBinario<T> nodoTmp = nodo;
    	
        nodoTmp = rotacionSimpleDerecha(nodoTmp.getRamaDerecha());
	
		nodo.setRamaDerecha(nodoTmp);

		nodoTmp= rotacionSimpleIzquierda(nodo);

		return nodoTmp;
    }

	/**
	 * Indica si el arbol o subarbol cuya raiz es es el nodo pasado por parametro
	 * es un arbol equilibrado o no.
	 * @param n raiz del subarbol o arbol .
	 *
	 * @return -1 si no esta equilibrado. La altura en caso contrario.
	 */
	public int equilibrado(NodoArbolBinario<T> n){
		int hIzq = 0;
		int hDer = 0;
		
		if(n==null){
    		return 0;
    	}
    	
    	hIzq = equilibrado(n.getRamaIzquierda());
    	
    	if(hIzq < 0){
    		return hIzq;
    	}
    	
    	hDer = equilibrado(n.getRamaDerecha());
    	
    	if(hDer <0){
    		return hDer;
    	}
    	
    	//si no es equilibrado
    	if(Math.abs(hIzq - hDer)>1){
    		return -1;
    	}
    	
    	//si el trozo de arbol es AVL devolvemos la altura
    	return Math.max(hIzq, hDer) + 1;
	}
	
	/**
	 * Obtiene el nodo padre del nodo pasado por parametro. 
	 * En caso de que no tenga padre, devuelve el mismo nodo pasado por parametro.
	 *
	 * @param nodo nodo del que se quiere obtener su nodo padre.
	 * @return nodo padre.
	 */
	public NodoArbolBinario<T> padre(NodoArbolBinario<T> nodo){
		NodoArbolBinario<T> raizTmp = this.getRaiz();
		Stack<NodoArbolBinario<T>> pila = new Stack<NodoArbolBinario<T>>();
    	pila.push(raizTmp);	
    	while(raizTmp.getRamaDerecha()!=null || raizTmp.getRamaIzquierda()!=null){
	    	if(this.compararDato(nodo.getElemento(), raizTmp.getElemento())>0){
	    		if(raizTmp.getRamaDerecha()!=null){   	
	    			raizTmp = raizTmp.getRamaDerecha();
	    		}
	    	}
	    	else if(this.compararDato(nodo.getElemento(), raizTmp.getElemento())<0){	
	    		if(raizTmp.getRamaIzquierda()!=null){   
		    		raizTmp = raizTmp.getRamaIzquierda();
	    		}
	    	}
	    	if(this.compararDato(nodo.getElemento(), raizTmp.getElemento())==0){
	    		return pila.pop();
	    	}

	    	pila.push(raizTmp);	
    	}
    	return pila.pop();
	}
	
	/**
	 * Adds all of the elements in the specified collection to this collection (optional operation). The behavior of this operation is undefined if the specified collection is modified while the operation is in progress. (This implies that the behavior of this call is undefined if the specified collection is this collection, and this collection is nonempty.)
	 * This implementation iterates over the specified collection, and adds each object returned by the iterator to this collection, in turn.
	 * Note that this implementation will throw an UnsupportedOperationException unless add is overridden (assuming the specified collection is non-empty). 
	 *
	 * @param c - collection containing elements to be added to this collection.
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this collection. 
     * @throws NullPointerException - if the specified element is null and this collection does not permit null elements. 
     * @throws IllegalStateException - if the element cannot be added at this time due to insertion restrictions
	 * @return true if this collection changed as a result of the call.
	 */
    public boolean agregarTodo(Collection<? extends T> c) throws ClassCastException, NullPointerException, IllegalStateException{
    	Iterator<? extends T> iter = c.iterator();
    	Iterator<? extends T> iter2 = c.iterator();
    	T dato, primero;
    	boolean insertado = false;
    	
    	//si el arbol no existÃ­a
    	if(this.isEmpty()){    		
    		//comprobamos que sean comparables entre si. Sino, salta excepcion.
    		primero = iter.next();
    		while(iter.hasNext()){
    			this.compararDato(primero, iter.next());
    		}
    	}
    	
    	//el arbol ya existÃ­a
    	else{
    		//comprobamos que los datos sean comparables con los que ya estÃ¡n dentro del arbol
    		primero = this.getRaiz().getElemento();
    		while(iter.hasNext()){
    			this.compararDato(primero, iter.next());
    		}
    	}
    	
    	
    	//solo llega hasta aqui si los elementos son comparables entre si o con los que ya habÃ­a
    	while(iter2.hasNext()){
    		dato = iter2.next();
    		if(dato!=null){
    			if(this.annadir(dato)){
    				insertado = true;
    			}
    		}
    	}
    	return insertado ;
    }
    
    /**
     * Removes all of the elements from this collection (optional operation). The collection will be empty after this method returns.
     * This implementation iterates over this collection, removing each element using the Iterator.remove operation. Most implementations will probably choose to override this method for efficiency.
     * Note that this implementation will throw an UnsupportedOperationException if the iterator returned by this collection's iterator method does not implement the remove method and this collection is non-empty. 
     */ 
    public void limpiar(){
    	Iterator<T> iter = this.iterator();
    	
    	while(iter.hasNext()){
    		eliminarElemento(iter.next());
    	}
    }
    
    /**
     * Returns true if this collection contains the specified element. More formally, returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e)).
     * This implementation iterates over the elements in the collection, checking each element in turn for equality with the specified element. 
     *
     * @param o - element whose presence in this collection is to be tested.
     * @return true if this collection contains the specified element.
     * @throws  ClassCastException - if the type of the specified element is incompatible with this collection (optional).
   	 * @throws NullPointerException - if the specified element is null and this collection does not permit null elements (optional).
     */
    public boolean contains(Object o) throws ClassCastException, NullPointerException{
    	NodoArbolBinario<T> raizTmp = this.getRaiz();
    	if(this.isEmpty()){
    		return false;
    	}
    	
    	//si es la raiz el buscado
    	if(this.compararDato((T)o, raizTmp.getElemento())==0){
	    	return true;
	    }
	    
    	while(raizTmp.getRamaDerecha()!=null || raizTmp.getRamaIzquierda()!=null){

	    	if(this.compararDato((T)o, raizTmp.getElemento())>0){
	    		if(raizTmp.getRamaDerecha()!=null){   		
	    			raizTmp = raizTmp.getRamaDerecha();
	    		}else{
	    			return false;
	    		}
	    	}else if(this.compararDato((T)o, raizTmp.getElemento())<0){	
	    		if(raizTmp.getRamaIzquierda()!=null){   
		    		raizTmp = raizTmp.getRamaIzquierda();
	    		}else{
	    			return false;
	    		}
	    	}
	    	
	    	if(this.compararDato((T)o, raizTmp.getElemento())==0){
	    		return true;
	    	}
    	}
    	return false;
    }
    
    /**
     * Returns true if this collection contains all of the elements in the specified collection.
     * This implementation iterates over the specified collection, checking each element returned by the iterator in turn to see if it's contained in this collection. If all elements are so contained true is returned, otherwise false. 
     *
     * @param c - collection to be checked for containment in this collection.
     * @return true if this collection contains all of the elements in the specified collection.
     * @throws ClassCastException - if the types of one or more elements in the specified collection are incompatible with this collection (optional).
     * @throws NullPointerException - if the specified collection contains one or more null elements and this collection does not permit null elements (optional), or if the specified collection is null.
     */
    public boolean containsAll(Collection<?> c) throws ClassCastException, NullPointerException{   	
    	Iterator<?> iter = c.iterator();
    	List<?> listaArbol = this.inOrden();
    	T dato = null;
    	
    	if(this.isEmpty()){
    		return false;
    	}
    	
    	while(iter.hasNext()){
    		dato = (T)iter.next();
    		
    		if(!listaArbol.contains(dato)){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Returns true if this collection contains no elements.
     * This implementation returns size() == 0. 
     *
     * @return true if this collection contains no elements.
     */ 
    public boolean isEmpty(){
    	return this.size()==0;
    	//?? tal vez this.getRaiz()==null?
    }
    
    /** 
     * Returns an iterator over the elements contained in this collection. 
     * @return an iterator over the elements contained in this collection.
     */
    public Iterator<T> iterator(){ 
    	List<T> lista= this.inOrden();
    	Iterator<T> iter = lista.iterator();
    	
    	return iter;
    }
    
    /**
     * Removes a single instance of the specified element from this collection, if it is present (optional operation). More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this collection contains one or more such elements. Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
     * This implementation iterates over the collection looking for the specified element. If it finds the element, it removes the element from the collection using the iterator's remove method.
     * Note that this implementation throws an UnsupportedOperationException if the iterator returned by this collection's iterator method does not implement the remove method and this collection contains the specified object. 
     *
     * @param o - element to be removed from this collection, if present.
     * @return true if an element was removed as a result of this call.
     * @throws ClassCastException - if the type of the specified element is incompatible with this collection (optional) .
     * @throws NullPointerException - if the specified element is null and this collection does not permit null elements (optional).
     */
    public boolean remover(Object o) throws ClassCastException, NullPointerException{
    	NodoArbolBinario<T> borrar=null,mirar=null,cambiar=null, nPadre = null;
    	NodoArbolBinario<T> raizTmp = this.getRaiz();
    	T c_aux, d_aux;
    	boolean salir = false;
    	int altDer = 0;
    	int altIzq = 0;
    	int a = 0;
    	
    	if(this.isEmpty()){
    		return false;
    	}

    	//el nodo a borrar es la raiz?
    	if(this.compararDato((T)o, raizTmp.getElemento())==0){
	    	salir = true;
	    	borrar = raizTmp;
	    }
    	
    	//si no es la raiz, lo buscamos
    	while(!salir && (raizTmp.getRamaDerecha()!=null || raizTmp.getRamaIzquierda()!=null)){

	    	if(this.compararDato((T)o, raizTmp.getElemento())>0){
	    		if(raizTmp.getRamaDerecha()!=null){   		
	    			raizTmp = raizTmp.getRamaDerecha();
	    		}else{
	    			return false;
	    		}
	    	}else if(this.compararDato((T)o, raizTmp.getElemento())<0){
	    	
	    		if(raizTmp.getRamaIzquierda()!=null){   
		    		raizTmp = raizTmp.getRamaIzquierda();
	    		}else{
	    			return false;
	    		}
	    	}
	    	
	    	if(this.compararDato((T)o, raizTmp.getElemento())==0){
	    		salir = true;
	    		borrar = raizTmp;
	    	}
    	}
    

    	//existe el nodo a borrar?
    	if(salir){
    		mirar = borrar;

	    	//es una hoja?
	    	if(borrar.getRamaIzquierda()==null && borrar.getRamaDerecha()==null){
	    		mirar= padre(borrar);
	    		nPadre = padre(borrar);
	    		
	    		//es un arbol raiz con solo un nodo raiz?
	    		if(this.size()==1){
	    			this.raiz = null;
	    		}
	    		
	    		if(nPadre.getRamaDerecha()!=null && compararDato(nPadre.getRamaIzquierda().getElemento(), borrar.getElemento())==0){
	    			nPadre.setRamaIzquierda(null);
	    		}else if(nPadre.getRamaDerecha()!=null && compararDato(nPadre.getRamaDerecha().getElemento(), borrar.getElemento())==0){
	    			nPadre.setRamaDerecha(null);
	    		}
	    		//nos lo cargamos
	    		borrar.setElemento(null);
	    	}
	    	
	    	//solo tiene un hijo? (o 2 pero en la misma altura) entonces la altura de ese subarbol serÃ¡ 1 o 2 (altura raiz = 1)
	    	else if(borrar.getAltura()<=2){

	    		if(borrar.getRamaIzquierda()!=null){
	    			borrar.setElemento(borrar.getRamaIzquierda().getElemento());
	    			borrar.setRamaIzquierda(null);
	    		}
	    		
	    		else if(borrar.getRamaDerecha()!=null){
	    			borrar.setElemento(borrar.getRamaDerecha().getElemento());
	    			borrar.setRamaDerecha(null);
	    		}
	    	}
	    	
	    	//cuando no es ni un hoja ni su padre. Es decir, estÃ¡ por medio del arbol.
	    	else{

	    		//buscamos el mayor de la izquierda
		    	if(borrar.getRamaIzquierda()!=null){
		    		cambiar = borrar.getRamaIzquierda();
		    		
		    		while(cambiar.getRamaDerecha()!=null){
		    			cambiar = cambiar.getRamaDerecha();
		    		}
		    	}
		    		
		    	//buscamos el menor de la derecha
		    	else if(borrar.getRamaDerecha()!=null){
		    		cambiar = cambiar.getRamaDerecha();
		    	
		    		while(cambiar.getRamaIzquierda()!=null){
		    			cambiar = cambiar.getRamaIzquierda();
		    		}
		    	}
	    	
		    	c_aux = cambiar.getElemento();
		    	NodoArbolBinario<T> papa = padre(cambiar);
		    	
		    	//si el nodo que hemos cambiado se ha quedado con algÃºn hijo...
		    	if(cambiar.getRamaIzquierda()!=null || cambiar.getRamaDerecha()!=null){
			    	if(cambiar.getRamaIzquierda()!=null){
			    		cambiar.setElemento(cambiar.getRamaIzquierda().getElemento());
			    		cambiar.setRamaIzquierda(null);
			    	}else if(cambiar.getRamaDerecha()!=null){
			    		cambiar.setElemento(cambiar.getRamaDerecha().getElemento());
			    		cambiar.setRamaDerecha(null);
			    	}
		    	}
		    	//si no tiene hijos ya, lo eliminamos sin mÃ¡s
		    	else{		    	
			    	if(papa.getRamaIzquierda()!=null && compararDato(papa.getRamaIzquierda().getElemento(), cambiar.getElemento())==0){
			    		papa.setRamaIzquierda(null);
			    	}else{
			    		papa.setRamaDerecha(null);
			    	}
			    	cambiar.setElemento(borrar.getElemento());
			    	borrar.setElemento(c_aux);
		    	}		    
	    	}
	    	
	    	while(equilibrado(this.getRaiz())<0){
    			if(mirar.getRamaDerecha()==null){
	    			altDer = 0;
	    		}else{
	    			altDer = mirar.getRamaDerecha().getAltura();
	    		}
	    		
	    		if(mirar.getRamaIzquierda()==null){
	    			altIzq = 0;
	    		}else{
	    			altIzq = mirar.getRamaIzquierda().getAltura();
	    		}
	    		
    			NodoArbolBinario<T> cambiar2 = estructurar(mirar, altIzq, altDer);
    			NodoArbolBinario<T> superior = padre(mirar);
    			
    			//si los nodos modificados tenian un padre anteriormente
    			if(compararDato(superior.getElemento(), mirar.getElemento())!=0){
    				if(superior.getRamaIzquierda()!=null && compararDato(superior.getRamaIzquierda().getElemento(), mirar.getElemento())==0){
	    				superior.setRamaIzquierda(cambiar2);		
		    		}
		    		else if(superior.getRamaDerecha()!=null && compararDato(superior.getRamaDerecha().getElemento(), mirar.getElemento())==0){
	    				superior.setRamaDerecha(cambiar2);
	    			}
    			}else{
    				this.raiz = cambiar2;
    			}
    			mirar = padre(mirar);
    		}
    		return true;	    	
    	}	
    	return false;
    }
    
   	
    /**
     * Removes all of this collection's elements that are also contained in the specified collection (optional operation). After this call returns, this collection will contain no elements in common with the specified collection.
     * This implementation iterates over this collection, checking each element returned by the iterator in turn to see if it's contained in the specified collection. If it's so contained, it's removed from this collection with the iterator's remove method.
     * Note that this implementation will throw an UnsupportedOperationException if the iterator returned by the iterator method does not implement the remove method and this collection contains one or more elements in common with the specified collection. 
     *
     * @param c - collection containing elements to be removed from this collection.
     * @return c - collection containing elements to be removed from this collection.
     * @throws ClassCastException - if the types of one or more elements in this collection are incompatible with the specified collection (optional) .
     * @throws NullPointerException - if this collection contains one or more null elements and the specified collection does not support null elements (optional), or if the specified collection is null.
     */ 
    public boolean removerTodo(Collection<?> c) throws ClassCastException, NullPointerException{
    	T dato;
    	boolean noBorrado = false;
    	
    	Iterator<?> iter = c.iterator();
    	while(iter.hasNext()){
    		dato = (T)iter.next();
    		    		
    		if(eliminarElemento(dato)){
    			noBorrado = true;
    		}
    	}
    		
    	return noBorrado;
    }
    
    /**
     * Retains only the elements in this collection that are contained in the specified collection (optional operation). In other words, removes from this collection all of its elements that are not contained in the specified collection.
     * This implementation iterates over this collection, checking each element returned by the iterator in turn to see if it's contained in the specified collection. If it's not so contained, it's removed from this collection with the iterator's remove method.
     * Note that this implementation will throw an UnsupportedOperationException if the iterator returned by the iterator method does not implement the remove method and this collection contains one or more elements not present in the specified collection. 
     *
     * @param c - collection containing elements to be retained in this collection.
     * @return true if this collection changed as a result of the call .
     * @throws ClassCastException - if the types of one or more elements in this collection are incompatible with the specified collection (optional) .
     * @throws NullPointerException - if this collection contains one or more null elements and the specified collection does not permit null elements (optional), or if the specified collection is null.
     */
    public boolean retainAll(Collection<?> c) throws ClassCastException, NullPointerException{
    	List<T> listaArbol = this.preOrden();
    	List<T> listaBorrar = new ArrayList<T>();
    	T dato;
    	boolean modificada = false;
    	
    	for(int i=0; i<listaArbol.size(); i++){
      		if(!c.contains(listaArbol.get(i))){
    			listaBorrar.add(listaArbol.get(i));
    		}
    	}
    	
		Iterator<?> iter = listaBorrar.iterator();
    	while(iter.hasNext()){
    		modificada = true;
    		dato = (T)iter.next();
    		    		
    		eliminarElemento(dato);
    	}
    	
    	return modificada;
    }
    
    /**
     * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
     * @return the number of elements in this collection.
     */
    public int size(){
    	return this.preOrden().size();
    }

    /**
     * Este mÃ©todo recorre el Ã¡rbol mediante el recorrido INORDEN y almacena cada elemento.
     * en una lista que se devuelve al terminar el recorrido.
     * @return lista Lista en inorden con el contenido del arbol.
     */
     
    public List<T> inOrden(){
		List<T> lista = new ArrayList<T>();
    	NodoArbolBinario<T> nodo = this.getRaiz();  	
    	Stack<NodoArbolBinario<T>> pila = new Stack<NodoArbolBinario<T>>();
     	
     	while((nodo!=null &&nodo.getElemento()!=null)|| !pila.empty()){
     		if(nodo!=null){
     			pila.push(nodo);
     			nodo = nodo.getRamaIzquierda();
     		}else{
     			nodo = pila.pop();
     			lista.add(nodo.getElemento());
     			nodo = nodo.getRamaDerecha();
     		}
     	} 	
    	
    	return lista;
    }
    
    
    /**
     * Este mÃ©todo recorre el Ã¡rbol mediante el recorrido PREORDEN y almacena cada
     * elemento en una lista que se devuelve al terminar el recorrido.
     * @return lista Lista en preorden con el contenido del arbol.
     */
    public List<T> preOrden(){
    	List<T> lista = new ArrayList<T>();
    	NodoArbolBinario<T> nodo = this.getRaiz();  	
    	Stack<NodoArbolBinario<T>> pila = new Stack<NodoArbolBinario<T>>();

     	while((nodo!=null && nodo.getElemento()!=null) || !pila.empty()){
     		if(nodo!=null){
     			lista.add(nodo.getElemento());
     			pila.push(nodo);
     			nodo = nodo.getRamaIzquierda();
     		}else{
     			nodo = pila.pop();
     			nodo = nodo.getRamaDerecha();
     		}
     	} 	
    	
    	return lista;
    }
    

    /**
     * Este mÃ©todo recorre el Ã¡rbol mediante el recorrido POSTORDEN y almacena cada
     * elemento en una lista que se devuelve al terminar el recorrido.
     * @return lista Lista en postOrden con el contenido del arbol.
     */
    public List<T> postOrden(){
    	List<T> lista = new ArrayList<T>();
    	NodoArbolBinario<T> nodo = this.getRaiz();  	
    	Stack<NodoArbolBinario<T>> pila1 = new Stack<NodoArbolBinario<T>>();
    	Stack<Boolean> pila2 = new Stack<Boolean>();
    	
    	while((nodo!=null && nodo.getElemento()!=null) || !pila1.empty()){
    		
    		if(nodo!=null){
    			pila1.push(nodo);
    			pila2.push(true);
    			nodo = nodo.getRamaIzquierda();
    		}else{
    			nodo = pila1.pop();
    			if(pila2.pop()){
    				pila1.push(nodo);
    				pila2.push(false);
    				nodo = nodo.getRamaDerecha();
    			}else{
    				lista.add(nodo.getElemento());
    				nodo = null;
    			}
    		}
    	}
    	
    	return lista;
    }
    
    /**
     * Se devuelve la altura del Nodo que contiene al dato pasado por parÃ¡metro, si 
     * el dato nose encuentra en el Ã¡rbol se devuelve -1.
     * @param dato dato del que buscamos la altura.
     * @return altura del nodo
     */
    public int altura(T dato){
    	NodoArbolBinario<T> nodo = this.getNodo(dato);
    	if(!this.contains(dato)){
    		return -1;
    	}
    	
    	return nodo.getAltura();
    }

    /**
     * Se devuelve la profundidad del Nodo que contiene al dato pasado por parÃ¡metro,
     * si eldato no se encuentra en el Ã¡rbol se devuelve -1. La profundidad del nodo
     * raÃ­z es 0. 
     * @param dato dato del que buscamos su profundidad.
     * @return profundidad del dato pasado por parametro
     */
    public int profundidad(T dato){
    	NodoArbolBinario<T> nodo = new NodoArbolBinario<T>();
    	int profundidad = 0;
    	while(compararDato(nodo.getElemento(), this.getRaiz().getElemento())!=0){
    		profundidad++;
    		nodo = padre(nodo);
    	}
    	
    	return profundidad;
    }
    
    /**
     * Devuelve el Nodo que es la raÃ­z del Ã¡rbol.
     * @return nodo raiz.
     */
    public NodoArbolBinario<T> getRaiz(){
    	return this.raiz;
    }
    
    /**
     * Devuelve el Nodo que contiene al dato pasado por parÃ¡metro.
     * @param dato dato del nodo a buscar.
     * @return nodo con el dato a buscar.
     */
    public NodoArbolBinario<T> getNodo(T dato){
     	NodoArbolBinario<T> raizTmp = this.getRaiz();
     	
     	if(this.isEmpty()){
     		return null;
     	}
    	
   		while(raizTmp.getRamaDerecha()!=null || raizTmp.getRamaIzquierda()!=null){

	    	if(this.compararDato(dato, raizTmp.getElemento())>0){
	    		if(raizTmp.getRamaDerecha()!=null){   		
	    			raizTmp = raizTmp.getRamaDerecha();
	    		}else{
	    			return null;
	    		}
	    	}else if(this.compararDato(dato, raizTmp.getElemento())<0){	
	    		if(raizTmp.getRamaIzquierda()!=null){   
		    		raizTmp = raizTmp.getRamaIzquierda();
	    		}else{
	    			return null;
	    		}
	    	}
	    	
	    	if(this.compararDato(dato, raizTmp.getElemento())==0){
	    		return raizTmp;
	    	}
    	}
    	
    	return raizTmp;
    }
    
    /**
     * Devuelve el comparator que utiliza el Ã¡rbol.
     * @return comparador que utiliza el arbol.
     */
    private Comparator<T> getComparator(){
    	return this.criterioComparacion;
    }
    
    /**
     * Extrae el dato de un nodo.
     * @param nodo nodo del que buscamos extraer el el nodo.
     * @return dato
     */
    public T extraeDato(NodoArbolBinario<T> nodo){
    	return nodo.getElemento();
    }
    
    /**
     * Funcion que compara mediante un modo u otro dependiendo de si el objeto 
     * que se pasa por parametro es comparable o necesita de una funcion especifica.
     * @param t1 dato1
     * @param t2 dato2
     * @return un int negativo, un cero, o un int positivo si el primer objeto es 
     * menor, igual o mayor respectivametne con especto al segundo objeto pasado por parametro.
     */
    private int compararDato(T t1, T t2){
    	if(this.criterioComparacion==null){
    		return ((Comparable)t1).compareTo(t2);
    	}else{
    		return this.criterioComparacion.compare(t1,t2);
    	}
    }

    
    
        
        
    }
     

