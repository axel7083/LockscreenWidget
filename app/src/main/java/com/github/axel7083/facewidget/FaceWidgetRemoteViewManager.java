package com.github.axel7083.facewidget;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.RemoteViews;

public class FaceWidgetRemoteViewManager {
    private static final String TAG = "FaceWidgetRemoteViewManager";
    private static final String ACTION_RESPONSE_SERVICEBOX_REMOTEVIEWS = "com.samsung.android.intent.action.RESPONSE_SERVICEBOX_REMOTEVIEWS";
    private static final String TARGET_PACKAGE = "com.android.systemui";
    private static final String PAGE_ID = "record";

    private Context mContext;

    public FaceWidgetRemoteViewManager(Context mContext) {
        this.mContext = mContext;
    }

    public void updateFaceWidget() {
        sendFaceWidgetBroadcast(buildRemoteView());
    }

    protected RemoteViews buildRemoteView() {
        FaceWidgetRemoteViewBuilder instance = FaceWidgetRemoteViewBuilder.getInstance();
        instance.createRemoteView(this.mContext);
        instance.setButtonIntent();
        return instance.build();
    }

    private void sendFaceWidgetBroadcast(RemoteViews remoteViews) {
        Intent intent = new Intent(ACTION_RESPONSE_SERVICEBOX_REMOTEVIEWS);
        intent.setPackage(TARGET_PACKAGE);
        intent.putExtra("package", this.mContext.getPackageName());
        intent.putExtra("pageId", PAGE_ID);
        intent.putExtra("show", true);
        intent.putExtra("origin", remoteViews);
        //intent.putExtra("aod", this.mAODRemoteViews);
        //intent.putExtra("clear_cover", this.mClearViewCoverRemoteViews);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.mContext.sendBroadcast(intent);
    }
}
