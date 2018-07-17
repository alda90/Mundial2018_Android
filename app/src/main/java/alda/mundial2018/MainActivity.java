package alda.mundial2018;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  FragmentHome.OnFragmentInteractionListener,
 FragmentGroups.OnFragmentInteractionListener, FragmentFixtures.OnFragmentInteractionListener,
        FragmentCities.OnFragmentInteractionListener{

    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    private CollapsingToolbarLayout collapsingToolbarLayout = null;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    fragment = new FragmentHome();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_fixtures:


                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = FragmentFixtures.newInstance(1,"2018-06-14");
                    transaction.replace(R.id.contents, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_groups:
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = FragmentGroups.newInstance("");
                    transaction2.replace(R.id.contents, selectedFragment);
                    transaction2.commit();
                    return true;
                case R.id.navigation_cities:
                    /*FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = FragmentCities.newInstance("");
                    transaction3.replace(R.id.contents, selectedFragment);
                    transaction3.commit();*/
                    fragment = new FragmentCities();
                    switchFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));

        dynamicToolbarColor();
        toolbarTextAppernce();

        //fragment = new FragmentHome();

        //switchFragment(fragment);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contents, FragmentHome.newInstance("as"));
        transaction.commit();



        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.home);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark));
            }
        });
    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    private void switchFragment(Fragment fragment) {
        fragment.setUserVisibleHint(true);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contents, fragment);
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }

}
