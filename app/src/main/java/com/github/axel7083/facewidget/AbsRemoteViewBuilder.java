package com.github.axel7083.facewidget;

import android.content.Context;
import android.widget.RemoteViews;

public abstract class AbsRemoteViewBuilder {
    public static final int REMOTEVIEWSREQ = 117506050;
    protected Context mContext;

    public abstract RemoteViews build();

    public abstract void setRemoteView(RemoteViews remoteViews);

    public void createRemoteView(Context context) {
        this.mContext = context;
        setRemoteView(new RemoteViews(this.mContext.getPackageName(), R.layout.face_widget));
    }
}
