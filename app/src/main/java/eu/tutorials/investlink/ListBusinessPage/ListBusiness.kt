package eu.tutorials.investlink.ListBusinessPage

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import eu.tutorials.investlink.R

class ListBusiness : AppCompatActivity() {
    private lateinit var backPage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listbusiness)

    }
}