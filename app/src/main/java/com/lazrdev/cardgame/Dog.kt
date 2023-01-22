package com.lazrdev.cardgame

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Dog : AppCompatActivity() {
    private val player: MediaPlayer = MediaPlayer();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)
        var player: MediaPlayer? = null

        player = MediaPlayer.create(this, R.raw.dog)
        player?.isLooping = true // Set looping
        player?.setVolume(100f, 100f)

        //player.release();
        player?.start()
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            player.release();
            super.onBackPressed();

        }

    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBackPressed() {
        player.release();
        super.onBackPressed();
    }

    //nista od ovoga ne zaustavlja zvuk na sistemsko back dugme

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        return if (keyCode == KeyEvent.KEYCODE_BACK) {
//            player.release();
//            super.onBackPressed();
//            true
//        } else super.onKeyDown(keyCode, event)
//    }
//
//    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
//        if (event != null) {
//            if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking
//                && !event.isCanceled
//            ) {
//                player.release();
//                super.onBackPressed();
//                return true;
//            }
//        }
//        return super.onKeyUp(keyCode, event);
//    }

//    override fun onPause() {
//        player.release();
//        super.onPause()
//    }

//    override fun onDestroy() {
//        player.release();
//        super.onDestroy()
//    }
//
//    override fun onStop() {
//        player.release();
//        super.onStop()
//    }

}