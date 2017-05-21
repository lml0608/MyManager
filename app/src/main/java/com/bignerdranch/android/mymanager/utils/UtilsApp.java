package com.bignerdranch.android.mymanager.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import com.bignerdranch.android.mymanager.AppInfo;
import com.bignerdranch.android.mymanager.MLManagerApplication;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by liubin on 2017/5/21.
 */

public class UtilsApp {


    public static File getAppFolder() {

        AppPreferences appPreferences = MLManagerApplication.getAppPreferences();
        return new File(appPreferences.getCustomPath());
    }

    public static File getDefaultAppFolder() {
        return new File(Environment.getExternalStorageDirectory() + "/MLManager");
    }

    public static Boolean copyFile(AppInfo appInfo) {

        Boolean res = false;

        File initialFile = new File(appInfo.getSource());

        File finalFile = getOutputFilename(appInfo);

        try {

            FileUtils.copyFile(initialFile, finalFile);
            res = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static File getOutputFilename(AppInfo appInfo) {
        return new File(getAppFolder().getPath());
    }



    public static String getApkFilename(AppInfo appInfo) {

        AppPreferences appPreferences = MLManagerApplication.getAppPreferences();
        String res;

        switch (appPreferences.getCustomFilename()) {

            case "1":

                res = appInfo.getAPK() + "_" + appInfo.getVersion();
                break;
            case "2":

                res = appInfo.getAPK() + "_" + appInfo.getVersion();
                break;
            case "4":

                res = appInfo.getAPK();
                break;
            default:
                res = appInfo.getAPK();
                break;
        }
        return res;
    }


    public static Intent getShareIntent(File file) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        intent.setType("application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        return intent;
    }
}
