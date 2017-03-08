/**
 * DUOC UC
 * Escuela de Informática y Telecomunicaciones
 * Sede Alonso de Ovalle
 * 
 * Diseño de Estructura de Datos
 * DED4501
 *
 */

package cl.duoc.ded.test.arbol.ejercicio.bienraiz.dominio;


public class BienRaiz implements Comparable<BienRaiz> {

    private String rol;
    private String direccion;
    private Double avaluo;

    public BienRaiz(String rol, String direccion, Double avaluo) {
        this.rol = rol;
        this.direccion = direccion;
        this.avaluo = avaluo;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getAvaluo() {
        return avaluo;
    }

    public void setAvaluo(Double avaluo) {
        this.avaluo = avaluo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.rol != null ? this.rol.hashCode() : 0);
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
        final BienRaiz other = (BienRaiz) obj;
        if ((this.rol == null) ? (other.rol != null) : !this.rol.equals(other.rol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BienRaiz{" + "rol=" + rol + ", direccion=" + direccion + ", avaluo=" + avaluo + '}';
    }

    @Override
    public int compareTo(BienRaiz o) {
        return this.getRol().compareToIgnoreCase(o.getRol());
    }
        
}
