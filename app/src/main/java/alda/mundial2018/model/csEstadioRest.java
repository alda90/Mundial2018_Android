package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csEstadioRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("estadio")
    private List<csEstadio> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csEstadio> getData() {
        return data;
    }

    public void setData(List<csEstadio> data) {
        this.data = data;
    }
}
