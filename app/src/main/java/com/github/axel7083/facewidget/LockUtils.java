package com.github.axel7083.facewidget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

public class LockUtils {
    private static final String SETTINGS_LOCKSCREEN_FACE_ORDER = "face_widget_order";

    public static boolean isWidgetChecked(Context context) {
        String[] fallFacesWidgetInfo = getAllFaceWidgetInfo(context);
        if(fallFacesWidgetInfo == null)
            return false;
        boolean r = false;
        for(String widget : fallFacesWidgetInfo) {
            if(widget.startsWith(context.getPackageName())) {
                r = Settings.System.getInt(context.getContentResolver(), createFaceWidgetDbKey(widget), 0) == 1;
            }
        }
        return r;
    }

    private static String[] getAllFaceWidgetInfo(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), SETTINGS_LOCKSCREEN_FACE_ORDER);
        return (string == null || "".equals(string))?null:string.split(";");
    }

    private static String createFaceWidgetDbKey(String str) {
        return "add_info_" + str.replace(".", "_");
    }
}
