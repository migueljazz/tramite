package maping;


import java.util.HashSet;
import java.util.Set;



public class TipoContrato  implements java.io.Serializable {


     private long idContrato;
     private String nombreContrato;
     private Set<Jefatura> jefaturas = new HashSet<Jefatura>(0);

    public TipoContrato() {
    }

	
    public TipoContrato(long idContrato) {
        this.idContrato = idContrato;
    }
    public TipoContrato(long idContrato, String nombreContrato, Set<Jefatura> jefaturas) {
       this.idContrato = idContrato;
       this.nombreContrato = nombreContrato;
       this.jefaturas = jefaturas;
    }
   
    public long getIdContrato() {
        return this.idContrato;
    }
    
    public void setIdContrato(long idContrato) {
        this.idContrato = idContrato;
    }
    public String getNombreContrato() {
        return this.nombreContrato;
    }
    
    public void setNombreContrato(String nombreContrato) {
        this.nombreContrato = nombreContrato;
    }
    public Set<Jefatura> getJefaturas() {
        return this.jefaturas;
    }
    
    public void setJefaturas(Set<Jefatura> jefaturas) {
        this.jefaturas = jefaturas;
    }




}


