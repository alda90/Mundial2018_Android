package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csPartido {
    @SerializedName("_id")
    private String idpartido;
    @SerializedName("partido")
    private String partido;
    @SerializedName("local")
    private Object local;
    @SerializedName("visitante")
    private Object visitante;
    @SerializedName("goleslocal")
    private String goleslocal;
    @SerializedName("golesvisitante")
    private String golesvisitante;
    @SerializedName("ganador")
    private String ganador;
    @SerializedName("estatus")
    private String estatus;
    @SerializedName("conclusion")
    private String conclusion;
    @SerializedName("goleslocalp")
    private String goleslocalp;
    @SerializedName("golesvisitantep")
    private String golesvisitantep;
    @SerializedName("fase")
    private String fase;
    @SerializedName("fecha")
    private String fecha;
    @SerializedName("hora")
    private String hora;
    //@SerializedName("grupo")
    //private String grupo;
    //@SerializedName("estadio")
    //private String estadio;

    public csPartido(String idpartido,String partido, Object local, Object visitante,  String goleslocal, String golesvisitante, String ganador,
                     String estatus, String conclusion, String goleslocalp, String golesvisitantep, String fase, String fecha,
                     String hora) {

        this.idpartido = idpartido;
        this.partido = partido;
        this.local = local;
        this.visitante =  visitante;
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
        this.ganador = ganador;
        this.estatus = estatus;
        this.conclusion = conclusion;
        this.goleslocalp = goleslocalp;
        this.golesvisitantep = golesvisitantep;
        this.fase = fase;
        this.fecha = fecha;
        this.hora = hora;
        //this.grupo = grupo;
        //this.estadio = estadio;
    }

    public String getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(String idpartido ) {
        this.idpartido = idpartido ;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido ) {
        this.partido = partido ;
    }

    public Object  getLocal() {
        return local;
    }

    public void setLocal (Object local) {
        this.local = local;
    }

    public Object getVisitante() {
        return visitante;
    }

    public void setVisitante(Object visitante) {
        this.visitante = visitante;
    }

    public String getGoleslocal() {
        return goleslocal;
    }

    public void setGoleslocal(String goleslocal) {
        this.goleslocal = goleslocal;
    }

    public String getGolesvisitante() {
        return golesvisitante;
    }

    public void setGolesvisitante(String golesvisitante) {
        this.golesvisitante = golesvisitante;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getGoleslocalp() {
        return goleslocalp;
    }

    public void setGoleslocalp(String goleslocalp) {
        this.goleslocalp = goleslocalp;
    }

    public String getGolesvisitantep() {
        return golesvisitantep;
    }

    public void setGolesvisitantep(String golesvisitantep) {
        this.golesvisitantep = golesvisitantep;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    /*public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }*/

}
