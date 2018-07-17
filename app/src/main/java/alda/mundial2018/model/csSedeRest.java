package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csSedeRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("sede")
    private List<csSede> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csSede> getData() {
        return data;
    }

    public void setData(List<csSede> data) {
        this.data = data;
    }
}
