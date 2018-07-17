package alda.mundial2018;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import alda.mundial2018.adapter.PartidosAdapter;
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

public class FragmentHome extends Fragment {



    private OnFragmentInteractionListener mListener;

    RelativeLayout fLayout;
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    private ProgressBar pBar;
    boolean _areLecturesLoaded = false;
    String date = "2018-06-14";

    public FragmentHome() {
        // Required empty public constructor
    }

    public static FragmentHome newInstance(String param1) {
        FragmentHome fragment = new FragmentHome();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView)  fLayout.findViewById(R.id.listMainMatches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(null);


        pBar = (ProgressBar)  fLayout.findViewById(R.id.pbMainMatches);


        compareDates();
        LoadMainMatchesList();

        return fLayout;
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
        if (context instanceof FragmentHome.OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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



    private void LoadMainMatchesList(){



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


                    recyclerView.setAdapter(new PartidosAdapter(rests, R.layout.row_main_matches, getContext()));

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
                    LoadMainMatchesList();

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



    private void compareDates(){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
        String today = mdformat.format(calendar.getTime());
        String iniDate = "2018-06-14";
        String finDate = "2018-07-15";
        String jun29Date = "2018-06-29";
        String jul04Date = "2018-07-04";
        String jul05Date = "2018-07-05";
        String jul08Date = "2018-07-08";
        String jul09Date = "2018-07-09";
        String jul12Date = "2018-07-12";
        String jul13Date = "2018-07-13";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date strDate = sdf.parse(iniDate);
            Date toDate = sdf.parse(today);
            if (toDate.getTime() < strDate.getTime()) {
                //if (System.currentTimeMillis() < strDate.getTime()) {
                date = "2018-06-14";
            }else {
                Date str2Date = sdf.parse(finDate);
                if (toDate.getTime() > str2Date.getTime()) {
                    //if (System.currentTimeMillis() > str2Date.getTime()) {
                    date = "2018-07-15";
                }else {

                    Date str29Date = sdf.parse(jun29Date);
                    if (toDate.getTime() == str29Date.getTime()) {
                        //if (System.currentTimeMillis() > str2Date.getTime()) {
                        date = "2018-06-30";
                    }else {

                        Date str04Date = sdf.parse(jul04Date);
                        if (toDate.getTime() == str04Date.getTime()) {
                            //if (System.currentTimeMillis() > str2Date.getTime()) {
                            date = "2018-07-06";
                        }else {

                            Date str05Date = sdf.parse(jul05Date);
                            if (toDate.getTime() == str05Date.getTime()) {
                                //if (System.currentTimeMillis() > str2Date.getTime()) {
                                date = "2018-07-06";
                            }else {

                                Date str08Date = sdf.parse(jul08Date);
                                if (toDate.getTime() == str08Date.getTime()) {
                                    //if (System.currentTimeMillis() > str2Date.getTime()) {
                                    date = "2018-07-10";
                                }else {

                                    Date str09Date = sdf.parse(jul09Date);
                                    if (toDate.getTime() == str09Date.getTime()) {
                                        //if (System.currentTimeMillis() > str2Date.getTime()) {
                                        date = "2018-07-10";
                                    }else {

                                        Date str12Date = sdf.parse(jul12Date);
                                        if (toDate.getTime() == str12Date.getTime()) {
                                            //if (System.currentTimeMillis() > str2Date.getTime()) {
                                            date = "2018-07-14";
                                        }else {

                                            Date str13Date = sdf.parse(jul13Date);
                                            if (toDate.getTime() == str13Date.getTime()) {
                                                //if (System.currentTimeMillis() > str2Date.getTime()) {
                                                date = "2018-07-14";
                                            }else {

                                                getDates();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }



        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void getDates(){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = mdformat.format(calendar.getTime());
        Log.d("fecha: ", strDate);

        switch (strDate){
            case "2018-06-14":
                date = "2018-06-14";
                break;
            case "2018-06-15":
                date = "2018-06-15";
                break;
            case "2018-06-16":
                date = "2018-06-16";
                break;
            case "2018-06-17":
                date = "2018-06-17";
                break;
            case "2018-06-18":
                date = "2018-06-18";
                break;
            case "2018-06-19":
                date = "2018-06-19";
                break;
            case "2018-06-20":
                date = "2018-06-20";
                break;
            case "2018-06-21":
                date = "2018-06-21";
                break;
            case "2018-06-22":
                date = "2018-06-22";
                break;
            case "2018-06-23":
                date = "2018-06-23";
                break;
            case "2018-06-24":
                date = "2018-06-24";
                break;
            case "2018-06-25":
                date = "2018-06-25";
                break;
            case "2018-06-26":
                date = "2018-06-26";
                break;
            case "2018-06-27":
                date = "2018-06-27";
                break;
            case "2018-06-28":
                date = "2018-06-28";
                break;
            case "2018-06-30":
                date = "2018-06-30";
                break;
            case "2018-07-01":
                date = "2018-07-01";
                break;
            case "2018-07-02":
                date = "2018-07-02";
                break;
            case "2018-07-03":
                date = "2018-07-03";
                break;
            case "2018-07-06":
                date = "2018-07-06";
                break;
            case "2018-07-07":
                date = "2018-07-07";
                break;
            case "2018-07-10":
                date = "2018-07-10";
                break;
            case "2018-07-11":
                date = "2018-07-11";
                break;
            case "2018-07-14":
                date = "2018-07-14";
                break;
            default:
                date = "2018-07-15";
        }

    }

}
