package com.example.calendarquickstart2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StorageOfVariablesLocationEct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_of_variables_location_ect);
        Intent intent = getIntent();
        Log.i("TAG", "onCreate: ");
    }
}
