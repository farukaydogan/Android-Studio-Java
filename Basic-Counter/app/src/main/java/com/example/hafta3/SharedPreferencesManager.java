package com.example.hafta3;

import android.content.Context;
import android.content.SharedPreferences;




public class SharedPreferencesManager {

    SharedPreferencesManager() {}

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static void setInt(Context context,String Name, Integer newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(Name, newValue);
        editor.commit();
    }

    public static int getInt(Context context, String Name) {
        return getSharedPreferences(context).getInt(Name, 0);
    }

    // other getters/setters
}