package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csTecnicoRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("tecnico")
    private List<csTecnico> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csTecnico> getData() {
        return data;
    }

    public void setData(List<csTecnico> data) {
        this.data = data;
    }
}
