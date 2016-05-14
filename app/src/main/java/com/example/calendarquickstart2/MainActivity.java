package com.example.calendarquickstart2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    AlarmManager alarm_manager;
    boolean morningCalendar = false;
    //er lavet så vi kan bruge martins long af tiden i UNIX, som så skal bruges til at sætte tiden for popup'en.
    //****int morningHour = (int) Notification_reciever.wakeUpMorningHour;
    //****int morningMinute = (int) Notification_reciever.wakeUpMorningMinute;
    Intent PopUpIntent;
    Intent intentSettings;
    java.util.Calendar calNow = java.util.Calendar.getInstance();
    public Uri notification;
    public Ringtone alarmTone;
    java.util.Calendar calendarMorning = java.util.Calendar.getInstance();

    EditText origin;
    Intent intent;

    // we are getting the desired arival time in (type)DateTime and the destinationfrom the calendar api.
    // convert time to unix time
    //
    // send the 3 inputs to the Gson class, togther with the point of origin, that we get from the user.
    // to to return the departure.
    // We send the departure time to the alarm clock, that sets the time some time erlier than the departure,
    // default 60 minnuttes.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent= new Intent(getApplicationContext(),Calendar.class);

                startActivity(intent);
            }
        });

        origin = (EditText) findViewById(R.id.writeOrigin); // Jeg har tilføjet denne linje


        recieveDatafromDirecetionsApi();

        //overrider default title på toolbar
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        // initialize our alarm manager

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //calendarMorning.set(Calendar.HOUR_OF_DAY, morningHour);
        //calendarMorning.add(java.util.Calendar.MINUTE, 1);
        calendarMorning.add(java.util.Calendar.SECOND, 10);



        //METODER
        //metode der sætter tidspunktet for popup-vinduet

        //Start lyd på alarmen når tiden er gået imellem nu og det satte tidspunkt, denne starter morgen popup-activiteten
        alarmAudio();
        //metode der laver kl.22-notifikationen
        eveningStart();

        //GÅ til settings-activiteten når intentSettings bliver initialiseret
        // create new intent, inisiate new class.
        //****intentSettings = new Intent(this, MySettings.class);
    }
    //LYD PÅ ALARMEN
    public void alarmAudio()
    {
        Timer timer = new Timer();
        //lav en timertask, som kører noget bestemt efter X antal millisekunder.
        timer.schedule(new TimerTask()
        {
            public void run()
            {
                Log.i("I Audio run-metode", "run: I audioen");
                //sæt lyd på fra din notificationsmanager.
                notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                alarmTone = RingtoneManager.getRingtone(getApplicationContext(), notification);
                alarmTone.play();



                //morningStart();
            }
        }, calendarMorning.getTimeInMillis()-calNow.getTimeInMillis());
    }
    //MORGENALARMPOPUP
    public void morningStart()
    {
        Log.i("TAG", "morningStart: nu skal den poppe up så man kan slukke den");

        Log.i("calNowMilli", "morningStart: " + calNow.getTimeInMillis());
        Log.i("calendarmorningMilli", "morningStart: " + calendarMorning.getTimeInMillis());

        Intent PopUpIntent = new Intent(this, PopUp.class);
        PendingIntent PopUpPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, PopUpIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // calendarMorning er det tidspunkt vor den skal starte pending intent
        Log.i("tag", "morningStart: calendarMorning.getTime"+calendarMorning.getTime());
        Log.i("tag", "morningStart: calNow.getTime()"+calNow.getTime());

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendarMorning.getTimeInMillis(), PopUpPendingIntent);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
  //      getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }

    //AFTENNOTIFIKATION
    public void eveningStart()
    {
        java.util.Calendar calendarEvening = java.util.Calendar.getInstance();
        //vælg tidspunktet
        //calendarEvening.set(Calendar.HOUR_OF_DAY, 22);
        calendarEvening.add(java.util.Calendar.MINUTE, 2);
        //for at have en gentagende funktion, skal den trickes af en broadcastReciever, som vi laver i Notification_recieverclassen
        Intent intent = new Intent(getApplicationContext(), Notification_reciever.class);
        //Alarmservicen har en pendingIntent som parameter og vi laver derfor sådan en
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //Lav en instans af Alarmmanageren
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //RTC_Wakeup, betyder at den skal vække telefonen, hvis den er i dvale.. den henter tiden ind fra calendaren, interval er hver dag skal den gentages.
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendarEvening.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
    //starter intentSettings samt sætter morningCalendar til sand
    public void setTime(View view)
    {
        //
        //test
        PopUpIntent = new Intent(getApplicationContext(), PopUpWindow.class);
        startActivity(PopUpIntent);
        ///***********startActivity(intentSettings);
        //morningCalendar = true;
    }
    public void stopAlarm(View view)
    {
        //
        alarmTone.stop();
        Toast toast = Toast.makeText(getApplicationContext(), "alarm stops",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();

    }

   /* public  void goToPreTravelSetting()
    {
        Intent preTravel = new Intent(this, PreTravelSettings.class);
        startActivity(preTravel);
    }
    public void goToSettings()
    {
        Intent settings = new Intent(this, ActivityForSettings.class);
        startActivity(settings);
    }*/







    // deafault.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings)
        {
            goToSettings();
            return true;
        }
        if (id == R.id.preTavelSettings)
        {
            goToPreTravelSetting();
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }



    private void recieveDatafromDirecetionsApi() {
        // get Strings from the Drirections API, (Gson.class)
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String value = extras.getString("Extra String");
            Log.i("TAG",value);
            String value2 = extras.getString("Extra String2");
            Log.i("TAG",value);
            String value3 = extras.getString("Extra String3");
            Log.i("TAG",value3);
            String value4 = extras.getString("Extra String4");
            Log.i("TAG",value4);
            String value5 = extras.getString("Extra String5");
            Log.i("TAG",value5);

            TextView view = (TextView) findViewById(R.id.departure_time);
            view.setText(value);

            TextView view2 = (TextView) findViewById(R.id.edit_message2);
            view2.setText(value2);

            TextView view3 = (TextView) findViewById(R.id.edit_message3);
            view3.setText(value3);
            TextView view4 = (TextView) findViewById(R.id.edit_message4);
            view4.setText(value4);
            TextView view5 = (TextView) findViewById(R.id.edit_message5);
            view5.setText(value5);

        }

    }

    public void  saveHomeLocationToString(View view)
    {
        // get user input.
        String startlocation = String.valueOf(origin.getText());
        Log.i("startlocation", "onCreate:startlocation "+startlocation);

        //String valueName= "Hi there";

        //  intent.putExtra("Extra String",valueName);

    }



}
