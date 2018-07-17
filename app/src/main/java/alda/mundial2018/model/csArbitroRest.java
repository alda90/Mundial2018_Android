package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csArbitroRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("arbitro")
    private List<csArbitro> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csArbitro> getData() {
        return data;
    }

    public void setData(List<csArbitro> data) {
        this.data = data;
    }
}
