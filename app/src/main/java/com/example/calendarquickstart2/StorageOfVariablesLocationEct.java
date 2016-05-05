package com.example.calendarquickstart2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class StorageOfVariablesLocationEct extends AppCompatActivity {
    String location;
    String arrivalTime;
    /*
    private final String travelLocation;
    private final String arrivalTime;

    public StorageOfVariablesLocationEct(String travelLocation, String arrivalTime) {
        this.travelLocation = travelLocation;
        this.arrivalTime = arrivalTime;

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_of_variables_location_ect);

        Intent intent = getIntent();
        Log.i("TAG", "onCreate: ");



        // get the data:
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            location = extras.getString("Location String");
            Log.i("location",location);
            arrivalTime = extras.getString("Time String");
            //Log.i("arrivalTime",arrivalTime);


            TextView view = (TextView) findViewById(R.id.storage);
            view.setText(location);

            TextView view1 = (TextView) findViewById(R.id.time);
            view1.setText(arrivalTime);
        }
        /*TextView storageView = (TextView) findViewById(R.id.storage);
        storageView.setText(travelLocation);
           */
    }
}
