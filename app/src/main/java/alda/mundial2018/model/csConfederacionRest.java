package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csConfederacionRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("confederacion")
    private List<csConfederacion> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csConfederacion> getData() {
        return data;
    }

    public void setData(List<csConfederacion> data) {
        this.data = data;
    }
}
