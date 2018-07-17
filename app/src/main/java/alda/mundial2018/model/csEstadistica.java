package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csEstadistica {
    @SerializedName("_id")
    private String idestadistica;
    @SerializedName("partidos")
    private String partidos;
    @SerializedName("puntos")
    private String puntos;
    @SerializedName("anotados")
    private String anotados;
    @SerializedName("recibidos")
    private String recibidos;
    @SerializedName("diferencia")
    private String diferencia;
    @SerializedName("ganados")
    private String ganados;
    @SerializedName("empatados")
    private String empatados;
    @SerializedName("perdidos")
    private String perdidos;
    @SerializedName("pais")
    private Object pais;
    @SerializedName("grupo")
    private Object grupo;

    public csEstadistica(String idestadistica, String partidos, String puntos, String anotados, String recibidos,
                         String diferencia, String ganados, String empatados, String perdidos, Object pais, Object grupo) {

        this.idestadistica = idestadistica;
        this.partidos = partidos;
        this.puntos =  puntos;
        this.anotados = anotados;
        this.recibidos = recibidos;
        this.diferencia = diferencia;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
        this.pais = pais;
        this.grupo = grupo;
    }

    public String getIdestadistica() {
        return idestadistica;
    }

    public void setIdestadistica(String idestadistica ) {
        this.idestadistica = idestadistica ;
    }

    public String getPartidos() {
        return partidos;
    }

    public void setPartidos(String partidos ) {
        this.partidos = partidos ;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos ) {
        this.puntos = puntos;
    }

    public String getAnotados() {
        return anotados;
    }

    public void setAnotados(String anotados ) {
        this.anotados = anotados ;
    }

    public String getRecibidos() {
        return recibidos;
    }

    public void setRecibidos(String recibidos ) {
        this.recibidos = recibidos ;
    }

    public String getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(String diferencia) {
        this.diferencia = diferencia ;
    }

    public String getGanados() {
        return ganados;
    }

    public void setGanados(String ganados ) {
        this.ganados = ganados;
    }

    public String getEmpatados() {
        return empatados;
    }

    public void setEmpatados(String empatados ) {
        this.empatados = empatados;
    }

    public String getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(String perdidos ) {
        this.perdidos = perdidos ;
    }

    public Object getPais() {
        return pais;
    }

    public void setPais(Object pais ) {
        this.pais = pais ;
    }

    public Object getGrupo() {
        return grupo;
    }

    public void setGrupo(Object grupo) {
        this.grupo = grupo ;
    }
}
