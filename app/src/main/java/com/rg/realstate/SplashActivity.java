package com.rg.realstate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rg.realstate.utils.AppConstants;
import com.rg.realstate.utils.AppUtils;

/**
 * Created by kishor on 08/03/17.
 */

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        AppUtils.transparentStatusBar(getWindow());
        final String token = sharedPreferences.getString(AppConstants.TOKEN,"");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent;
                /* Create an Intent that will start the menu-Activity. */
                if(token.equalsIgnoreCase("")){
                    mainIntent = new Intent(SplashActivity.this,LoginActivity.class);

                }else {

                    mainIntent = new Intent(SplashActivity.this,MainActivity.class);

                }
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }




}
