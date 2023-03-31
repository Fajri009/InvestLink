package eu.tutorials.investlink.LoginPage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import eu.tutorials.investlink.R

class RegisterEmail : AppCompatActivity()  {
    private lateinit var backPage : ImageView
    private lateinit var getEmail : TextView
    private lateinit var getNoTelp : TextView
    private lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeremail)

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
        btnNext.setOnClickListener {
            val namaDepan = intent.getStringExtra("firstName")
            val namaBelakang = intent.getStringExtra("lastName")
            val email = getEmail.text
            val noTelp = getNoTelp.text

            if(email.isNotEmpty() && noTelp.isNotEmpty()) {
                if(!email.endsWith("@gmail.com") || !noTelp.startsWith("08")) {
                    Toast.makeText(this, "Email atau nomor telepon tidak valid", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, RegisterPassword::class.java)
                    intent.putExtra("firstName", namaDepan.toString())
                    intent.putExtra("lastName", namaBelakang.toString())
                    intent.putExtra("email", email.toString())
                    intent.putExtra("noTelp", noTelp.toString())
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Isi email dan nomor telepon terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

}