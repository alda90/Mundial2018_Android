package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csJugador {
    @SerializedName("_id")
    private String idjugador;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("nombrecompleto")
    private String nombrecompleto;
    @SerializedName("nombrelocal")
    private String nombrelocal;
    @SerializedName("pais")
    private Object pais;
    @SerializedName("nacimiento")
    private String nacimiento;
    @SerializedName("fechanac")
    private String fechanac;
    @SerializedName("numero")
    private String numero;
    @SerializedName("posicion")
    private String posicion;
    @SerializedName("img")
    private String img;

    public csJugador(String idjugador, String nombre, String nombrecompleto, String nombrelocal, Object pais,
                     String nacimiento, String fechanac, String numero, String posicion, String img) {

        this.idjugador = idjugador;
        this.nombre = nombre;
        this.nombrecompleto = nombrecompleto;
        this.nombrelocal = nombrelocal;
        this.pais =  pais;
        this.nacimiento = nacimiento;
        this.fechanac = fechanac;
        this.numero = numero;
        this.posicion = posicion;
        this.img = img;
    }

    public String getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(String idjugador ) {
        this.idjugador = idjugador ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre ) {
        this.nombre = nombre ;
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

    public Object getPais() {
        return pais;
    }

    public void setPais(Object pais ) {
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero ) {
        this.numero = numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion ) {
        this.posicion = posicion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img ) {
        this.img = img ;
    }
}
