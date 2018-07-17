package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csConfederacion {
    @SerializedName("_id")
    private String idconfederacion;
    @SerializedName("confederacion")
    private String confederacion;
    @SerializedName("acronimo")
    private String acronimo;
    @SerializedName("siglas")
    private String siglas;
    @SerializedName("fundacion")
    private String fundacion;
    @SerializedName("sede")
    private String sede;
    @SerializedName("ambito")
    private String ambito;
    @SerializedName("presidente")
    private String presidente;

    public csConfederacion(String idconfederacion, String confederacion, String acronimo, String siglas,
                     String fundacion, String sede, String ambito, String presidente) {

        this.idconfederacion = idconfederacion;
        this.confederacion = confederacion;
        this.acronimo = acronimo;
        this.siglas = siglas;
        this.fundacion = fundacion;
        this.sede = sede;
        this.ambito = ambito;
        this.presidente = presidente;
    }

    public String getIdconfederacion() {
        return idconfederacion;
    }

    public void setIdconfederacion(String idconfederacion ) {
        this.idconfederacion = idconfederacion;
    }

    public String getConfederacion() {
        return confederacion;
    }

    public void setConfederacion(String confederacion ) {
        this.confederacion = confederacion;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo ) {
        this.acronimo = acronimo ;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas ) {
        this.siglas = siglas ;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion ) {
        this.fundacion = fundacion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede ) {
        this.sede = sede;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito ) {
        this.ambito = ambito ;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente ) {
        this.presidente = presidente ;
    }
}
