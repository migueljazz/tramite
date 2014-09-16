/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DerivarDAO;
import dao.DocumentoDAO;
import dao.SeguimientoDAO;
import daoimpl.DerivarDaoImpl;
import daoimpl.DocumentoDaoImpl;
import daoimpl.SeguimientoDaoImpl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
public class DocumentoUsuarioBean {

    private List seguimientolista2;
    private List seguimientolista;
    private List otrosdocus;
    private List docselec;
    private List detalle;
    private Map<String, String> seleccion;
    private DocumentoDAO dd;
    private Date fecha;
    private Usuario usu;
    private String fechadia;
    private String fechahora;
    private String motivo = "";
    private String usuario = "";
    private final FacesContext faceContext;
    private String codinterno;
    private SeguimientoDAO sgd;
    private String numtramaux;
    private String asunto;
    private String siglasdocus;
    private DerivarDAO deriv;
    private String correlativo;
    private String docunombre;
    private String estado;
    private boolean confirmar = false;

    public DocumentoUsuarioBean() {
        dd = new DocumentoDaoImpl();
        faceContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) faceContext.getExternalContext().getSession(true);
        usu = (Usuario) session.getAttribute("sesionUsuario");
        seguimientolista2 = new ArrayList<Map<String, String>>();
        seguimientolista = new ArrayList<Map<String, String>>();
        detalle = new ArrayList<Map<String, String>>();
        sgd = new SeguimientoDaoImpl();
        deriv = new DerivarDaoImpl();
        MostrarParaUsuario();
    }

    public void MostrarParaUsuario() {
        System.out.println("listando documentos2");
        seguimientolista2.clear();
        try {
            System.out.println("entra a seguimiento2");
            List lista = new ArrayList();
            System.out.println(usu.getOficina().getIdOficina());
            lista = sgd.seguimientoUser(usu.getOficina().getIdOficina());
            Iterator ite = lista.iterator();
            Object obj[] = new Object[9];
            while (ite.hasNext()) {
                obj = (Object[]) ite.next();
                Map<String, String> listaaux = new HashMap<String, String>();
                listaaux.put("numerotramite", String.valueOf(obj[0]));
                listaaux.put("movimnum", String.valueOf(obj[1]));
                listaaux.put("origen", String.valueOf(obj[2]));
                listaaux.put("destino", String.valueOf(obj[3]));
                listaaux.put("fechaenvio", String.valueOf(obj[4]));
                listaaux.put("fechaingr", String.valueOf(obj[5]));
                listaaux.put("indicador", String.valueOf(obj[6]));
                listaaux.put("observacion", String.valueOf(obj[7]));
                listaaux.put("estado", String.valueOf(obj[8]));
                seguimientolista2.add(listaaux);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String generarCorrelativo() {
        int corr = 0;
        String aux = "";
        try {
            System.out.println("lleno");
            corr = Integer.parseInt(deriv.getIndice());
            corr = corr + 1;
            aux = "0000" + corr;
        } catch (Exception e) {
            System.out.println("no lleno");
            corr = corr + 1;
            aux = "0000" + corr;
        }
        return aux;
    }

    public List Detalles() {
        System.out.println("listando detalles");
        detalle.clear();
        try {
            List lista = new ArrayList();
            System.out.println(seleccion.get("numerotramite").toString());
            lista = dd.getDetalle(seleccion.get("numerotramite").toString());
            Iterator ite = lista.iterator();
            Object obj[] = new Object[6];
            while (ite.hasNext()) {
                obj = (Object[]) ite.next();
                Map<String, String> listaaux = new HashMap<String, String>();
                listaaux.put("usuario", String.valueOf(obj[0]));
                listaaux.put("oficina", String.valueOf(obj[1]));
                listaaux.put("docunombre", String.valueOf(obj[2]));
                listaaux.put("docunumero", String.valueOf(obj[3]));
                listaaux.put("docusiglas", String.valueOf(obj[4]));
                listaaux.put("docuanio", String.valueOf(obj[5]));
                detalle.add(listaaux);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return detalle;
    }

    public void Derivar() {
        numtramaux = "";
        if (!usu.getOficina().getIdOficina().equals("100392")) {
            correlativo = generarCorrelativo();
            siglasdocus = deriv.getSiglas(usu.getOficina().getIdOficina());
            IniciarFecha();
            Motivo();
            UsuarioSelec();
            confirmar=false;
        } else {
            if (usu.getOficina().getIdOficina().equals("100392")) {
                IniciarFecha();
                Motivo();
                UsuarioSelec();
                confirmar = true;
            }
        }

    }

    public void Guardar() {
        try {
            fecha = new Date();
            DateFormat d = new SimpleDateFormat("yyyy");
            System.out.println("entra a guardar");
            if (confirmar == true) {
                System.out.println("entra a confirmar true");
                deriv.InsertarMovimiento(deriv.getMovimiento(numtramaux) + 1, fecha, asunto, estado, numtramaux, getNombOficina(), codinterno);
            } else if (confirmar==false) {
                System.out.println("entra a confirmar false");
                deriv.InsertarMovimiento(deriv.getMovimiento(numtramaux) + 1, fecha, asunto, estado, numtramaux, getNombOficina(), codinterno);
                deriv.InsertarTipoDocus(correlativo,docunombre, 1, siglasdocus, d.format(fecha), numtramaux);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNombOficina() {
        String oficina = dd.getOficina(usu);
        return oficina;
    }

    public void IniciarFecha() {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        fecha = new Date();
        fechadia = "";
        fechahora = "";
        StringTokenizer tokens = new StringTokenizer(formato.format(fecha), " ");
        while (tokens.hasMoreTokens()) {
            if (fechadia.equals("")) {
                fechadia = tokens.nextToken();
            }
            if (fechahora.equals("")) {
                fechahora = tokens.nextToken();
            }
        }
    }

    public void Motivo() {
        try {
            Map<String, String> hm = (HashMap<String, String>) docselec.get(0);
            Iterator it = hm.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                if (e.getKey().toString().equals("numerotramite")) {
                    System.out.println(e.getValue().toString());
                    numtramaux = e.getValue().toString();
                    motivo = dd.getMotivo(e.getValue().toString());
                }

            }

            docselec.clear();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void UsuarioSelec() {
        try {
            usuario = usu.getUsuNombre();
        } catch (Exception e) {
            System.out.println("error2");
            System.out.println(e.getMessage());
        }
    }

    public void MostrarSeguimiento(String tramnum) {
        System.out.println("listando documentos");
        seguimientolista.clear();
        try {
            List lista = new ArrayList();
            lista = sgd.getSeguimiento(tramnum);
            Iterator ite = lista.iterator();
            Object obj[] = new Object[9];
            while (ite.hasNext()) {
                obj = (Object[]) ite.next();
                Map<String, String> listaaux = new HashMap<String, String>();
                listaaux.put("numerotramite", String.valueOf(obj[0]));
                listaaux.put("movimnum", String.valueOf(obj[1]));
                listaaux.put("origen", String.valueOf(obj[2]));
                listaaux.put("destino", String.valueOf(obj[3]));
                listaaux.put("fechaenvio", String.valueOf(obj[4]));
                listaaux.put("fechaingr", String.valueOf(obj[5]));
                listaaux.put("indicador", String.valueOf(obj[6]));
                listaaux.put("observacion", String.valueOf(obj[7]));
                listaaux.put("estado", String.valueOf(obj[8]));
                seguimientolista.add(listaaux);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void RecorrerLista() {
        Map<String, String> hm = (HashMap<String, String>) docselec.get(0);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            if (e.getKey().toString().equals("numerotramite")) {
                System.out.println(e.getValue().toString());
                MostrarSeguimiento(e.getValue().toString());
            }

        }
        docselec.clear();

    }

    public DerivarDAO getDeriv() {
        return deriv;
    }

    public void setDeriv(DerivarDAO deriv) {
        this.deriv = deriv;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public List getSeguimientolista2() {
        return seguimientolista2;
    }

    public void setSeguimientolista2(List seguimientolista2) {
        this.seguimientolista2 = seguimientolista2;
    }

    public List getOtrosdocus() {
        return otrosdocus;
    }

    public void setOtrosdocus(List otrosdocus) {
        this.otrosdocus = otrosdocus;
    }

    public List getDocselec() {
        return docselec;
    }

    public void setDocselec(List docselec) {
        this.docselec = docselec;
    }

    public Map<String, String> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Map<String, String> seleccion) {
        this.seleccion = seleccion;
    }

    public DocumentoDAO getDd() {
        return dd;
    }

    public void setDd(DocumentoDAO dd) {
        this.dd = dd;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String getFechadia() {
        return fechadia;
    }

    public void setFechadia(String fechadia) {
        this.fechadia = fechadia;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCodinterno() {
        return codinterno;
    }

    public void setCodinterno(String codinterno) {
        this.codinterno = codinterno;
    }

    public List getDetalle() {
        return detalle;
    }

    public void setDetalle(List detalle) {
        this.detalle = detalle;
    }

    public SeguimientoDAO getSgd() {
        return sgd;
    }

    public void setSgd(SeguimientoDAO sgd) {
        this.sgd = sgd;
    }

    public List getSeguimientolista() {
        return seguimientolista;
    }

    public void setSeguimientolista(List seguimientolista) {
        this.seguimientolista = seguimientolista;
    }

    public String getNumtramaux() {
        return numtramaux;
    }

    public void setNumtramaux(String numtramaux) {
        this.numtramaux = numtramaux;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getSiglasdocus() {
        return siglasdocus;
    }

    public void setSiglasdocus(String siglasdocus) {
        this.siglasdocus = siglasdocus;
    }

    public String getDocunombre() {
        return docunombre;
    }

    public void setDocunombre(String docunombre) {
        this.docunombre = docunombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

}