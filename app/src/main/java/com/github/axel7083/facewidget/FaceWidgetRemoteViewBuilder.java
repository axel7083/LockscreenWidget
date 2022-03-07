package com.github.axel7083.facewidget;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class FaceWidgetRemoteViewBuilder extends AbsRemoteViewBuilder {
    private static final String TAG = "FaceWidgetRemoteViewBuilder";
    private static FaceWidgetRemoteViewBuilder mInstance;
    private RemoteViews mRemoteViews;

    private FaceWidgetRemoteViewBuilder() {
        Log.d(TAG, "FaceWidgetRemoteViewBuilder constructor.");
    }

    public static FaceWidgetRemoteViewBuilder getInstance() {
        if (mInstance == null) {
            mInstance = new FaceWidgetRemoteViewBuilder();
        }
        return mInstance;
    }

    @Override
    public RemoteViews build() {
        return this.mRemoteViews;
    }

    public void release() {
        this.mContext = null;
    }

    public void setButtonIntent() {
        Intent intent = new Intent(IntentAction.ACTION_CLICK);
        intent.setPackage(mContext.getPackageName());
        mRemoteViews.setOnClickPendingIntent(
                R.id.face_widget_button,
                PendingIntent.getBroadcast(this.mContext, AbsRemoteViewBuilder.REMOTEVIEWSREQ, intent, Intent.FLAG_ACTIVITY_CLEAR_TOP)
        );
    }

    @Override
    public void setRemoteView(RemoteViews remoteViews) {
        this.mRemoteViews = remoteViews;
    }
}
