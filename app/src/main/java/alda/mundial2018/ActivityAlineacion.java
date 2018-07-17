package alda.mundial2018;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import alda.mundial2018.adapter.AlineacionAdapter;
import alda.mundial2018.model.csAlineacion;
import alda.mundial2018.model.csAlineacionRest;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAlineacion extends AppCompatActivity {

    RelativeLayout lyView;
    AlineacionAdapter aadapter;
    RecyclerView recyclerView,recyclerSust;
    private ProgressBar pBar;
    String idpartido, idpais, pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alineacion);

        Bundle bundle = getIntent().getExtras();
        idpartido = bundle.getString("idpartido");
        idpais = bundle.getString("idpais");
        pais = bundle.getString("pais");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            actionBar.setTitle(Html.fromHtml("<h8>" +pais + "</h8>",Html.FROM_HTML_MODE_LEGACY));
        } else {
            actionBar.setTitle(Html.fromHtml("<h8>" +pais + "</h8>"));
        }

        recyclerView = (RecyclerView) findViewById(R.id.listTitulares);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerSust = (RecyclerView) findViewById(R.id.listSustitutos);
        recyclerSust.setLayoutManager(new LinearLayoutManager(this));
        lyView = (RelativeLayout) findViewById(R.id.activity_alineacion);

        pBar = (ProgressBar)  findViewById(R.id.pbAlineacion);
        LoadAlineacionList();
    }

    private void LoadAlineacionList(){



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        pBar.setVisibility(View.VISIBLE);

        Call<csAlineacionRest> call = apiService.AlineacionList(idpartido,idpais);
        call.enqueue(new Callback<csAlineacionRest>() {
            @Override
            public void onResponse(Call<csAlineacionRest> call, Response<csAlineacionRest> response) {

                // try {
                String rs = response.body().getOk();

                // final int success = Integer.parseInt(rs);

                if (rs == "true") {




                    List<csAlineacion> rests = response.body().getData();
                    List<csAlineacion> titulares = new ArrayList<>();
                    List<csAlineacion> sustitutos = new ArrayList<>();

                    for(int i=0; i<rests.size(); i++){
                        if(rests.get(i).getEstatus().equals("TITULAR")){
                            titulares.add(rests.get(i));
                        }

                        if(rests.get(i).getEstatus().equals("SUSTITUTO")){
                            sustitutos.add(rests.get(i));
                        }
                    }



                    recyclerView.setAdapter(new AlineacionAdapter(titulares, R.layout.row_jugadores, getApplicationContext()));
                    recyclerSust.setAdapter(new AlineacionAdapter(sustitutos, R.layout.row_jugadores, getApplicationContext()));


                }else{

                    Toast.makeText(ActivityAlineacion.this,
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
            public void onFailure(Call<csAlineacionRest> call, Throwable t) {



                pBar.setVisibility(View.GONE);




                if(isOnlineNet()){
                    LoadAlineacionList();

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
