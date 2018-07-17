package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csAlineacion {
    @SerializedName("_id")
    private String idalineacion;
    @SerializedName("estatus")
    private String estatus;
    @SerializedName("partido")
    private String partido;
    @SerializedName("jugador")
    private Object jugador;
    @SerializedName("pais")
    private Object pais;
    @SerializedName("capitan")
    private String capitan;

    public csAlineacion(String idalineacion, String estatus, String partido,
                        Object jugador, Object pais, String capitan) {

        this.idalineacion = idalineacion;
        this.estatus = estatus;
        this.partido = partido;
        this.jugador = jugador;
        this.pais = pais;
        this.capitan = capitan;
    }

    public String getIdalineacion() {
        return idalineacion;
    }

    public void setIdalineacion(String idalineacion ) {
        this.idalineacion = idalineacion ;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus ) {
        this.estatus = estatus ;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido ) {
        this.partido = partido ;
    }

    public Object getJugador() {
        return jugador;
    }

    public void setJugador(Object jugador ) {
        this.jugador = jugador ;
    }

    public Object getPais() {
        return pais;
    }

    public void setPais(Object pais ) {
        this.pais = pais ;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan ) {
        this.capitan = capitan;
    }
}
