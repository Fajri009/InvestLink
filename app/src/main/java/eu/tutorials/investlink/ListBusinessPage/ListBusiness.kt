package eu.tutorials.investlink.ListBusinessPage

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import eu.tutorials.investlink.HomePage.Adapter.GuideAdapter
import eu.tutorials.investlink.HomePage.Model.GuideView
import eu.tutorials.investlink.R

class ListBusiness : AppCompatActivity() {
    private lateinit var businessList : RecyclerView
    private lateinit var backPage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listbusiness)

        backPage = findViewById(R.id.backPage)
        businessList = findViewById(R.id.businessList)

        backPage()
        businessList()
    }

    fun backPage() {
        backPage.setOnClickListener {
            onBackPressed()
        }
    }

    fun businessList() {
        businessList.setHasFixedSize(true)
        businessList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val businessArray = mutableListOf<BusinessView>()

        businessArray.add(BusinessView(R.drawable.business_1, "2 more days", "Alfamidi Panyileukan Bandung"))
        businessArray.add(BusinessView(R.drawable.business_2, "Last Day", "Kebuli Abuya 10 Cabang Jabodetabek"))
        businessArray.add(BusinessView(R.drawable.business_1, "2 more days", "Alfamidi Panyileukan Bandung"))
        businessArray.add(BusinessView(R.drawable.business_2, "Last Day", "Kebuli Abuya 10 Cabang Jabodetabek"))

        val businessAdapter = BusinessAdapter(businessArray)
        businessList.adapter = businessAdapter
    }
}