package com.example.calendarquickstart2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class Directions extends AppCompatActivity {

    ListView listView;
    Response responseObj;

    String OriginInputByUser= "valby st";
    String destination;//= "Dyssegård st";

    String mode="transit";
    String departure_time;//= String.valueOf(System.currentTimeMillis()+1000000);
    //Test
    // &arrival_time=1462479888
    com.google.gson.Gson gson;
    AsyncHttpClient client;
    private GoogleApiClient client2;
    String startAdress;
    long eventTimeMillis;
    String enventTimeinSec;
    String eventName;
    String eventTimeMillisAsString;
    private String finalDetination;
    String origin;
    private int departure_time_Unixsec;
    private String arrival_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





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
            finalDetination=splitdestinationString(destination);
            Log.i("tag", "Directions onCreate: finalDetination :"+ finalDetination);
            Log.i("tag", "Directions onCreate: eventTimeMillis from calendar API:"+ eventTimeMillis);

            // convert the type long to string so it can be used in the URL, and devide by 1000, because
            // it needs seconds not milliSec.
            enventTimeinSec = String.valueOf(eventTimeMillis/1000);
            Log.i("tag", "Directions onCreate: enventTimeinSec from calendar API:"+ enventTimeinSec);

            //check and compare http://www.epochconverter.com/

            Log.i("tag", "Directions onCreate: destination from calendar API test1:"+destination);
            Log.i("tag", "Directions onCreate: eventName:"+eventName);

            origin = extras.getString("origin");
            Log.i("TAG", "Directions origin"+origin);

            // extract the time from the eventTimeMillis (ex. eventTimeMillis:2016-05-09T07:00:00.000+02:00 - to 07:00


            /*
            TextView view = (TextView) findViewById(R.id.edit_message);
            view.setText(value);

            TextView view2 = (TextView) findViewById(R.id.edit_message2);
            view2.setText(value2);
            */

        }
        Log.i("TAG", "onCreate: origin test2 "+origin);
        //"+finalDetination+"
        Log.i("destination test", "onCreate: destination test"+destination);
        //String urltest2 = "https://maps.googleapis.com/maps/api/directions/json?origin=enghave%20station&destination=emdrup&mode=transit&arrival_time="+eventTimeMillisAsString +"&key=AIzaSyAdsyGsiSh_nIIVuC7LAe27eE6r2mMBuK4";
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+destination+"&arrival_time="+enventTimeinSec+"&mode=transit&key=AIzaSyDPx6zlmEEAbqUdX8Gr7tlxNips9Ld5cI4";
        Log.i("URL test", "onCreate: " + url);

        // MAKE API CALLS to Directions
        client = new AsyncHttpClient();
        client.get(Directions.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.i("gson", "gson onSuccess: " +origin);
                String responestr = new String(responseBody);

                // instatiate gson object.
                gson = new com.google.gson.Gson();
                responseObj = gson.fromJson(responestr,Response.class);

                startAdress =responseObj.getRoutes().get(0).getLegs().get(0).getStart_address();



                // return this the departre tme to the alarm clock.
                departure_time =responseObj.getRoutes().get(0).getLegs().get(0).getDeparture_time().getText();
                Log.i("departure_time", "Directions onSuccess: departure_time "+ departure_time);
                departure_time_Unixsec =responseObj.getRoutes().get(0).getLegs().get(0).getDeparture_time().getValue();

                Log.i("TAG", "onSuccess: ny departure_time_Unixsec"+ departure_time_Unixsec);


                // check if its the right end adress.
                String destinationOutPutCheck =responseObj.getRoutes().get(0).getLegs().get(0).getEnd_address();
                Log.i("destinationOutPutCheck", "Directions : destinationOutPutCheck "+ destinationOutPutCheck);



                //departure_time =responseObj.getRoutes().get(0).getLegs().get(0).getEnd_address();
                // husk man kan få arrival time i unix eller i am/pm
                arrival_time = String.valueOf(responseObj.getRoutes().get(0).getLegs().get(0).getArrival_time().getValue());

                Log.i("Directions startAdress", startAdress);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("departureTime",departure_time);
                intent.putExtra("Extra String2",startAdress);
                intent.putExtra("Extra String3",destination);
                intent.putExtra("Extra String4",eventName);
                intent.putExtra("Extra String5",arrival_time);
                intent.putExtra("Extra String6", departure_time_Unixsec);


                // shtart the new activity
                startActivity(intent);



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.i("gsonFaliure", "onFailure: ");

            }
        });






    }

    private String splitdestinationString(String destination) {


        String[] destinationParts = destination.split(".,");
        String part_1 = destinationParts[0];
        String part_2 = destinationParts[1];
        // 034556
        //String part4 = parts[3]; // 034556
        System.out.println("destinationParts1  "+part_1);
        System.out.println("destinationParts2  "+ part_2);


        return part_1;
    }

}