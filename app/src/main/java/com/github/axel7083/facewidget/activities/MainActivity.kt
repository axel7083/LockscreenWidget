package com.github.axel7083.facewidget.activities

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.github.axel7083.facewidget.IntentAction.SETTINGS_FACE_WIDGET
import com.github.axel7083.facewidget.LockUtils
import com.github.axel7083.facewidget.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateInfo()

        // Open the Samsung Settings to the FaceWidget page
        binding.openSettings.setOnClickListener {
            val intent = Intent(Settings.ACTION_SETTINGS)
            intent.action = SETTINGS_FACE_WIDGET
            startActivity(intent)
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        updateInfo()
    }

    // Show if the widget is checked or not.
    private fun updateInfo() {
        val r: Boolean = LockUtils.isWidgetChecked(this)
        binding.info.text = if(r) "The widget is activated" else "The widget is not activated"
    }
}