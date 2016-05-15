package com.example.calendarquickstart2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by v on 5/14/16.
 */
public class RingtonePlayingService extends Service {

    

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
