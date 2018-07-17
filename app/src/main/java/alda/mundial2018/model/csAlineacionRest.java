package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csAlineacionRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("alineacion")
    private List<csAlineacion> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csAlineacion> getData() {
        return data;
    }

    public void setData(List<csAlineacion> data) {
        this.data = data;
    }
}
