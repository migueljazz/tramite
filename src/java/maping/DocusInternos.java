package maping;
// Generated 24/11/2014 03:02:40 PM by Hibernate Tools 3.6.0

import java.util.Date;

/**
 * DocusInternos generated by hbm2java
 */
public class DocusInternos implements java.io.Serializable {

    private int idtip;
    private TiposDocumentos tiposDocumentos;
    private TramiteDatos tramiteDatos;
    private Usuario usuario;
    private String docuCorrelaint;
    private String docuPricint;
    private String docuNombreint;
    private String docuSiglasint;
    private String docuAnioint;
    private Date fecharegistro;
    private String docuAsunto;
    private Dependencia dependenciaByCodigo;
    private Dependencia dependenciaByCodigo1;
    private String numeroMovi;

    public DocusInternos() {
    }

    public DocusInternos(int idtip, String docuCorrelaint, String docuPricint, String docuNombreint) {
        this.idtip = idtip;
        this.docuCorrelaint = docuCorrelaint;
        this.docuPricint = docuPricint;
        this.docuNombreint = docuNombreint;
    }

    public DocusInternos(int idtip, TiposDocumentos tiposDocumentos, TramiteDatos tramiteDatos, Usuario usuario, String docuCorrelaint, String docuPricint, String docuNombreint, String docuSiglasint, String docuAnioint, Date fecharegistro, String docuAsunto, Dependencia dependenciaByCodigo, Dependencia dependenciaByCodigo1, String numeroMovi) {
        this.idtip = idtip;
        this.tiposDocumentos = tiposDocumentos;
        this.tramiteDatos = tramiteDatos;
        this.usuario = usuario;
        this.docuCorrelaint = docuCorrelaint;
        this.docuPricint = docuPricint;
        this.docuNombreint = docuNombreint;
        this.docuSiglasint = docuSiglasint;
        this.docuAnioint = docuAnioint;
        this.fecharegistro = fecharegistro;
        this.docuAsunto = docuAsunto;
        this.dependenciaByCodigo = dependenciaByCodigo;
        this.dependenciaByCodigo1 = dependenciaByCodigo1;
        this.numeroMovi = numeroMovi;
    }

    public int getIdtip() {
        return this.idtip;
    }

    public void setIdtip(int idtip) {
        this.idtip = idtip;
    }

    public TiposDocumentos getTiposDocumentos() {
        return this.tiposDocumentos;
    }

    public void setTiposDocumentos(TiposDocumentos tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
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

    public String getDocuAsunto() {
        return this.docuAsunto;
    }

    public void setDocuAsunto(String docuAsunto) {
        this.docuAsunto = docuAsunto;
    }

    public Dependencia getDependenciaByCodigo() {
        return dependenciaByCodigo;
    }

    public void setDependenciaByCodigo(Dependencia dependenciaByCodigo) {
        this.dependenciaByCodigo = dependenciaByCodigo;
    }

    public Dependencia getDependenciaByCodigo1() {
        return dependenciaByCodigo1;
    }

    public void setDependenciaByCodigo1(Dependencia dependenciaByCodigo1) {
        this.dependenciaByCodigo1 = dependenciaByCodigo1;
    }

    public String getNumeroMovi() {
        return numeroMovi;
    }

    public void setNumeroMovi(String numeroMovi) {
        this.numeroMovi = numeroMovi;
    }

}
