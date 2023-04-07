package eu.tutorials.investlink.TransaksiPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import eu.tutorials.investlink.R


class transaksi_fragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_transaksi_fragment,container,false)

        viewPager = view.findViewById(R.id.viewpager_transaksi)
        tabLayout = view.findViewById(R.id.tab_layout)

        viewPager.adapter = ViewPageAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> tab.text = "Purcase"
                1 -> tab.text = "Sell"
            }
        }.attach()

        return view
    }

}