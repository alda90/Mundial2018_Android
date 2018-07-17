package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csPais {
    @SerializedName("_id")
    private String idpais;
    @SerializedName("pais")
    private String pais;
    @SerializedName("nombreingles")
    private String nombreingles;
    @SerializedName("nombrelocal")
    private String nombrelocal;
    @SerializedName("federacion")
    private String federacion;
    @SerializedName("federacioningles")
    private String federacioningles;
    @SerializedName("federacionlocal")
    private String federacionlocal;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("goleador")
    private String goleador;
    @SerializedName("numgoles")
    private String numgoles;
    @SerializedName("bandera")
    private String bandera;
    @SerializedName("uniforme")
    private String uniforme;
    @SerializedName("uniformev")
    private String uniformev;
    @SerializedName("clasificacion")
    private String clasificacion;
    @SerializedName("participaciones")
    private String participaciones;
    @SerializedName("titulos")
    private String titulos;
    @SerializedName("escudo")
    private String escudo;
    @SerializedName("escudofed")
    private String escudofed;
    @SerializedName("continente")
    private String continente;
    @SerializedName("tecnico")
    private String tecnico;
    @SerializedName("confederacion")
    private String confederacion;

    public csPais(String idpais, String pais, String nombreingles, String nombrelocal, String federacion, String federacioningles,
                  String federacionlocal, String codigo, String goleador, String numgoles, String bandera, String uniforme,
                  String uniformev, String clasificacion, String participaciones, String titulos, String escudo,
                  String escudofed, String continente, String tecnico, String confederacion) {

        this.idpais = idpais;
        this.pais =  pais;
        this.nombreingles = nombreingles;
        this.nombrelocal = nombrelocal;
        this.federacion = federacion;
        this.federacioningles = federacioningles;
        this.federacionlocal = federacionlocal;
        this.codigo = codigo;
        this.goleador = goleador;
        this.numgoles = numgoles;
        this.bandera = bandera;
        this.uniforme = uniforme;
        this.uniformev = uniformev;
        this.clasificacion = clasificacion;
        this.participaciones = participaciones;
        this.titulos = titulos;
        this.escudo = escudo;
        this.escudofed = escudofed;
        this.continente = continente;
        this.tecnico = tecnico;
        this.confederacion = confederacion;
    }

    public String getIdpais() {
        return idpais;
    }

    public void setIdpais(String idpais ) {
        this.idpais = idpais ;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais ) {
        this.pais = pais ;
    }

    public String getNombreingles() {
        return nombreingles;
    }

    public void setNombreingles(String nombreingles ) {
        this.nombreingles = nombreingles ;
    }

    public String getNombrelocal() {
        return nombrelocal;
    }

    public void setNombrelocal(String nombrelocal ) {
        this.nombrelocal = nombrelocal ;
    }

    public String getFederacion() {
        return federacion;
    }

    public void setFederacion(String federacion ) {
        this.federacion = federacion ;
    }

    public String getFederacioningles() {
        return federacioningles;
    }

    public void setFederacioningles(String federacioningles ) {
        this.federacioningles = federacioningles ;
    }

    public String getFederacionlocal() {
        return federacionlocal;
    }

    public void setFederacionlocal(String federacionlocal ) {
        this.federacionlocal = federacionlocal ;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo ) {
        this.codigo = codigo ;
    }

    public String getGoleador() {
        return goleador;
    }

    public void setGoleador(String goleador ) {
        this.goleador = goleador ;
    }

    public String getNumgoles() {
        return numgoles;
    }

    public void setNumgoles(String numgoles ) {
        this.numgoles = numgoles ;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera ) {
        this.bandera = bandera;
    }

    public String getUniforme() {
        return uniforme;
    }

    public void setUniforme(String uniforme ) {
        this.uniforme = uniforme ;
    }

    public String getUniformev() {
        return uniformev;
    }

    public void setUniformev(String uniformev ) {
        this.uniformev = uniformev ;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion ) {
        this.clasificacion = clasificacion ;
    }

    public String getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(String participaciones ) {
        this.participaciones = participaciones ;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos ) {
        this.titulos = titulos ;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo ) {
        this.escudo = escudo ;
    }

    public String getEscudofed() {
        return escudofed;
    }

    public void setEscudofed(String escudofed ) {
        this.escudofed = escudofed ;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente ) {
        this.continente = continente ;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico ) {
        this.tecnico = tecnico ;
    }

    public String getConfederacion() {
        return confederacion;
    }

    public void setConfederacion(String confederacion ) {
        this.confederacion = confederacion ;
    }
}
