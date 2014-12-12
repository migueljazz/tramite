/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import static bean.DocumentosBean.tranum;
import dao.DerivarDAO;
import dao.ProveidosInternosDao;
import daoimpl.DerivarDaoImpl;
import daoimpl.ProveidosInternosDaoImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import maping.Usuario;

/**
 *
 * @author OGPL
 */
@ManagedBean
@ViewScoped
public class ProveidosInternosBean {

    private List documentos_internos, docselec, otrosdocus;
    private ProveidosInternosDao pid;
    private Usuario usu;
    private final FacesContext faceContext;
    private Date fechaprov;
    private String fechaaux, tramnum;
    private Date fecha;
    private String correlativo_proveido,origen_prov,destino_prov,siglasdocus,anio,asunto;
    private DerivarDAO deriv;
    private boolean mostrar = false, hecho, nohecho,ver,no_ver;

    public ProveidosInternosBean() {
        fechaprov=new Date();
        fecha= new Date();
        deriv= new DerivarDaoImpl();
        documentos_internos = new ArrayList<Map<String, String>>();
        faceContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) faceContext.getExternalContext().getSession(true);
        usu = (Usuario) session.getAttribute("sesionUsuario");
        pid = new ProveidosInternosDaoImpl();
        getLista();
    }

    public void getLista() {
        System.out.println("listando documentos internos");
        this.documentos_internos.clear();
        try {
            List lista = new ArrayList();
            lista = pid.getDocumentosInternos();
            Iterator ite = lista.iterator();
            Object obj[] = new Object[7];
            while (ite.hasNext()) {
                obj = (Object[]) ite.next();
                Map<String, String> listaaux = new HashMap<String, String>();
                listaaux.put("documento", String.valueOf(obj[0]));
                listaaux.put("fecha", String.valueOf(obj[1]));
                listaaux.put("asunto", String.valueOf(obj[2]));
                listaaux.put("origen", String.valueOf(obj[3]));
                listaaux.put("destino", String.valueOf(obj[4]));
                listaaux.put("usuario", String.valueOf(obj[5]));
                listaaux.put("nombredocu", String.valueOf(obj[6]));
                documentos_internos.add(listaaux);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void mostrarProveido() {
        fechaprov = new Date();
        System.out.println(docselec);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY");
        fechaaux = sdf.format(fechaprov);
        Map<String, String> hm = (HashMap<String, String>) docselec.get(0);
        tramnum = hm.get("documento").toString();
        generarCorrelativo_proveido();
        origen_prov = hm.get("origen").toString();
        destino_prov = hm.get("destino").toString();
        tranum = correlativo_proveido;
        siglasdocus = deriv.getSiglas(usu.getOficina().getIdOficina(), usu.getUsu());
        anio = sdf2.format(fechaprov);
    }

    public void generarCorrelativo_proveido() {
        int corr = 0;
        String aux = "";
        try {
            if (getAnio().equals(deriv.getAnio())) {
                System.out.println("lleno 1");
                corr = Integer.parseInt(deriv.getCorreProv());
                System.out.println("aumentando el correlativo: " + corr);
                corr = corr + 1;
                if (corr < 10) {
                    aux = "0000" + corr;
                }
                if (corr > 9 && corr < 100) {
                    aux = "000" + corr;
                }
                if (corr > 99 && corr < 1000) {
                    aux = "00" + corr;
                }
                if (corr > 999 && corr < 10000) {
                    aux = "0" + corr;
                }
                if (corr > 10000) {
                    aux = String.valueOf(corr);
                }
            } else {
                System.out.println("lleno 2");
                corr = corr + 1;
                aux = "0000" + corr;
            }

        } catch (Exception e) {
            System.out.println("no lleno");
            corr = corr + 1;
            aux = "0000" + corr;
            System.out.println(corr);
            System.out.println(aux);
        }
        correlativo_proveido = aux;
    }
    public String getAnio() {
        fecha= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
        return sdf.format(fecha);
    }

    public List getDocumentos_internos() {
        return documentos_internos;
    }

    public void setDocumentos_internos(List documentos_internos) {
        this.documentos_internos = documentos_internos;
    }

    public List getDocselec() {
        return docselec;
    }

    public void setDocselec(List docselec) {
        this.docselec = docselec;
    }

    public ProveidosInternosDao getPid() {
        return pid;
    }

    public void setPid(ProveidosInternosDao pid) {
        this.pid = pid;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public List getOtrosdocus() {
        return otrosdocus;
    }

    public void setOtrosdocus(List otrosdocus) {
        this.otrosdocus = otrosdocus;
    }

    public Date getFechaprov() {
        return fechaprov;
    }

    public void setFechaprov(Date fechaprov) {
        this.fechaprov = fechaprov;
    }

    public String getFechaaux() {
        return fechaaux;
    }

    public void setFechaaux(String fechaaux) {
        this.fechaaux = fechaaux;
    }

    public String getTramnum() {
        return tramnum;
    }

    public void setTramnum(String tramnum) {
        this.tramnum = tramnum;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCorrelativo_proveido() {
        return correlativo_proveido;
    }

    public void setCorrelativo_proveido(String correlativo_proveido) {
        this.correlativo_proveido = correlativo_proveido;
    }

    public String getOrigen_prov() {
        return origen_prov;
    }

    public void setOrigen_prov(String origen_prov) {
        this.origen_prov = origen_prov;
    }

    public String getDestino_prov() {
        return destino_prov;
    }

    public void setDestino_prov(String destino_prov) {
        this.destino_prov = destino_prov;
    }

    public String getSiglasdocus() {
        return siglasdocus;
    }

    public void setSiglasdocus(String siglasdocus) {
        this.siglasdocus = siglasdocus;
    }

    public DerivarDAO getDeriv() {
        return deriv;
    }

    public void setDeriv(DerivarDAO deriv) {
        this.deriv = deriv;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public boolean isHecho() {
        return hecho;
    }

    public void setHecho(boolean hecho) {
        this.hecho = hecho;
    }

    public boolean isNohecho() {
        return nohecho;
    }

    public void setNohecho(boolean nohecho) {
        this.nohecho = nohecho;
    }

    public boolean isVer() {
        return ver;
    }

    public void setVer(boolean ver) {
        this.ver = ver;
    }

    public boolean isNo_ver() {
        return no_ver;
    }

    public void setNo_ver(boolean no_ver) {
        this.no_ver = no_ver;
    }

}