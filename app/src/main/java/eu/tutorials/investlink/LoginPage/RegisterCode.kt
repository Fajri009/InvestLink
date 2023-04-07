package eu.tutorials.investlink.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eu.tutorials.investlink.R

class RegisterCode : AppCompatActivity() {
    var firestore = FirebaseFirestore.getInstance()
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
        val namaDepan = intent.getStringExtra("firstName")
        val namaBelakang = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val noTelp = intent.getStringExtra("noTelp")
        val password = intent.getStringExtra("password")
        val code = getCode.text
        val intent = Intent(this, LoginActivity::class.java)

        btnNext.setOnClickListener{
            val user = hashMapOf(
                "firstName" to namaDepan.toString(),
                "lastName" to namaBelakang.toString(),
                "email" to email.toString(),
                "noTelp" to noTelp.toString(),
                "password" to password.toString(),
                "code" to code.toString()
            )

            firestore.collection("user")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data berhasil disimpan ke database", Toast.LENGTH_SHORT).show()
                    intent.putExtra("code", code.toString())
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Data gagal disimpan ke database", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}