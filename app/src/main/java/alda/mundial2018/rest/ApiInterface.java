package alda.mundial2018.rest;

import alda.mundial2018.model.csAlineacionRest;
import alda.mundial2018.model.csEstadioRest;
import alda.mundial2018.model.csEstadisticaRest;
import alda.mundial2018.model.csIncidenciaRest;
import alda.mundial2018.model.csJugadorRest;
import alda.mundial2018.model.csPartidoRest;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by aldaMac on 11/05/18.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("partido/fecha")
    Call<csPartidoRest> TodayMatchesList(@Field("fecha") String fecha);

    @FormUrlEncoded
    @POST("incidencia/partido")
    Call<csIncidenciaRest> IncidenciasList(@Field("partido") String idpartido);

    @FormUrlEncoded
    @POST("alineacion/partidopais")
    Call<csAlineacionRest> AlineacionList(@Field("idpartido") String idpartido, @Field("idpais") String idpais);

    @GET("estadistica/")
    Call<csEstadisticaRest> EstadisticaList();

    @FormUrlEncoded
    @POST("jugador/pais")
    Call<csJugadorRest> JugadoresList(@Field("idpais") String idpais);

    @GET("estadio/")
    Call<csEstadioRest> EstadiosList();
}
