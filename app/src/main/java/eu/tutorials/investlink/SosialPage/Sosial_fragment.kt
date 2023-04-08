package eu.tutorials.investlink.SosialPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.R

class sosial_fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SosialAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sosial_fragment,container,false)
        recyclerView = view.findViewById(R.id.rv_sosial)
        init()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        return view
    }
    private fun init(){
        var dataSosial = ArrayList<ListItemSosial>()
        dataSosial.add(ListItemSosial(R.drawable.bulat_toko,"PT Autoglaze Fatmawati Tendean","Following PT Permata Nusantara, Agatha Kirana, Bagas Nugraha +20 more",R.drawable.marhaban))
        dataSosial.add(ListItemSosial(R.drawable.account_yellow,"Aditya Mahesa","Following PT Bunga Digital, Raihan Putra, Diva Maheswari +15 more",R.drawable.marhaban2))

        adapter = SosialAdapter(dataSosial)
    }


}