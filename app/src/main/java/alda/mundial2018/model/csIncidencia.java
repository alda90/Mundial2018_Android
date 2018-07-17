package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csIncidencia {
    @SerializedName("_id")
    private String idincidencia;
    @SerializedName("incidencia")
    private String incidencia;
    @SerializedName("minuto")
    private String minuto;
    @SerializedName("numpenal")
    private String numpenal;
    @SerializedName("partido")
    private String partido;
    @SerializedName("jugador")
    private Object jugador;
    @SerializedName("sustituto")
    private Object sustituto;
    @SerializedName("tecnico")
    private Object tecnico;

    public csIncidencia(String idincidencia, String incidencia, String minuto, String numpenal, String partido,
                        Object jugador, Object sustituto, Object tecnico) {

        this.idincidencia = idincidencia;
        this.incidencia = incidencia;
        this.minuto =  minuto;
        this.numpenal = numpenal;
        this.partido = partido;
        this.jugador = jugador;
        this.sustituto = sustituto;
        this.tecnico = tecnico;
    }

    public String getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(String idincidencia ) {
        this.idincidencia = idincidencia ;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia ) {
        this.incidencia= incidencia ;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto ) {
        this.minuto = minuto ;
    }

    public String getNumpenal() {
        return numpenal;
    }

    public void setNumpenal(String numpenal ) {
        this.numpenal = numpenal;
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

    public Object getSustituto() {
        return sustituto;
    }

    public void setSustituto(Object sustituto ) {
        this.sustituto = sustituto ;
    }

    public Object getTecnico() {
        return tecnico;
    }

    public void setTecnico(Object tecnico ) {
        this.tecnico = tecnico;
    }

}
