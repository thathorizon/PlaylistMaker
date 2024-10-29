package com.example.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSearch = findViewById<Button>(R.id.search)
        val buttonMedia = findViewById<Button>(R.id.media)
        val buttonSettings= findViewById<Button>(R.id.settings)

        val imageClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "1 кнопка активирована", Toast.LENGTH_SHORT).show()
            }
        }
        buttonSearch.setOnClickListener(imageClickListener)

        buttonMedia.setOnClickListener {
            Toast.makeText(this@MainActivity, "2 кнопка активирована", Toast.LENGTH_SHORT).show()
        }

        buttonSettings.setOnClickListener {
            Toast.makeText(this@MainActivity, "3 кнопка активирована", Toast.LENGTH_SHORT).show()
        }
    }
}