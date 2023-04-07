package eu.tutorials.investlink.PortofolioPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.R
import eu.tutorials.investlink.PortofolioPage.AdapterPortofolio as AdapterPortofolio

class portofolio_fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterPortofolio
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_portofolio_fragment, container, false)
        recyclerView = view.findViewById(R.id.portofolio_recylerview)

        init()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    fun init(){
        var data = ArrayList<ListItem>()
        data.add(ListItem(R.drawable.indomaret,"2000000","10000"))
        data.add(ListItem(R.drawable.icon1,"200000","0"))
        data.add(ListItem(R.drawable.icon2,"500000","2000"))
        data.add(ListItem(R.drawable.icon3,"6000000","0"))
        data.add(ListItem(R.drawable.icon4,"3000000","90000"))
        adapter = AdapterPortofolio(data)
    }


}