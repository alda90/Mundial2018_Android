package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csGrupoRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("grupo")
    private List<csGrupo> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csGrupo> getData() {
        return data;
    }

    public void setData(List<csGrupo> data) {
        this.data = data;
    }
}
