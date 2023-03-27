package eu.tutorials.investlink.LoginPage

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.auth.FirebaseAuth
import eu.tutorials.investlink.R

class LoginActivity : AppCompatActivity() {

    /*Inisialisasi*/
    private lateinit var getEmail: EditText
    private lateinit var getPassword: EditText
    private lateinit var daftar: TextView
    private lateinit var btnLogin: Button
    private lateinit var lupapass : TextView
    private lateinit var waiting: ProgressDialog
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser!==null){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
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
        waiting.setTitle("Logging")
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
        val email = getEmail.text.toString()
        val password = getPassword.text.toString()

        waiting.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
            .addOnFailureListener{
                error -> Toast.makeText(this,error.localizedMessage, LENGTH_SHORT).show()

            }
            .addOnCompleteListener{
                waiting.dismiss()
            }

    }

}