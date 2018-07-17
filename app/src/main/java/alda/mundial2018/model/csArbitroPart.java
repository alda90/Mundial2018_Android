package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csArbitroPart {
    @SerializedName("_id")
    private String idarbitropart;
    @SerializedName("arbitro")
    private String arbitro;
    @SerializedName("partido")
    private String partido;
    @SerializedName("posicion")
    private String posicion;

    public csArbitroPart(String idarbitropart, String arbitro, String partido, String posicion) {

        this.idarbitropart = idarbitropart;
        this.arbitro = arbitro;
        this.partido =  partido;
        this.posicion = posicion;
    }

    public String getIdarbitropart() {
        return idarbitropart;
    }

    public void setIdarbitropart(String idarbitropart ) {
        this.idarbitropart = idarbitropart ;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro ) {
        this.arbitro = arbitro ;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido ) {
        this.partido = partido ;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion ) {
        this.posicion = posicion ;
    }

}
