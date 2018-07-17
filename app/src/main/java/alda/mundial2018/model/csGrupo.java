package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csGrupo {
    @SerializedName("_id")
    private String idgrupo;
    @SerializedName("grupo")
    private String grupo;

    public csGrupo(String idgrupo, String grupo) {

        this.idgrupo = idgrupo;
        this.grupo = grupo;
    }

    public String getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(String idgrupo ) {
        this.idgrupo = idgrupo ;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo ) {
        this.grupo = grupo ;
    }
}
