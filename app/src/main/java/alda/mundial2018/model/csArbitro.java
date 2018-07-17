package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csArbitro {
    @SerializedName("_id")
    private String idarbitro;
    @SerializedName("arbitro")
    private String arbitro;
    @SerializedName("pais")
    private String pais;
    @SerializedName("posicion")
    private String posicion;
    @SerializedName("bandera")
    private String bandera;

    public csArbitro(String idarbitro, String arbitro, String pais, String posicion, String bandera) {

        this.idarbitro = idarbitro;
        this.arbitro = arbitro;
        this.pais =  pais;
        this.posicion = posicion;
        this.bandera = bandera;
    }

    public String getIdarbitro() {
        return idarbitro;
    }

    public void setIdarbitro(String idarbitro ) {
        this.idarbitro = idarbitro ;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro ) {
        this.arbitro = arbitro ;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais ) {
        this.pais = pais ;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion ) {
        this.posicion = posicion ;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera ) {
        this.bandera = bandera;
    }
}
