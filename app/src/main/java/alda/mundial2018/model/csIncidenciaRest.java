package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csIncidenciaRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("incidencia")
    private List<csIncidencia> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csIncidencia> getData() {
        return data;
    }

    public void setData(List<csIncidencia> data) {
        this.data = data;
    }
}
