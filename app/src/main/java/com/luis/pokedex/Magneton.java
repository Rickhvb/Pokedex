package com.luis.pokedex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

/**
 *
 * Describes a Pokémon
 */
public class Magneton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magneton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Magneton #082");

        // Text in a scroll page
        TextView textview= (TextView) findViewById(R.id.infoMagneton);
        textview.setMovementMethod(new ScrollingMovementMethod());
    }

}
