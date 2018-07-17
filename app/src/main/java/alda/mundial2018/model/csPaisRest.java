package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csPaisRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("pais")
    private List<csPais> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csPais> getData() {
        return data;
    }

    public void setData(List<csPais> data) {
        this.data = data;
    }
}
