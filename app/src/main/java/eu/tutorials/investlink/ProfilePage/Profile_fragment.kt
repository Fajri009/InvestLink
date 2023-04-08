package eu.tutorials.investlink.ProfilePage

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.R


class profile_fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterProfile: AdapterProfile

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile_fragment,container,false)
        recyclerView = view.findViewById(R.id.profile_rv)

        init()

        recyclerView.adapter = adapterProfile
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        return view
    }

    private fun init() {
        var dataProfil = ArrayList<ListItemProfil>()

        dataProfil.add(ListItemProfil(R.drawable.personaldata,"Personal Data"))
        dataProfil.add(ListItemProfil(R.drawable.settings,"Settings"))
        dataProfil.add(ListItemProfil(R.drawable.invitefriends,"Invite Friends",))
        dataProfil.add(ListItemProfil(R.drawable.faq,"FAQ / Support",))
        dataProfil.add(ListItemProfil(R.drawable.term,"Term and Conditions",))
        dataProfil.add(ListItemProfil(R.drawable.privacypolice,"Privacy Policy",))
        dataProfil.add(ListItemProfil(R.drawable.logout,"Logout",))

        adapterProfile = AdapterProfile(dataProfil)
    }

}