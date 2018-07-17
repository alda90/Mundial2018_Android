package alda.mundial2018;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import alda.mundial2018.adapter.PartidosGralAdapter;
import alda.mundial2018.model.csPartido;
import alda.mundial2018.model.csPartidoRest;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by aldaMac on 10/05/18.
 */

public class ChildFragmentMatches extends Fragment {

    RelativeLayout mLayout;
    boolean _areLecturesLoaded = false;
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    private ProgressBar pBar;

    public String date;

    public ChildFragmentMatches() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mLayout = (RelativeLayout) inflater.inflate(R.layout.child_fragment_matches, container, false);

        date = getArguments().getString("date");
         /*recyclerView = (RecyclerView)  mLayout.findViewById(R.id.listPartidos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(null);


        pBar = (ProgressBar)  mLayout.findViewById(R.id.pbMatches);



        LoadMatchesList(date);*/

        Log.d("tagFix","c");



        return mLayout;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !_areLecturesLoaded ) {
            _areLecturesLoaded = true;
        }
    }

    public void LoadMatchesList(final String date){



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        pBar.setVisibility(View.VISIBLE);

        Call<csPartidoRest> call = apiService.TodayMatchesList(date);
        call.enqueue(new Callback<csPartidoRest>() {
            @Override
            public void onResponse(Call<csPartidoRest> call, Response<csPartidoRest> response) {

                // try {
                String rs = response.body().getOk();

                // final int success = Integer.parseInt(rs);

                if (rs == "true") {

                    Log.e("TAG", "response 33: "+new Gson().toJson(response.body()) );





                    List<csPartido> rests = response.body().getData();


                    recyclerView.setAdapter(new PartidosGralAdapter(rests, R.layout.row_matches, getContext()));

                }else{

                    Toast.makeText(getContext(),
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
            public void onFailure(Call<csPartidoRest> call, Throwable t) {



                pBar.setVisibility(View.GONE);



                if(isOnlineNet()){
                    LoadMatchesList(date);

                }else{
                    Snackbar snackbar = Snackbar.make(getView(), "No tiene conexión a internet!", Snackbar.LENGTH_LONG);
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
