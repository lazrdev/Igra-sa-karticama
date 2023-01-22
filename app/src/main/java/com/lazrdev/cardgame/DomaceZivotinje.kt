package com.lazrdev.cardgame

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar

class DomaceZivotinje : AppCompatActivity() {
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
            textView?.let { LinearGradient(0f, 0f, 0f, it.textSize, Color.parseColor("#324E7E"), Color.parseColor("#9A4696"), Shader.TileMode.CLAMP) }
        if (textView != null) {
            textView.paint.shader = shader
        }
        findViewById<ShapeableImageView>(R.id.dog).setOnClickListener{
            val intent = Intent(this, Dog::class.java)
            startActivity(intent)
        }
        }


    }
