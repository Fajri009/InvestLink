package eu.tutorials.investlink.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import eu.tutorials.investlink.R

class MainActivity : AppCompatActivity() {

    private lateinit var logoutButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logoutButton = findViewById(R.id.signOut)

        logoutButton.setOnClickListener() {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}