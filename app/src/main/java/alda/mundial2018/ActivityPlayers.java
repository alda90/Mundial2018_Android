package alda.mundial2018;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import alda.mundial2018.adapter.JugadoresAdapter;
import alda.mundial2018.model.csJugador;
import alda.mundial2018.model.csJugadorRest;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPlayers extends AppCompatActivity {

    RelativeLayout lyView;
    RecyclerView recyclerView;
    private ProgressBar pBar;
    String idpais, pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        Bundle bundle = getIntent().getExtras();
        idpais = bundle.getString("idpais");
        pais = bundle.getString("pais");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            actionBar.setTitle(Html.fromHtml("<h8>" +pais + "</h8>",Html.FROM_HTML_MODE_LEGACY));
        } else {
            actionBar.setTitle(Html.fromHtml("<h8>" +pais + "</h8>"));
        }

        recyclerView = (RecyclerView) findViewById(R.id.listPlayers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lyView = (RelativeLayout) findViewById(R.id.activity_players);

        pBar = (ProgressBar)  findViewById(R.id.pbPlayers);
        LoadPlayersList();
    }

    private void LoadPlayersList(){



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        pBar.setVisibility(View.VISIBLE);

        Call<csJugadorRest> call = apiService.JugadoresList(idpais);
        call.enqueue(new Callback<csJugadorRest>() {
            @Override
            public void onResponse(Call<csJugadorRest> call, Response<csJugadorRest> response) {

                // try {
                String rs = response.body().getOk();

                // final int success = Integer.parseInt(rs);

                if (rs == "true") {

                    List<csJugador> rests = response.body().getData();


                    recyclerView.setAdapter(new JugadoresAdapter(rests, R.layout.row_jugadores, getApplicationContext()));


                }else{

                    Toast.makeText(ActivityPlayers.this,
                            "No hay datos disponibles",
                            Toast.LENGTH_SHORT).show();


                }

                //pDialog.dismiss();
                pBar.setVisibility(View.GONE);

               /* }catch (Exception e){

                    Toast.makeText(getContext(),
                            "No hay datos disponibles",
                            Toast.LENGTH_SHORT).show();


                    //pDialog.dismiss();
                    pBar.setVisibility(View.GONE);


                }*/
            }

            @Override
            public void onFailure(Call<csJugadorRest> call, Throwable t) {



                pBar.setVisibility(View.GONE);




                if(isOnlineNet()){
                    LoadPlayersList();

                }else{
                    Snackbar snackbar = Snackbar.make(lyView, "No tiene conexión a internet!", Snackbar.LENGTH_LONG);
                    // Changing action button text color
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.RED);
                    snackbar.show();
                }
            }
        });
    }

    public Boolean isOnlineNet() {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
