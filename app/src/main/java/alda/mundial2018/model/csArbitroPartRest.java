package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 12/05/18.
 */

public class csArbitroPartRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("arbitrospart")
    private List<csArbitroPart> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csArbitroPart> getData() {
        return data;
    }

    public void setData(List<csArbitroPart> data) {
        this.data = data;
    }
}
