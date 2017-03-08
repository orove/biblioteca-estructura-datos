/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol.ejercicio.salariotrabajador.dominio;

/**
 *
 * @author Osvaldo Rodríguez V.
 */
public class Trabajador implements Comparable<Trabajador> {

    private Long idEmpleado;
    private String nombre;
    private String apellido;
    private Integer salario;       

    public Trabajador() {
    }
    
    public Trabajador(Long idEmpleado, String nombre, String apellido, Integer salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }
    
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario + '}';       
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.idEmpleado != null ? this.idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trabajador other = (Trabajador) obj;
        if (this.idEmpleado != other.idEmpleado && (this.idEmpleado == null || !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Trabajador o) {
        return this.idEmpleado.compareTo(o.idEmpleado);
    } 
    
}
