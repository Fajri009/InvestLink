package eu.tutorials.investlink.LoginPage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import eu.tutorials.investlink.LoginPage.fragment.*
import eu.tutorials.investlink.R
import eu.tutorials.investlink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val fragmentHome: Fragment =  home_fragment()
    val fragmentPortofolio: Fragment = portofolio_fragment()
    val fragmentSosial: Fragment = sosial_fragment()
    val fragmentTransaksi: Fragment = transaksi_fragment()
    val fragmentProfile: Fragment = profile_fragment()
    val fragmentManager =  supportFragmentManager

    var active :Fragment = fragmentHome

    lateinit var binding: ActivityMainBinding
    private lateinit var buttonNavView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
//    private lateinit var logoutButton:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        logoutButton = findViewById(R.id.signOut)
//
//        logoutButton.setOnClickListener() {
//            FirebaseAuth.getInstance().signOut()
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
        btnNavigation()
    }

    private fun btnNavigation() {
        fragmentManager.beginTransaction().add(R.id.container,fragmentHome).show(fragmentHome).commit()
        fragmentManager.beginTransaction().add(R.id.container,fragmentPortofolio).hide(fragmentPortofolio).commit()
        fragmentManager.beginTransaction().add(R.id.container,fragmentSosial).hide(fragmentSosial).commit()
        fragmentManager.beginTransaction().add(R.id.container,fragmentTransaksi).hide(fragmentTransaksi).commit()
        fragmentManager.beginTransaction().add(R.id.container,fragmentProfile).hide(fragmentProfile).commit()

        buttonNavView = binding.navbar
        menu = buttonNavView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        buttonNavView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> {
                    callFrag(0,fragmentHome)
                }
                R.id.nav_portofolio -> {
                    callFrag(1,fragmentPortofolio)
                }
                R.id.nav_sosial -> {
                    callFrag(2,fragmentSosial)
                }
                R.id.nav_trasaksi -> {
                    callFrag(3,fragmentTransaksi)
                }
                R.id.nav_profil -> {
                    callFrag(4,fragmentProfile)
                }
            }
            false
        }

    }

    private fun callFrag(index: Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fragmentManager.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}

