package com.example.playlistmaker
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.IntentCompat

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val buttonBack = findViewById<ImageView>(R.id.arrow_back_light)

        buttonBack.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }

        val shareApp = findViewById<ImageView>(R.id.shareApp)
        shareApp.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://practicum.yandex.ru/profile/android-developer")
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "Send to:"))
        }

        val writeToSupport = findViewById<ImageView>(R.id.writeToSupport)
        writeToSupport.setOnClickListener {
            val subjectText = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val text = "Спасибо разработчикам и разработчицам за крутое приложение!"
            val writeToSupportIntent = Intent(Intent.ACTION_SEND)
            writeToSupportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("kirvart@yandex.ru"))
            writeToSupportIntent.putExtra(Intent.EXTRA_SUBJECT, subjectText)
            writeToSupportIntent.putExtra(Intent.EXTRA_TEXT, text)
            writeToSupportIntent.type = "message/rfc822"
            startActivity(writeToSupportIntent)
        }
        val userAgreement = findViewById<ImageView>(R.id.userAgreement)
        userAgreement.setOnClickListener {
            val url = "https://yandex.ru/legal/practicum_offer"
            val userAgreementIntent = Intent(Intent.ACTION_VIEW)
            userAgreementIntent.data = Uri.parse(url)
            startActivity(userAgreementIntent)
        }
    }
}