package com.github.axel7083.facewidget.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.LongDef;

import com.github.axel7083.facewidget.FaceWidgetRemoteViewManager;
import com.github.axel7083.facewidget.IntentAction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FaceWidgetReceiver extends BroadcastReceiver {

    private static final String TAG = "FaceWidgetReceiver";
    private static final String ACTION_REQUEST_FACEWIDGET = "com.samsung.android.intent.action.REQUEST_SERVICEBOX_REMOTEVIEWS";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        if (context != null && intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            Log.d(TAG, "action: " + action);
            if (action.equals(ACTION_REQUEST_FACEWIDGET)) {
                FaceWidgetRemoteViewManager manager = new FaceWidgetRemoteViewManager(context);
                manager.updateFaceWidget();
            }
            else if(action.equals(IntentAction.ACTION_CLICK)) {
                Log.d(TAG, "ACTION_CLICK: ");
                Toast.makeText(context, "Clicked omg", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
