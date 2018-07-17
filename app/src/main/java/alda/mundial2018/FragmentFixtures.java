package alda.mundial2018;

/**
 * Created by aldaMac on 10/05/18.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import alda.mundial2018.adapter.PartidosAdapter;
import alda.mundial2018.adapter.PartidosGralAdapter;
import alda.mundial2018.model.csPartido;
import alda.mundial2018.model.csPartidoRest;
import alda.mundial2018.rest.ApiClient;
import alda.mundial2018.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFixtures extends Fragment {

    RelativeLayout mLayout;
    private FragmentFixtures.OnFragmentInteractionListener mListener;


    boolean _areLecturesLoaded = false;

    Adapter adapter = null;
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    private ProgressBar pBar;
    String date = "";
    int pos = 0;


    public FragmentFixtures() {
        // Required empty public constructor
    }

    // newInstance constructor for creating fragment with arguments
    public static FragmentFixtures newInstance(int page, String date) {
        FragmentFixtures fragmentFirst = new FragmentFixtures();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someDate", date);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        mLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_fixtures, container, false);

        compareDates();

        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) mLayout.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) mLayout.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


        recyclerView = (RecyclerView)  mLayout.findViewById(R.id.listPartidos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(null);


        pBar = (ProgressBar)  mLayout.findViewById(R.id.pbMatches);


        LoadMatchesList(date);






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
            mListener = (FragmentFixtures.OnFragmentInteractionListener) context;
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

            _areLecturesLoaded = true;
        }
    }

    // Add Fragments to Tabs
    private void setupViewPager(final ViewPager viewPager) {

        //adapterViewPager = new MyPagerAdapter(getFragmentManager());
        //viewPager.setAdapter(adapterViewPager);

        Log.d("tagFix","b");
        adapter = new Adapter(getFragmentManager());
        Bundle bdata14 = new Bundle();
        Bundle bdata15 = new Bundle();
        Bundle bdata16 = new Bundle();
        Bundle bdata17 = new Bundle();
        Bundle bdata18 = new Bundle();
        Bundle bdata19 = new Bundle();
        Bundle bdata20 = new Bundle();
        Bundle bdata21 = new Bundle();
        Bundle bdata22 = new Bundle();
        Bundle bdata23 = new Bundle();
        Bundle bdata24 = new Bundle();
        Bundle bdata25 = new Bundle();
        Bundle bdata26 = new Bundle();
        Bundle bdata27 = new Bundle();
        Bundle bdata28 = new Bundle();
        Bundle bdata30 = new Bundle();
        Bundle bdata01 = new Bundle();
        Bundle bdata02 = new Bundle();
        Bundle bdata03 = new Bundle();
        Bundle bdata06 = new Bundle();
        Bundle bdata07 = new Bundle();
        Bundle bdata10 = new Bundle();
        Bundle bdata11 = new Bundle();
        Bundle bdata147 = new Bundle();
        Bundle bdata157= new Bundle();



        ChildFragmentMatches frag14 = new ChildFragmentMatches();
        ChildFragmentMatches frag15 = new ChildFragmentMatches();
        ChildFragmentMatches frag16 = new ChildFragmentMatches();
        ChildFragmentMatches frag17 = new ChildFragmentMatches();
        ChildFragmentMatches frag18 = new ChildFragmentMatches();
        ChildFragmentMatches frag19 = new ChildFragmentMatches();
        ChildFragmentMatches frag20 = new ChildFragmentMatches();
        ChildFragmentMatches frag21 = new ChildFragmentMatches();
        ChildFragmentMatches frag22 = new ChildFragmentMatches();
        ChildFragmentMatches frag23 = new ChildFragmentMatches();
        ChildFragmentMatches frag24 = new ChildFragmentMatches();
        ChildFragmentMatches frag25 = new ChildFragmentMatches();
        ChildFragmentMatches frag26 = new ChildFragmentMatches();
        ChildFragmentMatches frag27 = new ChildFragmentMatches();
        ChildFragmentMatches frag28 = new ChildFragmentMatches();
        ChildFragmentMatches frag30 = new ChildFragmentMatches();
        ChildFragmentMatches frag01 = new ChildFragmentMatches();
        ChildFragmentMatches frag02 = new ChildFragmentMatches();
        ChildFragmentMatches frag03 = new ChildFragmentMatches();
        ChildFragmentMatches frag06 = new ChildFragmentMatches();
        ChildFragmentMatches frag07 = new ChildFragmentMatches();
        ChildFragmentMatches frag10 = new ChildFragmentMatches();
        ChildFragmentMatches frag11 = new ChildFragmentMatches();
        ChildFragmentMatches frag147 = new ChildFragmentMatches();
        ChildFragmentMatches frag157 = new ChildFragmentMatches();

        bdata14.putString("date", "2018-06-14" );
        frag14.setArguments(bdata14);
        adapter.addFragment(frag14, "14 Jun");


        bdata15.putString("date", "2018-06-15" );
        frag15.setArguments(bdata15);
        adapter.addFragment(frag15, "15 Jun");

        bdata16.putString("date", "2018-06-16");
        frag16.setArguments(bdata16);
        adapter.addFragment(frag16, "16 Jun");

        bdata17.putString("date", "2018-06-17");
        frag17.setArguments(bdata17);
        adapter.addFragment(frag17, "17 Jun");

        bdata18.putString("date", "2018-06-18");
        frag18.setArguments(bdata18);
        adapter.addFragment(frag18, "18 Jun");

        bdata19.putString("date", "2018-06-19");
        frag19.setArguments(bdata19);
        adapter.addFragment(frag19, "19 Jun");

        bdata20.putString("date", "2018-06-20");
        frag20.setArguments(bdata20);
        adapter.addFragment(frag20, "20 Jun");

        bdata21.putString("date", "2018-06-21");
        frag21.setArguments(bdata21);
        adapter.addFragment(frag21, "21 Jun");

        bdata22.putString("date", "2018-06-22");
        frag22.setArguments(bdata22);
        adapter.addFragment(frag22, "22 Jun");

        bdata23.putString("date", "2018-06-23");
        frag23.setArguments(bdata23);
        adapter.addFragment(frag23, "23 Jun");

        bdata24.putString("date", "2018-06-24");
        frag24.setArguments(bdata24);
        adapter.addFragment(frag24, "24 Jun");

        bdata25.putString("date", "2018-06-25");
        frag25.setArguments(bdata25);
        adapter.addFragment(frag25, "25 Jun");

        bdata26.putString("date", "2018-06-26");
        frag26.setArguments(bdata26);
        adapter.addFragment(frag26, "26 Jun");

        bdata27.putString("date", "2018-06-27");
        frag27.setArguments(bdata27);
        adapter.addFragment(frag27, "27 Jun");

        bdata28.putString("date", "2018-06-28");
        frag28.setArguments(bdata28);
        adapter.addFragment(frag28, "28 Jun");

        bdata30.putString("date", "2018-06-30");
        frag30.setArguments(bdata30);
        adapter.addFragment(frag30, "30 Jun");

        bdata01.putString("date", "2018-07-01");
        frag01.setArguments(bdata01);
        adapter.addFragment(frag01, "01 Jul");

        bdata02.putString("date", "2018-07-02");
        frag02.setArguments(bdata02);
        adapter.addFragment(frag02, "02 Jul");

        bdata03.putString("date", "2018-07-03");
        frag03.setArguments(bdata03);
        adapter.addFragment(frag03, "03 Jul");

        bdata06.putString("date", "2018-07-06");
        frag06.setArguments(bdata06);
        adapter.addFragment(frag06, "06 Jul");

        bdata07.putString("date", "2018-07-07");
        frag07.setArguments(bdata07);
        adapter.addFragment(frag07, "07 Jul");

        bdata10.putString("date", "2018-07-10" );
        frag10.setArguments(bdata10);
        adapter.addFragment(frag10, "10 Jul");



        bdata11.putString("date", "2018-07-11" );
        frag11.setArguments(bdata11);
        adapter.addFragment(frag11, "11 Jul");


        bdata147.putString("date", "2018-07-14" );
        frag147.setArguments(bdata147);
        adapter.addFragment(frag147, "14 Jul");



        bdata157.putString("date", "2018-07-15" );
        frag157.setArguments(bdata157);

        adapter.addFragment(frag157, "15 Jul");

        viewPager.setOffscreenPageLimit(25);


        viewPager.setAdapter(adapter);

        viewPager.post(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(pos,true);
            }
        });



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
               String date = ((ChildFragmentMatches)adapter.getItem(position)).getArguments().getString("date");
               LoadMatchesList(date);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }



    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        private Context context;

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
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
                pos = 0;
            }else {
                Date str2Date = sdf.parse(finDate);
                if (toDate.getTime() > str2Date.getTime()) {
                //if (System.currentTimeMillis() > str2Date.getTime()) {
                    date = "2018-07-15";
                    pos = 25;
                }else {

                    Date str29Date = sdf.parse(jun29Date);
                    if (toDate.getTime() == str29Date.getTime()) {
                        //if (System.currentTimeMillis() > str2Date.getTime()) {
                        date = "2018-06-30";
                        pos = 15;
                    }else {

                        Date str04Date = sdf.parse(jul04Date);
                        if (toDate.getTime() == str04Date.getTime()) {
                            //if (System.currentTimeMillis() > str2Date.getTime()) {
                            date = "2018-07-06";
                            pos = 19;
                        }else {

                            Date str05Date = sdf.parse(jul05Date);
                            if (toDate.getTime() == str05Date.getTime()) {
                                //if (System.currentTimeMillis() > str2Date.getTime()) {
                                date = "2018-07-06";
                                pos = 19;
                            }else {

                                Date str08Date = sdf.parse(jul08Date);
                                if (toDate.getTime() == str08Date.getTime()) {
                                    //if (System.currentTimeMillis() > str2Date.getTime()) {
                                    date = "2018-07-10";
                                    pos = 21;
                                }else {

                                    Date str09Date = sdf.parse(jul09Date);
                                    if (toDate.getTime() == str09Date.getTime()) {
                                        //if (System.currentTimeMillis() > str2Date.getTime()) {
                                        date = "2018-07-10";
                                        pos = 21;
                                    }else {

                                        Date str12Date = sdf.parse(jul12Date);
                                        if (toDate.getTime() == str12Date.getTime()) {
                                            //if (System.currentTimeMillis() > str2Date.getTime()) {
                                            date = "2018-07-14";
                                            pos = 23;
                                        }else {

                                            Date str13Date = sdf.parse(jul13Date);
                                            if (toDate.getTime() == str13Date.getTime()) {
                                                //if (System.currentTimeMillis() > str2Date.getTime()) {
                                                date = "2018-07-14";
                                                pos = 23;
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
                pos = 0;
                break;
            case "2018-06-15":
                date = "2018-06-15";
                pos = 1;
                break;
            case "2018-06-16":
                date = "2018-06-16";
                pos = 2;
                break;
            case "2018-06-17":
                date = "2018-06-17";
                pos = 3;
                break;
            case "2018-06-18":
                date = "2018-06-18";
                pos = 4;
                break;
            case "2018-06-19":
                date = "2018-06-19";
                pos = 5;
                break;
            case "2018-06-20":
                date = "2018-06-20";
                pos = 6;
                break;
            case "2018-06-21":
                date = "2018-06-21";
                pos = 7;
                break;
            case "2018-06-22":
                date = "2018-06-22";
                pos = 8;
                break;
            case "2018-06-23":
                date = "2018-06-23";
                pos = 9;
                break;
            case "2018-06-24":
                date = "2018-06-24";
                pos = 10;
                break;
            case "2018-06-25":
                date = "2018-06-25";
                pos = 11;
                break;
            case "2018-06-26":
                date = "2018-06-26";
                pos = 12;
                break;
            case "2018-06-27":
                date = "2018-06-27";
                pos = 13;
                break;
            case "2018-06-28":
                date = "2018-06-28";
                pos = 14;
                break;
            case "2018-06-30":
                date = "2018-06-30";
                pos = 15;
                break;
            case "2018-07-01":
                date = "2018-07-01";
                pos = 16;
                break;
            case "2018-07-02":
                date = "2018-07-02";
                pos = 17;
                break;
            case "2018-07-03":
                date = "2018-07-03";
                pos = 18;
                break;
            case "2018-07-06":
                date = "2018-07-06";
                pos = 19;
                break;
            case "2018-07-07":
                date = "2018-07-07";
                pos = 20;
                break;
            case "2018-07-10":
                date = "2018-07-10";
                pos = 21;
                break;
            case "2018-07-11":
                date = "2018-07-11";
                pos = 22;
                break;
            case "2018-07-14":
                date = "2018-07-14";
                pos = 23;
                break;
            default:
                date = "2018-07-15";
                pos = 24;
        }

    }



}
