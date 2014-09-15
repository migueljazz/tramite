package maping;
// Generated 15/09/2014 03:43:43 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * MovimientoInterno generated by hbm2java
 */
public class MovimientoInterno  implements java.io.Serializable {


     private int idMoviint;
     private TramiteDatos tramiteDatos;
     private int moviNumint;
     private Date fechaEnvint;
     private Date fechaIngrint;
     private String obsMovint;
     private String estadInt;

    public MovimientoInterno() {
    }

	
    public MovimientoInterno(int idMoviint, int moviNumint, Date fechaEnvint) {
        this.idMoviint = idMoviint;
        this.moviNumint = moviNumint;
        this.fechaEnvint = fechaEnvint;
    }
    public MovimientoInterno(int idMoviint, TramiteDatos tramiteDatos, int moviNumint, Date fechaEnvint, Date fechaIngrint, String obsMovint, String estadInt) {
       this.idMoviint = idMoviint;
       this.tramiteDatos = tramiteDatos;
       this.moviNumint = moviNumint;
       this.fechaEnvint = fechaEnvint;
       this.fechaIngrint = fechaIngrint;
       this.obsMovint = obsMovint;
       this.estadInt = estadInt;
    }
   
    public int getIdMoviint() {
        return this.idMoviint;
    }
    
    public void setIdMoviint(int idMoviint) {
        this.idMoviint = idMoviint;
    }
    public TramiteDatos getTramiteDatos() {
        return this.tramiteDatos;
    }
    
    public void setTramiteDatos(TramiteDatos tramiteDatos) {
        this.tramiteDatos = tramiteDatos;
    }
    public int getMoviNumint() {
        return this.moviNumint;
    }
    
    public void setMoviNumint(int moviNumint) {
        this.moviNumint = moviNumint;
    }
    public Date getFechaEnvint() {
        return this.fechaEnvint;
    }
    
    public void setFechaEnvint(Date fechaEnvint) {
        this.fechaEnvint = fechaEnvint;
    }
    public Date getFechaIngrint() {
        return this.fechaIngrint;
    }
    
    public void setFechaIngrint(Date fechaIngrint) {
        this.fechaIngrint = fechaIngrint;
    }
    public String getObsMovint() {
        return this.obsMovint;
    }
    
    public void setObsMovint(String obsMovint) {
        this.obsMovint = obsMovint;
    }
    public String getEstadInt() {
        return this.estadInt;
    }
    
    public void setEstadInt(String estadInt) {
        this.estadInt = estadInt;
    }




}


