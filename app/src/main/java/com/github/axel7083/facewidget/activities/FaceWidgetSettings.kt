package com.github.axel7083.facewidget.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.axel7083.facewidget.IntentAction
import com.github.axel7083.facewidget.R
import com.github.axel7083.facewidget.databinding.ActivityFaceWidgetSettingsBinding
import com.github.axel7083.facewidget.databinding.ActivityMainBinding

class FaceWidgetSettings : AppCompatActivity() {

    lateinit var binding : ActivityFaceWidgetSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaceWidgetSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.action.equals(IntentAction.CONFIG_FACE_WIDGET)) {
            binding.info.text = "This page has been open from the Samsung Settings."
        }
    }
}