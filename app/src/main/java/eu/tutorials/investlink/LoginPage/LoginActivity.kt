package eu.tutorials.investlink.LoginPage

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.firestore.FirebaseFirestore
import eu.tutorials.investlink.HomePage.MainActivity
import eu.tutorials.investlink.R

class LoginActivity : AppCompatActivity() {

    /*Inisialisasi*/
    private lateinit var getEmail: EditText
    private lateinit var getPassword: EditText
    private lateinit var daftar: TextView
    private lateinit var btnLogin: Button
    private lateinit var lupapass : TextView
    private lateinit var waiting: ProgressDialog
    var firestore = FirebaseFirestore.getInstance()


    /*InCommit method, supaya tidak usah mengetik getID secara terus menerus*/
    fun inCommit(){
        getEmail = findViewById(R.id.email)
        getPassword = findViewById(R.id.pass)
        btnLogin = findViewById(R.id.loginBtn)
        daftar = findViewById(R.id.daftar)
        lupapass = findViewById(R.id.lupaSandi)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*Panggil ID*/
        inCommit()

        /*Loading*/
        waiting = ProgressDialog(this)
        waiting.setTitle("Log In")
        waiting.setMessage("Tunggu Sebentar...")

        /*Jika Button di click dan email dan password sudah terisi maka jalankan method*/
        btnLogin.setOnClickListener{
            if (getEmail.text.isNotEmpty() && getPassword.text.isNotEmpty()){
                loginAct()
            }else{
                Toast.makeText(this,"Isi email dan password dulu",LENGTH_SHORT).show()
            }
        }
        /*link ke daftar activity*/
        daftarAct()
        /*Link ke lupa sandi activity*/
        lupaSandiAct()
    }

    private fun lupaSandiAct() {
       lupapass.setOnClickListener{
           startActivity(Intent(this, LupasandiActivity::class.java))
       }
    }
    private fun daftarAct() {
        daftar.setOnClickListener {
            startActivity(Intent(this, RegisterNama::class.java))
        }
    }
    /*Login Activity*/
    private fun loginAct(){
        val email = getEmail.text.toString().trim()
        val pass = getPassword.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(pass)){
                Toast.makeText(this,"Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        FirebaseFirestore.getInstance().collection("user").document().get()
            .addOnSuccessListener{ task ->
                if (task!==null) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

}