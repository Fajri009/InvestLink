package eu.tutorials.investlink.LoginPage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import eu.tutorials.investlink.R

class RegisterEmail : AppCompatActivity()  {
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var backPage : ImageView
    private lateinit var getEmail : TextView
    private lateinit var getNoTelp : TextView
    private lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeremail)

        firebaseAuth = FirebaseAuth.getInstance()

        backPage = findViewById(R.id.backPage)
        getEmail = findViewById(R.id.email)
        getNoTelp = findViewById(R.id.noTelp)
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
            if(getEmail.text.isNotEmpty() && getNoTelp.text.isNotEmpty()) {
                if(!getEmail.text.endsWith("@gmail.com") || !getNoTelp.text.startsWith("8")) {
                    Toast.makeText(this,"Email atau nomor telepon tidak valid", Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this, RegisterPassword::class.java))
                }
            } else{
                Toast.makeText(this,"Isi email dan nomor telepon terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}