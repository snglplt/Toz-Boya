package com.songul.tozboya.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.songul.tozboya.R

class SplashVideoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_video)
        val videoView: VideoView = findViewById(R.id.videoView)
        val videoPath = "android.resource://${packageName}/${R.raw.splash_video}"

        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)

        videoView.setOnCompletionListener {
            startActivity(Intent(this, SingInActivity::class.java))
            finish()
        }

        videoView.start()
    }
}