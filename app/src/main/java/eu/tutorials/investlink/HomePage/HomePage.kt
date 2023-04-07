package eu.tutorials.investlink.HomePage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.HomePage.Adapter.BusinessAdapter
import eu.tutorials.investlink.HomePage.Adapter.GuideAdapter
import eu.tutorials.investlink.HomePage.Model.BusinessView
import eu.tutorials.investlink.HomePage.Model.GuideView
import eu.tutorials.investlink.R

class HomePage : AppCompatActivity() {
    private lateinit var guideView: RecyclerView
    private lateinit var businessView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home_fragment)

        guideList()
        businessList()
    }

    fun guideList() {
        guideView = findViewById(R.id.guideView)
        guideView.setHasFixedSize(true)
        guideView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val guideList = mutableListOf<GuideView>()

        guideList.add(GuideView(R.drawable.guide_1, "Cara Kerja Invest Link"))
        guideList.add(GuideView(R.drawable.guide_1, "Dividend distribution"))
        guideList.add(GuideView(R.drawable.guide_1, "Cara Kerja Invest Link"))
        guideList.add(GuideView(R.drawable.guide_1, "Dividend distribution"))

        val guideAdapter = GuideAdapter(guideList)
        guideView.adapter = guideAdapter
    }

    fun businessList() {
        businessView = findViewById(R.id.businessView)
        businessView.setHasFixedSize(true)
        businessView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val businessList = mutableListOf<BusinessView>()

        businessList.add(BusinessView(R.drawable.business_1, "2 more days", "Alfamidi Panyileukan Bandung", "32%", "Rp 5.171.000.000"))
        businessList.add(BusinessView(R.drawable.business_2, "Last day","Kebuli Abuya 10 Cabang Jabo...", "70%", "Rp 1.947.500.000"))
        businessList.add(BusinessView(R.drawable.business_1, "2 more days","Alfamidi Panyileukan Bandung", "32%", "Rp 5.171.000.000"))
        businessList.add(BusinessView(R.drawable.business_2, "Last day","Kebuli Abuya 10 Cabang Jabo...", "70%", "Rp 1.947.500.000"))

        val businessAdapter = BusinessAdapter(businessList)
        businessView.adapter = businessAdapter
    }
}

