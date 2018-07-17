package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csPartidoRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("partido")
    private List<csPartido> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csPartido> getData() {
        return data;
    }

    public void setData(List<csPartido> data) {
        this.data = data;
    }
}
