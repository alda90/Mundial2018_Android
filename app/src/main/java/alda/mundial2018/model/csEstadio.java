package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csEstadio {
    @SerializedName("_id")
    private String idestadio;
    @SerializedName("estadio")
    private String estadio;
    @SerializedName("completo")
    private String completo;
    @SerializedName("estadiolocal")
    private String estadiolocal;
    @SerializedName("capacidad")
    private String capacidad;
    @SerializedName("sede")
    private Object sede;
    @SerializedName("img")
    private String img;

    public csEstadio(String idestadio, String estadio, String completo,
                     String estadiolocal, String capacidad, Object sede, String img) {

        this.idestadio = idestadio;
        this.estadio = estadio;
        this.completo = completo;
        this.estadiolocal = estadiolocal;
        this.capacidad = capacidad;
        this.sede = sede;
        this.img = img;
    }

    public String getIdestadio() {
        return idestadio;
    }

    public void setIdestadio(String idestadio ) {
        this.idestadio = idestadio;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio ) {
        this.estadio = estadio;
    }

    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo ) {
        this.completo = completo ;
    }

    public String getEstadiolocal() {
        return estadiolocal;
    }

    public void setEstadiolocal(String estadiolocal ) {
        this.estadiolocal = estadiolocal ;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad ) {
        this.capacidad = capacidad;
    }

    public Object getSede() {
        return sede;
    }

    public void setSede(Object sede ) {
        this.sede = sede;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img ) {
        this.img = img ;
    }
}
