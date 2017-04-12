package com.rg.realstate;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.rg.realstate.MainActivity.hasPermissions;

/**
 * Created by utsavstha on 3/8/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences sharedPreferences;

    protected Toolbar toolbar;
    protected DrawerLayout drawer = null;
    protected ActionBarDrawerToggle toggle;
    protected NavigationView navigationView;
    private float lastTranslate = 0.0f;
    CircleImageView circleImageView;
    int PERMISSION_ALL = 1;

    private  CoordinatorLayout sliderContent = null;
    TextView tv_first_lastname_nav;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        initToolbar(getToolbar());

        String[] PERMISSIONS = {Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_SMS, Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO};

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }

        // transparentStatusBar();,



    }

    /*protected void initNavigationDrawer() {

        if(getNavbarResourceID() != 0){
            sliderContent = (CoordinatorLayout) findViewById(getNavbarResourceID());
        }

        if(getDrawerLayout() != 0){
            drawer = (DrawerLayout) findViewById(getDrawerLayout());

            //drawer.setDrawerShadow(R.drawable.navbar_shadow, Gravity.RIGHT);

            toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close){
                @Override
                public void onDrawerSlide(View drawerView, float slideOffset) {
                    float moveFactor = (navigationView.getWidth() * slideOffset);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && sliderContent != null) {
                        sliderContent.setTranslationX(moveFactor);
                    } else {
                        TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                        anim.setDuration(1);
                        anim.setFillAfter(true);
                        sliderContent.startAnimation(anim);

                        lastTranslate = moveFactor;
                    }
                    super.onDrawerSlide(drawerView, slideOffset);
                    *//*super.onDrawerSlide(drawerView, slideOffset);
                    mainView.setTranslationX(slideOffset * drawerView.getWidth());
                    mDrawerLayout.bringChildToFront(drawerView);
                    mDrawerLayout.requestLayout();*//*
                }

            };
            toggle.setDrawerIndicatorEnabled(true);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            AppUtils.transparentStatusBar(getWindow());
            //proceed.setTypeface(AppUtils.getFontProximaNova(getApplicationContext()));

            toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
            navigationView = (NavigationView) findViewById(getNavigationView());
            View headerview = navigationView.getHeaderView(0);

            tv_first_lastname_nav = (TextView)headerview.findViewById(R.id.tv_first_lastname_nav);
            UpdateUserProfile();

            circleImageView = (CircleImageView) headerview.findViewById(R.id.iv_profile_image);
            navigationView.setNavigationItemSelectedListener(this);

            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BaseActivity.this, MainActivity.class));

                }
            });
        }




    }*/

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void initToolbar(int toolBarID) {
        toolbar = (Toolbar) findViewById(toolBarID);
        toolbar.setTitle(getToolbarTitle());
        setSupportActionBar(toolbar);
        if(getActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        return true;
    }

    /**
     *
     * @return Instance of toolbar created in child classes
     */
    protected abstract int getToolbar();


    /**
     *
     * @return title of toolbar to be displayed
     */
    protected abstract String getToolbarTitle();

    /**
     * Each activity must have a unique ID saved in cache,
     * this ID can be used by base activity to differentiate between
     * child activity
     * @return
     */
    protected abstract int getActivityID();


    /**
     *
     * @return Layout file resource ID for child activities
     */
    protected abstract int getResourceLayout();

    /**
     *
     * @return DrawerLayout ID for navigation drawer
     */
    protected abstract int getDrawerLayout();

    /**
     *
     * @return Navigationview ID for navigation drawer
     */
    protected abstract int getNavigationView();

    /**
     *
     * @return Instance of activity
     */
    protected abstract Activity getInstance();

    /**
     * Makes the status bar transparent by making the activity
     * full screen
     */
    protected void transparentStatusBar(){
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    protected abstract int getNavbarResourceID();

}
