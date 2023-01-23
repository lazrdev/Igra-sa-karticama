package com.lazrdev.cardgame

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Dog : AppCompatActivity() {
    private var player: MediaPlayer? = MediaPlayer();

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
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
//            player.stop()
//            player.release()
//            this.onBackPressed()
            this.stopPlayer()
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBackPressed() {
//        player.pause()
//        player.stop();
//        player!!.release();
//        super.onBackPressed();
        super.onBackPressed()

        this.stopPlayer()
    }

    override fun onStop() {
        super.onStop()

        this.stopPlayer();
    }
    private fun stopPlayer() {
        if (player != null) {
            player!!.release()
            player = null
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show()
        }
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
//       player.stop()
//        player.release();
//        super.onPause()
//    }

//    override fun onDestroy() {
//        player.stop()
//        player.release();
//        super.onDestroy()
//    }
//
//    override fun onStop() {
//        player.release();
//        super.onStop()
//    }

}