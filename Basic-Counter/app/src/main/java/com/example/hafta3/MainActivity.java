package com.example.hafta3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends BaseClassPreferencesButtonEvents {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constructor();

        EventCreater();

    }

    @Override
    protected void onResume() {
        super.onResume();
        upLimit = SharedPreferencesManager.getInt(this, "upLimit");
        downLimit = SharedPreferencesManager.getInt(this, "downLimit");
        index.setText(String.valueOf(downLimit));
        vibrate = SharedPreferencesManager.getInt(this, "vibrate");
        sound = SharedPreferencesManager.getInt(this, "sound");
        reset = SharedPreferencesManager.getInt(this, "reset");
    }
}