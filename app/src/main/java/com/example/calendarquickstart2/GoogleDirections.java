package com.example.calendarquickstart2;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by v on 5/11/16.
 */
public class GoogleDirections extends AppCompatActivity {

    ListView listView;
    Response responseObj;

    String OriginInputByUser= "valby st";
    String destination;//= "Dyssegård st";

    String mode="transit";

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
    private String departureNew;


    public GoogleDirections(String destination, long eventTimeMillis, String eventName) {
        Log.i("test", "GoogleDirections: ");

        enventTimeinSec = String.valueOf(eventTimeMillis/1000);

    // call api.

        Log.i("destination test", "onCreate: destination test"+destination);
        //String urltest2 = "https://maps.googleapis.com/maps/api/directions/json?origin=enghave%20station&destination=emdrup&mode=transit&arrival_time="+eventTimeMillisAsString +"&key=AIzaSyAdsyGsiSh_nIIVuC7LAe27eE6r2mMBuK4";
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=valby st&destination="+destination+"&arrival_time="+enventTimeinSec+"&mode=transit&key=AIzaSyDPx6zlmEEAbqUdX8Gr7tlxNips9Ld5cI4";
        Log.i("URL test", "onCreate: " + url);

        // MAKE API CALLS
        client = new AsyncHttpClient();
        client.get(GoogleDirections.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String responestr = new String(responseBody);

                // instatiate gson object.
                gson = new com.google.gson.Gson();
                responseObj = gson.fromJson(responestr,Response.class);

                startAdress =responseObj.getRoutes().get(0).getLegs().get(0).getStart_address();

                // return this the departre tme to the alarm clock.
                String departure_time = responseObj.getRoutes().get(0).getLegs().get(0).getDeparture_time().getText();
                Log.i("departure_time", "Gson onSuccess: departure_time "+ departure_time);

                departureNew=departure_time;
                // check if its the right end adress.
                String destinationOutPutCheck =responseObj.getRoutes().get(0).getLegs().get(0).getEnd_address();
                Log.i("destinationOutPutCheck", "Gson : destinationOutPutCheck "+ destinationOutPutCheck);



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

        Log.i("tag", "GoogleDirections: departure_time test " + departureNew);


    }


    public String getDepartureTime() {
        Log.i("departure_time", "getDepartureTime: "+departureNew);
        String departureTime=departureNew;
        return departureTime;
    }
}
