package com.example.calendarquickstart2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class Gson extends AppCompatActivity {

    ListView listView;
    Response responseObj;

    String OriginInputByUser= "valby st";
    String destination= "Dyssegård st";

    String mode="transit";
    String departure_time;//= String.valueOf(System.currentTimeMillis()+1000000);
    //Test
    // &arrival_time=1462479888
    String test= "https://maps.googleapis.com/maps/api/directions/json?origin1=valby&destination=dysseg%C3%A5rd&arrival_time=1462479888&mode=transit&key=AIzaSyDPx6zlmEEAbqUdX8Gr7tlxNips9Ld5cI4";
    String url = "https://maps.googleapis.com/maps/api/directions/json?origin=valby%20station&destination=n%C3%B8rrebro%20st&mode=transit&key=AIzaSyAdsyGsiSh_nIIVuC7LAe27eE6r2mMBuK4";
    com.google.gson.Gson gson;
    AsyncHttpClient client;
    private GoogleApiClient client2;
    String startAdress;
    long eventTimeMillis;
    String eventName;
    String eventTimeMillisAsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        client = new AsyncHttpClient();

        client.get(Gson.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String responestr = new String(responseBody);

                // instatiate gson object.
                gson = new com.google.gson.Gson();
                responseObj = gson.fromJson(responestr,Response.class);

                startAdress =responseObj.getRoutes().get(0).getLegs().get(0).getStart_address();

                // return this the departre tme to the alarm clock.
                departure_time =responseObj.getRoutes().get(0).getLegs().get(0).getDeparture_time().getText();
                Log.i("departure_time", "Gson onSuccess: departure_time "+ departure_time);
                //endDestination =responseObj.getRoutes().get(0).getLegs().get(0).getEnd_address();

                //departure_time =responseObj.getRoutes().get(0).getLegs().get(0).getEnd_address();
                // husk man kan få arrival time i unix eller i am/pm
                //arrival_time = String.valueOf(responseObj.getRoutes().get(0).getLegs().get(0).getArrival_time().getValue());

                Log.i("Gson startAdress", startAdress);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.i("gsonFaliure", "onFailure: ");
            }
        });

        // recive data:

            // destination
            // eventTimeMillis
            // User gives us eventTimeMillis

        // return departure time to the alarmclock.


        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            eventName = extras.getString("eventName");
            Log.i("TAG", eventName);
            eventTimeMillis = extras.getLong("eventTimeMillis");
            // convert long to string:
            eventTimeMillisAsString = String.valueOf(eventTimeMillis);

            Log.i("TAG", String.valueOf(eventTimeMillis));
            destination = extras.getString("destination");
            Log.i("TAG",destination);

            Log.i("tag", "Gson onCreate: eventTimeMillis:"+ eventTimeMillis);
            //check and compare http://www.epochconverter.com/

            Log.i("tag", "Gson onCreate: destination:"+destination);
            Log.i("tag", "Gson onCreate: eventName:"+eventName);

            // extract the time from the eventTimeMillis (ex. eventTimeMillis:2016-05-09T07:00:00.000+02:00 - to 07:00


            /*
            TextView view = (TextView) findViewById(R.id.edit_message);
            view.setText(value);

            TextView view2 = (TextView) findViewById(R.id.edit_message2);
            view2.setText(value2);
            */

        }






    }

}