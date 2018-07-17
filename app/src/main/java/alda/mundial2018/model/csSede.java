package alda.mundial2018.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldaMac on 11/05/18.
 */

public class csSede {
    @SerializedName("_id")
    private String idsede;
    @SerializedName("sede")
    private String sede;
    @SerializedName("sedeingles")
    private String sedeingles;
    @SerializedName("sedelocal")
    private String sedelocal;

    public csSede(String idsede, String sede, String sedeingles,
                     String sedelocal) {

        this.idsede = idsede;
        this.sede = sede;
        this.sedeingles = sedeingles;
        this.sedelocal = sedelocal;
    }

    public String getIdsede() {
        return idsede;
    }

    public void setIdsede(String idsede ) {
        this.idsede = idsede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede ) {
        this.sede = sede;
    }

    public String getSedeingles() {
        return sedeingles;
    }

    public void setSedeingles(String sedeingles ) {
        this.sedeingles= sedeingles ;
    }

    public String getSedelocal() {
        return sedelocal;
    }

    public void setSedelocal(String sedelocal ) {
        this.sedelocal = sedelocal ;
    }




}
