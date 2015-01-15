package maping;
// Generated 23/10/2014 05:20:25 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String usu;
     private Oficina oficina;
     private String usuNombre;
     private String clave;
     private String estado;
     private Set<TramiteDatos> tramiteDatoses = new HashSet<TramiteDatos>(0);
     private Set<DocusExtint> docusExtints = new HashSet<DocusExtint>(0);
     private Set<Constancias> constanciases = new HashSet<Constancias>(0);
     private Set<DocusInternos> docusInternoses = new HashSet<DocusInternos>(0);
     private Set<DocusInternos> docusInternoses1 = new HashSet<DocusInternos>(0);
     private Set<Jefatura> jefaturas = new HashSet<Jefatura>(0);

    public Usuario() {
    }

	
    public Usuario(String usu, String usuNombre, String clave) {
        this.usu = usu;
        this.usuNombre = usuNombre;
        this.clave = clave;
    }
    public Usuario(String usu, Oficina oficina, String usuNombre, String clave, String estado, Set<TramiteDatos> tramiteDatoses, Set<DocusExtint> docusExtints, Set<Constancias> constanciases, Set<DocusInternos> docusInternoses, Set<Jefatura> jefaturas, Set<DocusInternos> docusInternoses1) {
       this.usu = usu;
       this.oficina = oficina;
       this.usuNombre = usuNombre;
       this.clave = clave;
       this.estado = estado;
       this.tramiteDatoses = tramiteDatoses;
       this.docusExtints = docusExtints;
       this.constanciases = constanciases;
       this.docusInternoses = docusInternoses;
       this.jefaturas = jefaturas;
       this.docusInternoses1 = docusInternoses1;
    }
   
    public String getUsu() {
        return this.usu;
    }
    
    public void setUsu(String usu) {
        this.usu = usu;
    }
    public Oficina getOficina() {
        return this.oficina;
    }
    
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public String getUsuNombre() {
        return this.usuNombre;
    }
    
    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set<TramiteDatos> getTramiteDatoses() {
        return this.tramiteDatoses;
    }
    
    public void setTramiteDatoses(Set<TramiteDatos> tramiteDatoses) {
        this.tramiteDatoses = tramiteDatoses;
    }
    public Set<DocusExtint> getDocusExtints() {
        return this.docusExtints;
    }
    
    public void setDocusExtints(Set<DocusExtint> docusExtints) {
        this.docusExtints = docusExtints;
    }
    public Set<Constancias> getConstanciases() {
        return this.constanciases;
    }
    
    public void setConstanciases(Set<Constancias> constanciases) {
        this.constanciases = constanciases;
    }
    public Set<DocusInternos> getDocusInternoses() {
        return this.docusInternoses;
    }
    
    public void setDocusInternoses(Set<DocusInternos> docusInternoses) {
        this.docusInternoses = docusInternoses;
    }
    public Set<Jefatura> getJefaturas() {
        return this.jefaturas;
    }
    
    public void setJefaturas(Set<Jefatura> jefaturas) {
        this.jefaturas = jefaturas;
    }

    public Set<DocusInternos> getDocusInternoses1() {
        return docusInternoses1;
    }

    public void setDocusInternoses1(Set<DocusInternos> docusInternoses1) {
        this.docusInternoses1 = docusInternoses1;
    }




}


