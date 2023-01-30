package com.lazrdev.cardgame

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class DomaceZivotinje : AppCompatActivity() {
    private var player: MediaPlayer? = MediaPlayer();
    private var items: MutableList<Item> = MutableList()
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domace_zivotinje)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        val gridLayoutManager =
            GridLayoutManager(applicationContext, 3, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val itemArray = obj.getJSONArray("users")
            for (i in 0 until userArray.length()) {
                val itemDetail = itemArray.getJSONObject(i)
                items.add(Item(
                    itemDetail.getString("title"),
                    itemDetail.getString("src"),
                    itemDetail.getString("category")
                ))
//                emailId.add(userDetail.getString("email"))
//                val contact = userDetail.getJSONObject("contact")
//                mobileNumbers.add(contact.getString("mobile"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val customAdapter = CustomAdapter(this@DomaceZivotinje, items)
        recyclerView.adapter = customAdapter


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
//        findViewById<ShapeableImageView>(R.id.dog).setOnClickListener {
////            val intent = Intent(this, Dog::class.java)
////            startActivity(intent)
//
//            var myDialog: AlertDialog.Builder? = null
//            myDialog = AlertDialog.Builder(
//                this)
//
//            myDialog.setTitle("Dog")
//            myDialog.setPositiveButton("Izadji") { dialog, _ ->
//                stopPlayer()
//                dialog.dismiss()
//            }
//            myDialog.setView(R.layout.dialog)
//            var slika: ImageView = findViewById(R.id.image)
//            slika.setImageResource(R.drawable.dog);
////            slika.setImageDrawable(getResources().getDrawable(R.drawable.dog, getApplicationContext().getTheme()));
//            myDialog.show()
//
//            player = MediaPlayer.create(this.applicationContext, R.raw.dog)
//            player?.isLooping = true // Set looping
//            player?.setVolume(100f, 100f)
//            //player.release();
//            player?.start()
//        }
    }
    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("items.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
    private fun stopPlayer() {

        player?.stop()
        player?.release()
        player = null
    }

    }
