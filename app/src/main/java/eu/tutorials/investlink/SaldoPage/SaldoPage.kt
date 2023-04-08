package eu.tutorials.investlink.SaldoPage

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import eu.tutorials.investlink.R

class SaldoPage : AppCompatActivity() {
    private lateinit var backPage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saldopage)

        backPage = findViewById(R.id.backPage)

        backPage()
    }

    private fun backPage() {
        backPage.setOnClickListener {
            onBackPressed()
        }
    }
}