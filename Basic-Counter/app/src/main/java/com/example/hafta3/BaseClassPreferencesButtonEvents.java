package com.example.hafta3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaTimestamp;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


public class BaseClassPreferencesButtonEvents extends AppCompatActivity {

    Button index, minus, plus, ayarlar;
    int counter, upLimit, downLimit;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch vibrateSwitch, soundSwitch, resetSwitch;
    int vibrate, sound, reset;
    Vibrator v;

    public void constructor() {
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        index = findViewById(R.id.index);
        ayarlar = findViewById(R.id.ayarlar);
        vibrateSwitch = findViewById(R.id.titresim);
        soundSwitch = findViewById(R.id.ses);
        resetSwitch = findViewById(R.id.reset);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void EventCreater() {
        plus.setOnClickListener(v -> {
            if (counter < upLimit) {
                index.setText(String.valueOf(++counter));
            } else {
                ringAndVibrate();
            }
        });

        minus.setOnClickListener(v -> {
            if (counter > downLimit) {
                index.setText(String.valueOf(--counter));
            } else {
                ringAndVibrate();
            }
        });

        index.setOnClickListener(v -> {
            counter = 0;
            index.setText(String.valueOf(counter));
        });

        ayarlar.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    public void ringAndVibrate() {
        if (vibrate == 1) {
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);
        }
        if (sound == 1) {
            try {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
