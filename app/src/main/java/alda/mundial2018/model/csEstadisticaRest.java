package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csEstadisticaRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("estadistica")
    private List<csEstadistica> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csEstadistica> getData() {
        return data;
    }

    public void setData(List<csEstadistica> data) {
        this.data = data;
    }
}
