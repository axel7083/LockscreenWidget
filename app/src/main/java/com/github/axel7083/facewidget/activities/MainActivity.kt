package com.github.axel7083.facewidget.activities

import android.content.Context
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.axel7083.facewidget.FaceWidgetRemoteViewManager
import com.github.axel7083.facewidget.LockUtils
import com.github.axel7083.facewidget.R


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // During first launch setup the RemoteView
        val manager = FaceWidgetRemoteViewManager(this)
        manager.updateFaceWidget()

        Log.d(TAG, "==========================")
        LockUtils.isWidgetChecked(this)
    }




}