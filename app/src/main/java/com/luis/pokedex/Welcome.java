package com.luis.pokedex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.gcm.*;
import com.microsoft.windowsazure.messaging.*;
import com.microsoft.windowsazure.notifications.NotificationsManager;

/**
 *
 * Describes the Welcome screen
 */
public class Welcome extends AppCompatActivity {

    public static final String SENDER_ID = "509385777116"; //this is the number of the project in Google Cloud Platform
    private GoogleCloudMessaging gcm;
    private NotificationHub hub;
    private String HubName = "pokemon-pokedex"; //name of the Notification hub in Microsoft Azure
    // the Connection String of the Notification Hub in Microsoft Azure
    private String HubListenConnectionString = "Endpoint=sb://pokemon-pokedex.servicebus.windows.net/;SharedAccessKeyName=DefaultFullSharedAccessSignature;SharedAccessKey=FvmRiKTBdWlf1O1SSm9bO/ckob9iODAbvEGjLt+s+v4=";
    private static Boolean isVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pokedex"); //creation of a toolbar

        //try to do a connection with the server to show notifications, using Google Cloud Platform and Microsoft Azure
        // when the app runs, it is created a register in the notification hub in Microsoft Azure
        try {
            MyHandler.mainActivity = this;
            NotificationsManager.handleNotifications(this, SENDER_ID, MyHandler.class);
            gcm = GoogleCloudMessaging.getInstance(this);
            hub = new NotificationHub(HubName, HubListenConnectionString, this);
            registerWithNotificationHubs();
        }catch (Exception e){}


        //When each button is clicked, each activity  is showed
        Button enter = (Button) findViewById(R.id.button);
        enter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Welcome.this, MainActivity.class);
                        startActivity(it);
                    }
                }
        );
        Button info = (Button) findViewById(R.id.info);
        info.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(Welcome.this, Info.class);
                        startActivity(it);
                    }
                }
        );
    }

    //this method shows if the connection with Google Cloud Messaging and Notification Hub succeeds
    @SuppressWarnings("deprecation") //avoid to show notification messages
    private void registerWithNotificationHubs() {
        new AsyncTask() { //AsyncTask to connect to the Notification Hub with a background thread
            @Override
            protected Object doInBackground(Object... params) {
                try {
                    String regid = gcm.register(SENDER_ID);
                    ToastNotify("Registered Successfully - RegId : " +
                            hub.register(regid).getRegistrationId());
                } catch (Exception e) {
                    ToastNotify("Registration Exception Message - " + e.getMessage());
                    return e;
                }
                return null;
            }
        }.execute(null, null, null);
    }

    //methods to display the system notification if the activity is visible or not
    @Override
    protected void onStart() {
        super.onStart();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isVisible = false;
    }

    //this method shows a toast when occurs the connection with the Microsoft Azure
    public void ToastNotify(final String notificationMessage)
    {
        if (isVisible == true)
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Welcome.this, notificationMessage, Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {

            exit();
        }

        if (id == R.id.about) {
            about();
        }

        return super.onOptionsItemSelected(item);
    }

    //AlertDialog to show About window
    public void about(){
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.icon128);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Welcome.this).setTitle("About Pokedex")
        .setMessage("Version 1.0\nDeveloped by Luis Barbosa\n\n").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setView(image);
        alertDialog.create().show();
    }

    //Exits the system
    public void exit(){
        System.exit(0);
    }


}
