package com.example.calendarquickstart2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;

public class PopUpWindow extends AppCompatActivity {



    MainActivity mainActivity;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        findViewById(R.id.StopAlarmButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v1)
            {
                mainActivity.alarmTone.stop();
                //Intent mainIntent = new Intent(PopUpWindow.this, MainActivity.class);
                //startActivity(mainIntent);
                Log.i("StopAlarmknap", "onClick: stopknap");
            }
        });

        findViewById(R.id.SnoozeButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v2)
            {
                try
                {
                    //wait kræver en try catch metode rundt om, da noget kan gå galt med waiten.
                    timer.wait(2*60*1000);
                    Log.i("Snooze", "onClick: Snooze i to min");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    Log.i("lydAlarm", "onClick: ");
                }
            }
        });


        Log.i("tag", "onCreate: POPUPWINDOW ");

        Toast toast = Toast.makeText(getApplicationContext(), "alarmen ringer",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();
    }



}
