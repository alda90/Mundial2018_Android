package alda.mundial2018;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.adapter.IncidenciasAdapter;
import alda.mundial2018.adapter.PartidosAdapter;
import alda.mundial2018.model.csIncidencia;
import alda.mundial2018.model.csIncidenciaRest;
import alda.mundial2018.model.csPartido;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityMatch extends AppCompatActivity {

    ImageView imgLocal, imgVisitante;
    TextView tvLocal, tvVisitante, tvGlocal, tvGvisitante, tvInfo,tvLocalp, tvVisitantep;
    String idpartido, idlocal, idvisitante, banderal, banderav, local, visitante, glocal, gvisitante, glocalp, gvisitantep, estatus;
    String conclusion, fecha, hora, partido, fase;
    RelativeLayout lyView;

    IncidenciasAdapter iadapter;

    RecyclerView recyclerView;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        recyclerView = (RecyclerView) findViewById(R.id.listIncidencias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lyView = (RelativeLayout) findViewById(R.id.activity_match);

        Bundle bundle = getIntent().getExtras();
        idpartido = bundle.getString("idpartido");
        banderal = bundle.getString("banderal");
        banderav = bundle.getString("banderav");
        idlocal = bundle.getString("idlocal");
        idvisitante = bundle.getString("idvisitante");
        local = bundle.getString("local");
        visitante = bundle.getString("visitante");
        glocal = bundle.getString("glocal");
        gvisitante = bundle.getString("gvisitante");
        glocalp = bundle.getString("glocalp");
        gvisitantep = bundle.getString("gvisitantep");
        estatus = bundle.getString("estatus");
        conclusion = bundle.getString("conclusion");
        fase = bundle.getString("fase");
        fecha = bundle.getString("fecha");
        hora = bundle.getString("hora");
        partido = bundle.getString("partido");



        imgLocal = (ImageView)findViewById(R.id.img_Local);
        imgVisitante = (ImageView)findViewById(R.id.img_Visitante);
        tvLocal = (TextView) findViewById(R.id.tvLocal);
        tvVisitante = (TextView) findViewById(R.id.tvVisitante);
        tvGlocal = (TextView) findViewById(R.id.glocal);
        tvGvisitante = (TextView) findViewById(R.id.gvisitante);
        tvLocalp = (TextView) findViewById(R.id.tvLocalp);
        tvVisitantep= (TextView) findViewById(R.id.tvVisitantep);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            actionBar.setTitle(Html.fromHtml("<h8>" +partido + "</h8>",Html.FROM_HTML_MODE_LEGACY));
        } else {
            actionBar.setTitle(Html.fromHtml("<h8>" +partido + "</h8>"));
        }

        tvLocal.setText(local);
        tvVisitante.setText(visitante);
        tvGlocal.setText(glocal);
        tvGvisitante.setText(gvisitante);
        tvLocalp.setText(glocalp);
        tvVisitantep.setText(gvisitantep);

        if(estatus.equals("PROGRAMADO")){
            tvInfo.setText(fecha + " - " + hora);
        }else {
            tvInfo.setText(estatus);
        }

        if(!conclusion.equals("PENALES")){
            tvLocalp.setVisibility(View.GONE);
            tvVisitantep.setVisibility(View.GONE);
        }

        Picasso.with(getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/banderas/"+banderal).into(imgLocal);
        Picasso.with(getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/banderas/"+banderav).into(imgVisitante);


        pBar = (ProgressBar)  findViewById(R.id.pbMatche);
        LoadIncidenciasList();

        imgLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityMatch.this, ActivityAlineacion.class);
                i.putExtra("idpartido",idpartido);
                i.putExtra("idpais", idlocal);
                i.putExtra("pais", local);
                startActivity(i);
            }
        });

        imgVisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityMatch.this, ActivityAlineacion.class);
                i.putExtra("idpartido",idpartido);
                i.putExtra("idpais", idvisitante);
                i.putExtra("pais", visitante);
                startActivity(i);
            }
        });
    }

    private void LoadIncidenciasList(){



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        pBar.setVisibility(View.VISIBLE);

        Call<csIncidenciaRest> call = apiService.IncidenciasList(idpartido);
        call.enqueue(new Callback<csIncidenciaRest>() {
            @Override
            public void onResponse(Call<csIncidenciaRest> call, Response<csIncidenciaRest> response) {

                // try {
                String rs = response.body().getOk();

                // final int success = Integer.parseInt(rs);

                if (rs == "true") {




                    List<csIncidencia> rests = response.body().getData();


                    recyclerView.setAdapter(new IncidenciasAdapter(rests, R.layout.row_incidencia, getApplicationContext()));


                }else{

                    Toast.makeText(ActivityMatch.this,
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
            public void onFailure(Call<csIncidenciaRest> call, Throwable t) {



                pBar.setVisibility(View.GONE);

                Toast.makeText(ActivityMatch.this,
                        t.toString(),
                        Toast.LENGTH_SHORT).show();



                if(isOnlineNet()){
                    LoadIncidenciasList();

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
