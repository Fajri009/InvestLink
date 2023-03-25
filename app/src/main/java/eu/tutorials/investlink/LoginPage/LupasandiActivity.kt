package eu.tutorials.investlink.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import eu.tutorials.investlink.R

class LupasandiActivity : AppCompatActivity() {
    private lateinit var getEmail: EditText
    private lateinit var getPhoneNumber: EditText
    private lateinit var backPage: ImageView
    private lateinit var verifBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupasandi)

        getEmail = findViewById(R.id.email_verif)
        getPhoneNumber = findViewById(R.id.phone_verif)
        backPage = findViewById(R.id.backPage)
        verifBtn = findViewById(R.id.btnVerif)

        verifBtn.setOnClickListener {
            if (getEmail.text.isNotEmpty() && getPhoneNumber.text.isNotEmpty()){

            }else{
                Toast.makeText(this,"Masukkan Email dan Nomer Telepon dulu",LENGTH_SHORT).show()
            }
        }
        goBack()

    }

    private fun goBack() {
        backPage.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}