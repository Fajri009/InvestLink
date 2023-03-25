package eu.tutorials.investlink.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import eu.tutorials.investlink.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var backPage : ImageView
    private lateinit var getNamaDepan : TextView
    private lateinit var btnNext : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        backPage = findViewById(R.id.backPage)
        getNamaDepan = findViewById(R.id.namaDepan)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener{
            if(getNamaDepan.text.isNotEmpty()) {

            } else{
                Toast.makeText(this,"Isi nama depan terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        backPage()
    }

    private fun backPage() {
        backPage.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}