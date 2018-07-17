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

import java.util.List;

import alda.mundial2018.adapter.EstadioAdapter;
import alda.mundial2018.model.csEstadio;
import alda.mundial2018.model.csEstadioRest;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldaMac on 10/05/18.
 */

public class FragmentCities extends Fragment {



    RelativeLayout mLayout;
    private FragmentCities.OnFragmentInteractionListener mListener;

    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    private ProgressBar pBar;
    boolean _areLecturesLoaded = false;

    public FragmentCities() {
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

        mLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_cities, container, false);

        recyclerView = (RecyclerView)  mLayout.findViewById(R.id.listEstadios);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(null);


        pBar = (ProgressBar)  mLayout.findViewById(R.id.pbEstadios);



        LoadEstadiosList();

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
            mListener = (FragmentCities.OnFragmentInteractionListener) context;
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



    private void LoadEstadiosList(){



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        pBar.setVisibility(View.VISIBLE);

        Call<csEstadioRest> call = apiService.EstadiosList();
        call.enqueue(new Callback<csEstadioRest>() {
            @Override
            public void onResponse(Call<csEstadioRest> call, Response<csEstadioRest> response) {

                // try {
                String rs = response.body().getOk();

                // final int success = Integer.parseInt(rs);

                if (rs == "true") {

                    Log.e("TAG", "response 33: "+new Gson().toJson(response.body()) );





                    List<csEstadio> rests = response.body().getData();

                    recyclerView.setAdapter(new EstadioAdapter(rests, R.layout.row_estadios, getContext()));

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
            public void onFailure(Call<csEstadioRest> call, Throwable t) {



                pBar.setVisibility(View.GONE);



                if(isOnlineNet()){
                    LoadEstadiosList();

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