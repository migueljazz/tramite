package maping;
// Generated 23/10/2014 05:20:25 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * DocusInternos generated by hbm2java
 */
public class DocusInternos  implements java.io.Serializable {


     private int idtip;
     private TramiteDatos tramiteDatos;
     private Usuario usuario;
     private String docuCorrelaint;
     private String docuPricint;
     private String docuNombreint;
     private String docuSiglasint;
     private String docuAnioint;
     private Date fecharegistro;

    public DocusInternos() {
    }

	
    public DocusInternos(int idtip, String docuCorrelaint, String docuPricint, String docuNombreint) {
        this.idtip = idtip;
        this.docuCorrelaint = docuCorrelaint;
        this.docuPricint = docuPricint;
        this.docuNombreint = docuNombreint;
    }
    public DocusInternos(int idtip, TramiteDatos tramiteDatos, Usuario usuario, String docuCorrelaint, String docuPricint, String docuNombreint, String docuSiglasint, String docuAnioint, Date fecharegistro) {
       this.idtip = idtip;
       this.tramiteDatos = tramiteDatos;
       this.usuario = usuario;
       this.docuCorrelaint = docuCorrelaint;
       this.docuPricint = docuPricint;
       this.docuNombreint = docuNombreint;
       this.docuSiglasint = docuSiglasint;
       this.docuAnioint = docuAnioint;
       this.fecharegistro = fecharegistro;
    }
   
    public int getIdtip() {
        return this.idtip;
    }
    
    public void setIdtip(int idtip) {
        this.idtip = idtip;
    }
    public TramiteDatos getTramiteDatos() {
        return this.tramiteDatos;
    }
    
    public void setTramiteDatos(TramiteDatos tramiteDatos) {
        this.tramiteDatos = tramiteDatos;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getDocuCorrelaint() {
        return this.docuCorrelaint;
    }
    
    public void setDocuCorrelaint(String docuCorrelaint) {
        this.docuCorrelaint = docuCorrelaint;
    }
    public String getDocuPricint() {
        return this.docuPricint;
    }
    
    public void setDocuPricint(String docuPricint) {
        this.docuPricint = docuPricint;
    }
    public String getDocuNombreint() {
        return this.docuNombreint;
    }
    
    public void setDocuNombreint(String docuNombreint) {
        this.docuNombreint = docuNombreint;
    }
    public String getDocuSiglasint() {
        return this.docuSiglasint;
    }
    
    public void setDocuSiglasint(String docuSiglasint) {
        this.docuSiglasint = docuSiglasint;
    }
    public String getDocuAnioint() {
        return this.docuAnioint;
    }
    
    public void setDocuAnioint(String docuAnioint) {
        this.docuAnioint = docuAnioint;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }




}


