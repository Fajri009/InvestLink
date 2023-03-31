package eu.tutorials.investlink.LoginPage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import eu.tutorials.investlink.R

class RegisterPassword : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var backPage : ImageView
    private lateinit var getPassword : TextView
    private lateinit var getConfirmPassword : TextView
    private lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerpassword)

        backPage = findViewById(R.id.backPage)
        getPassword = findViewById(R.id.password)
        getConfirmPassword = findViewById(R.id.confirmPassword)
        btnNext = findViewById(R.id.btnNext)

        buttonNext()
        backPage()
    }

    private fun backPage() {
        backPage.setOnClickListener {
            onBackPressed()
        }
    }

    private fun isPasswordValid(password : String) : Boolean {
        val condition = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*\\W)[A-Za-z\\d\\W]{8,}$")
        /*
        * '^' dan '$' tanda awal dan akhir string regex
        * '(?=.*[A-Z])' untuk memastikan bahwa password harus mengandung minimal satu huruf besar
        * '(?=.*\\d)' untuk memastikan bahwa password harus mengandung minimal 1 angka
        * '(?=.*\\W)' untuk memastikan bahwa password harus mengandung satu karakter selain huruf dan angka
        * '[A-Za-z\\d\\W]{8,}' password yang berisi kombinasi huruf besar, huruf kecil, angka, dan karakter selain huruf dan angka dengan panjang minimal 8 karakter
        * */
        return condition.matches(password)
    }

    private fun buttonNext() {
        val namaDepan = intent.getStringExtra("firstName")
        val namaBelakang = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val noTelp = intent.getStringExtra("noTelp")
        val password = getPassword.text
        val confirmPassword = getConfirmPassword.text

        btnNext.setOnClickListener{
            if(password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                val passwordStr = getPassword.text.toString()
                val confirmPasswordStr = getConfirmPassword.text.toString()

                if(passwordStr == confirmPasswordStr) {
                    if(isPasswordValid(passwordStr)) {
                        val intent = Intent(this, RegisterCode::class.java)
                        intent.putExtra("firstName", namaDepan.toString())
                        intent.putExtra("lastName", namaBelakang.toString())
                        intent.putExtra("email", email.toString())
                        intent.putExtra("noTelp", noTelp.toString())
                        intent.putExtra("password", passwordStr)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Password tidak memenuhi kriteria", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this,"Password tidak cocok", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Isi password dan konfirmasi password terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}