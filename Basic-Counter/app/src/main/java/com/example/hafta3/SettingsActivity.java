package com.example.hafta3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends BaseClassPreferencesButtonEvents {

    EditText upValue, downValue;
    Button saveBtn, maxMinus, maxSum, minSum, minMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        createUpLimitAndDownLimit();

        AddEventListenerMaxCounterLimit();

        AddEventListenerMinCounterLimit();

        AddEventListenerSaveButton();

        AddEventListenerSoundAndVibrate();
    }

    public void AddEventListenerSaveButton() {

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upLimit = Integer.parseInt(upValue.getText().toString());
                downLimit = Integer.parseInt(downValue.getText().toString());
                SharedPreferencesManager.setInt(SettingsActivity.this, "upLimit", upLimit);
                SharedPreferencesManager.setInt(SettingsActivity.this, "downLimit", downLimit);
                finish();
            }
        });
    }

    public void createUpLimitAndDownLimit() {
        maxMinus = (Button) findViewById(R.id.maxMinus);
        maxSum = (Button) findViewById(R.id.maxSum);
        minSum = (Button) findViewById(R.id.minSum);
        minMinus = (Button) findViewById(R.id.minMinus);
        upValue = (EditText) findViewById(R.id.upperLimit);
        downValue = (EditText) findViewById(R.id.downLimit);
        saveBtn = (Button) findViewById(R.id.save);
        vibrateSwitch=findViewById(R.id.titresim);
        soundSwitch=findViewById(R.id.ses);
    }

    public void AddEventListenerSoundAndVibrate() {

        soundSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundSwitch.isChecked()) {
                    SharedPreferencesManager.setInt(SettingsActivity.this, "sound", 1);
                } else {
                    SharedPreferencesManager.setInt(SettingsActivity.this, "sound", 0);
                }
            }
        });
        vibrateSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vibrateSwitch.isChecked()) {
                    SharedPreferencesManager.setInt(SettingsActivity.this, "vibrate", 1);
                } else {
                    SharedPreferencesManager.setInt(SettingsActivity.this, "vibrate", 0);
                }
            }
        });

    }

    public void AddEventListenerMaxCounterLimit() {
        maxMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upValue.setText(String.valueOf(--upLimit));
            }
        });
        maxSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upValue.setText(String.valueOf(++upLimit));
            }
        });

        upValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                upLimit = Integer.parseInt(upValue.getText().toString());
            }
        });
    }

    public void AddEventListenerMinCounterLimit() {
        minMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downValue.setText(String.valueOf(--downLimit));
            }
        });

        minSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downValue.setText(String.valueOf(++downLimit));
            }
        });

        downValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                downLimit = Integer.parseInt(downValue.getText().toString());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferencesManager.setInt(this, "upLimit", upLimit);
        SharedPreferencesManager.setInt(this, "downLimit", downLimit);
    }

    @Override
    protected void onResume() {
        super.onResume();
        upValue.setText(String.valueOf(upLimit));
        downValue.setText(String.valueOf(downLimit));
    }
}