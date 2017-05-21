package com.bignerdranch.android.mymanager.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by liubin on 2017/5/21.
 */

public class AppPreferences {


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private Context mContext;


    public static final String KeyCustomFilename = "prefCustomFilename";
    public static final String KeyCustomPath = "prefCustomPath";

    public AppPreferences(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mEditor = mSharedPreferences.edit();
        mContext = context;
    }


    public String getCustomPath() {
        return mSharedPreferences.getString(KeyCustomPath, UtilsApp.getDefaultAppFolder().getPath());
    }

    public void setCustomPath(String path) {
        mEditor.putString(KeyCustomPath, path);
        mEditor.commit();
    }

    public String getCustomFilename() {

        return mSharedPreferences.getString(KeyCustomFilename, "1");
    }

    public void setCustomFilename(String res) {

        mEditor.putString(KeyCustomFilename, res);
        mEditor.commit();
    }
}
