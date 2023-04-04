package eu.tutorials.investlink.HomePage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import eu.tutorials.investlink.HomePage.fragment.*
import eu.tutorials.investlink.R
//import eu.tutorials.investlink.databinding.ActivityMainBinding

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
    }
}

