package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csTecnico {
    @SerializedName("_id")
    private String idtecnico;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("pais")
    private String pais;
    @SerializedName("nacimiento")
    private String nacimiento;
    @SerializedName("fechanac")
    private String fechanac;
    @SerializedName("nombrecompleto")
    private String nombrecompleto;
    @SerializedName("nombrelocal")
    private String nombrelocal;
    @SerializedName("bandera")
    private String bandera;
    @SerializedName("img")
    private String img;

    public csTecnico(String idtecnico, String nombre, String pais, String nacimiento, String fechanac, String nombrecompleto,
                     String nombrelocal, String bandera, String img) {

        this.idtecnico = idtecnico;
        this.nombre = nombre;
        this.pais =  pais;
        this.nacimiento = nacimiento;
        this.fechanac = fechanac;
        this.nombrecompleto = nombrecompleto;
        this.nombrelocal = nombrelocal;
        this.bandera = bandera;
        this.img = img;
    }

    public String getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(String idtecnico ) {
        this.idtecnico = idtecnico ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre ) {
        this.nombre = nombre ;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais ) {
        this.pais = pais ;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento ) {
        this.nacimiento = nacimiento ;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac ) {
        this.fechanac = fechanac ;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto ) {
        this.nombrecompleto = nombrecompleto ;
    }

    public String getNombrelocal() {
        return nombrelocal;
    }

    public void setNombrelocal(String nombrelocal ) {
        this.nombrelocal = nombrelocal ;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera ) {
        this.bandera = bandera;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img ) {
        this.img = img ;
    }

}
