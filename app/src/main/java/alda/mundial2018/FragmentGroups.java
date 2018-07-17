package alda.mundial2018;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.List;

import alda.mundial2018.adapter.EstadisticasAdapter;
import alda.mundial2018.adapter.PartidosAdapter;
import alda.mundial2018.model.csEstadistica;
import alda.mundial2018.model.csEstadisticaRest;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldaMac on 10/05/18.
 */

public class FragmentGroups extends Fragment {



    RelativeLayout mLayout;
    private FragmentGroups.OnFragmentInteractionListener mListener;

    RecyclerView recyclerViewA;
    RecyclerView recyclerViewB;
    RecyclerView recyclerViewC;
    RecyclerView recyclerViewD;
    RecyclerView recyclerViewE;
    RecyclerView recyclerViewF;
    RecyclerView recyclerViewG;
    RecyclerView recyclerViewH;
    SwipeRefreshLayout refreshLayout;
    private ProgressBar pBar;
    boolean _areLecturesLoaded = false;

    public FragmentGroups() {
        // Required empty public constructor
    }

    public static FragmentGroups newInstance(String param1) {
        FragmentGroups fragment = new FragmentGroups();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_groups, container, false);

        recyclerViewA = (RecyclerView)  mLayout.findViewById(R.id.listGrupoA);
        recyclerViewA.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewA.setAdapter(null);

        recyclerViewB = (RecyclerView)  mLayout.findViewById(R.id.listGrupoB);
        recyclerViewB.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewB.setAdapter(null);

        recyclerViewC = (RecyclerView)  mLayout.findViewById(R.id.listGrupoC);
        recyclerViewC.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewC.setAdapter(null);

        recyclerViewD = (RecyclerView)  mLayout.findViewById(R.id.listGrupoD);
        recyclerViewD.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewD.setAdapter(null);

        recyclerViewE = (RecyclerView)  mLayout.findViewById(R.id.listGrupoE);
        recyclerViewE.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewE.setAdapter(null);

        recyclerViewF = (RecyclerView)  mLayout.findViewById(R.id.listGrupoF);
        recyclerViewF.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewF.setAdapter(null);
        recyclerViewG = (RecyclerView)  mLayout.findViewById(R.id.listGrupoG);
        recyclerViewG.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewG.setAdapter(null);
        recyclerViewH = (RecyclerView)  mLayout.findViewById(R.id.listGrupoH);
        recyclerViewH.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewH.setAdapter(null);


        pBar = (ProgressBar)  mLayout.findViewById(R.id.pbGroups);



        LoadPaisesList();


        return mLayout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentGroups.OnFragmentInteractionListener) {
            mListener = (FragmentGroups.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && !_areLecturesLoaded ) {

            //LoadMainMatchesList();
            _areLecturesLoaded = true;
        }
    }



    private void LoadPaisesList(){



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        pBar.setVisibility(View.VISIBLE);

        Call<csEstadisticaRest> call = apiService.EstadisticaList();
        call.enqueue(new Callback<csEstadisticaRest>() {
            @Override
            public void onResponse(Call<csEstadisticaRest> call, Response<csEstadisticaRest> response) {

                // try {
                String rs = response.body().getOk();

                // final int success = Integer.parseInt(rs);

                if (rs == "true") {

                    Log.e("TAG", "response 33: "+new Gson().toJson(response.body()) );





                    List<csEstadistica> rests = response.body().getData();
                    List<csEstadistica> grupoA = new ArrayList<>();
                    List<csEstadistica> grupoB = new ArrayList<>();
                    List<csEstadistica> grupoC = new ArrayList<>();
                    List<csEstadistica> grupoD = new ArrayList<>();
                    List<csEstadistica> grupoE = new ArrayList<>();
                    List<csEstadistica> grupoF = new ArrayList<>();
                    List<csEstadistica> grupoG = new ArrayList<>();
                    List<csEstadistica> grupoH = new ArrayList<>();

                    for(int i=0; i<rests.size(); i++){

                        String grupo = "";
                        String cadg = rests.get(i).getGrupo().toString().replace("=",":");
                        cadg = cadg.replace("{","");
                        cadg = cadg.replace("}","");
                        String[] gValues = cadg.split(",");

                        for(int j=0; j< gValues.length; j++){
                            if(gValues[j].contains("grupo")){
                                grupo = gValues[j].substring(7);
                            }
                        }
                        if(grupo.equals("Grupo A")){
                            grupoA.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo B")){
                            grupoB.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo C")){
                            grupoC.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo D")){
                            grupoD.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo E")){
                            grupoE.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo F")){
                            grupoF.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo G")){
                            grupoG.add(rests.get(i));
                        }

                        if(grupo.equals("Grupo H")){
                            grupoH.add(rests.get(i));
                        }


                    }


                    recyclerViewA.setAdapter(new EstadisticasAdapter(grupoA, R.layout.row_groups, getContext()));
                    recyclerViewB.setAdapter(new EstadisticasAdapter(grupoB, R.layout.row_groups, getContext()));
                    recyclerViewC.setAdapter(new EstadisticasAdapter(grupoC, R.layout.row_groups, getContext()));
                    recyclerViewD.setAdapter(new EstadisticasAdapter(grupoD, R.layout.row_groups, getContext()));
                    recyclerViewE.setAdapter(new EstadisticasAdapter(grupoE, R.layout.row_groups, getContext()));
                    recyclerViewF.setAdapter(new EstadisticasAdapter(grupoF, R.layout.row_groups, getContext()));
                    recyclerViewG.setAdapter(new EstadisticasAdapter(grupoG, R.layout.row_groups, getContext()));
                    recyclerViewH.setAdapter(new EstadisticasAdapter(grupoH, R.layout.row_groups, getContext()));

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
            public void onFailure(Call<csEstadisticaRest> call, Throwable t) {



                pBar.setVisibility(View.GONE);



                if(isOnlineNet()){
                    LoadPaisesList();

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

