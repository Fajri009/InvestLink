package eu.tutorials.investlink.HomePage.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.HomePage.Adapter.BusinessAdapter
import eu.tutorials.investlink.HomePage.Adapter.GuideAdapter
import eu.tutorials.investlink.HomePage.Model.BusinessView
import eu.tutorials.investlink.HomePage.Model.GuideView
import eu.tutorials.investlink.ListBusinessPage.ListBusiness
import eu.tutorials.investlink.R
import eu.tutorials.investlink.SaldoPage.SaldoPage

class home_fragment : Fragment() {
    private lateinit var guideView : RecyclerView
    private lateinit var businessView : RecyclerView
    private lateinit var template : LinearLayout
    private lateinit var seeBusiness : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)
        template = view.findViewById(R.id.template)
        seeBusiness = view.findViewById(R.id.see_business)
        guideView = view.findViewById(R.id.guideView)
        businessView = view.findViewById(R.id.businessView)

        btnSaldo()
        guideList()
        seeBusiness()
        businessList()

        return view
    }

    private fun btnSaldo() {
        template.setOnClickListener {
            startActivity(Intent(requireActivity(), SaldoPage::class.java))
        }
    }

    private fun seeBusiness() {
        seeBusiness.setOnClickListener {
            startActivity(Intent(requireActivity(), ListBusiness::class.java))
        }
    }

    private fun guideList() {
        guideView.setHasFixedSize(true)
        guideView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val guideList = mutableListOf<GuideView>()

        guideList.add(GuideView(R.drawable.guide_1, "Cara Kerja Invest Link"))
        guideList.add(GuideView(R.drawable.guide_1, "Dividend distribution"))
        guideList.add(GuideView(R.drawable.guide_1, "Cara Kerja Invest Link"))
        guideList.add(GuideView(R.drawable.guide_1, "Dividend distribution"))

        val guideAdapter = GuideAdapter(guideList)
        guideView.adapter = guideAdapter
    }

    private fun businessList() {
        businessView.setHasFixedSize(true)
        businessView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val businessList = mutableListOf<BusinessView>()

        businessList.add(BusinessView(R.drawable.business_1, "2 more days", "Alfamidi Panyileukan Bandung", "32%", "Rp 5.171.000.000"))
        businessList.add(BusinessView(R.drawable.business_2, "Last day","Kebuli Abuya 10 Cabang Jabo...", "70%", "Rp 1.947.500.000"))
        businessList.add(BusinessView(R.drawable.business_1, "2 more days","Alfamidi Panyileukan Bandung", "32%", "Rp 5.171.000.000"))
        businessList.add(BusinessView(R.drawable.business_2, "Last day","Kebuli Abuya 10 Cabang Jabo...", "70%", "Rp 1.947.500.000"))

        val businessAdapter = BusinessAdapter(businessList)
        businessView.adapter = businessAdapter
    }
}