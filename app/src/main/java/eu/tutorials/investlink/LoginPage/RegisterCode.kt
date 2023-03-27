package eu.tutorials.investlink.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import eu.tutorials.investlink.R

class RegisterCode : AppCompatActivity() {
    private lateinit var backPage : ImageView
    private lateinit var getCode : TextView
    private lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerrefferalcode)

        backPage = findViewById(R.id.backPage)
        getCode = findViewById(R.id.code)
        btnNext = findViewById(R.id.btnNext)

        buttonNext()
        backPage()
    }

    private fun backPage() {
        backPage.setOnClickListener {
            onBackPressed()
        }
    }

    private fun buttonNext() {
        btnNext.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}