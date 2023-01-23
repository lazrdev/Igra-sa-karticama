package com.lazrdev.cardgame

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat
import androidx.core.view.WindowCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar

class DomaceZivotinje : AppCompatActivity() {
    private var player: MediaPlayer? = MediaPlayer();
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domace_zivotinje)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            super.onBackPressed();

        }
        val textView = findViewById<TextView>(R.id.naslov)
        val shader =
            textView?.let {
                LinearGradient(
                    0f,
                    0f,
                    0f,
                    it.textSize,
                    Color.parseColor("#324E7E"),
                    Color.parseColor("#9A4696"),
                    Shader.TileMode.CLAMP
                )
            }
        if (textView != null) {
            textView.paint.shader = shader
        }
        findViewById<ShapeableImageView>(R.id.dog).setOnClickListener {
//            val intent = Intent(this, Dog::class.java)
//            startActivity(intent)
    val image : ImageView = ImageView(this);
            image.setImageResource(R.drawable.dog);

            var myDialog: AlertDialog.Builder? = null
            myDialog = AlertDialog.Builder(
                this)

            myDialog.setTitle("Dog")
            myDialog.setPositiveButton("Izadji") { dialog, _ ->
                stopPlayer()
                dialog.dismiss()
            }
            myDialog.setView(R.layout.dialog)
            var slika: ImageView = findViewById(R.id.image)
//            slika.setImageResource(R.drawable.dog);
//            slika.setImageDrawable(getResources().getDrawable(R.drawable.dog, getApplicationContext().getTheme()));
            myDialog.show()

            player = MediaPlayer.create(this.applicationContext, R.raw.dog)
            player?.isLooping = true // Set looping
            player?.setVolume(100f, 100f)
            //player.release();
            player?.start()
        }

    }
    private fun stopPlayer() {

        player?.stop()
        player?.release()
        player = null
    }

    }
