package com.luis.pokedex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 *
 * Describes the Splash screen
 */

//Activity Class manages the user interface, requests and other processes
public class Splash extends Activity {
    // splash screen timer
    private static int SPLASH_TIME_OUT = 6000; //time by miliseconds = 3 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //Animation Abstract Class applied in a view to rotate the pokeball icon, with the rotate_animation xml file
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
        ImageView imgLogo = (ImageView) findViewById(R.id.imgLogo);
        imgLogo.startAnimation(rotate);

        //Handler creates the delay to show the splash layout
        new Handler().postDelayed(new Runnable() {
            /*
             * Displays the splash with a timer
             */
            @Override
            public void run() {
                // When the timer ends, this method starts
                // ...with the WelcomeActivity
                Intent i = new Intent(Splash.this, Welcome.class);
                startActivity(i);

                // terminates this window
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

