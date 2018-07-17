package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csJugadorRest {
    @SerializedName("ok")
    private String ok;
    @SerializedName("jugador")
    private List<csJugador> data;


    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<csJugador> getData() {
        return data;
    }

    public void setData(List<csJugador> data) {
        this.data = data;
    }
}
