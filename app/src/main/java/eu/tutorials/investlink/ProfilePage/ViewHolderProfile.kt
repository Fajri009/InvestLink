package eu.tutorials.investlink.ProfilePage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.PortofolioPage.ListItem
import eu.tutorials.investlink.R

class ViewHolderProfile(inflater: LayoutInflater,parent:ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.profile_template,parent,false)) {
    private var imgView: ImageView? = null
    private var textProfile: TextView? = null
    init {
        imgView = itemView.findViewById(R.id.profile_icon)
        textProfile = itemView.findViewById(R.id.profile_text)
    }
    fun binding(data : ListItemProfil){
        imgView?.setImageResource(data.imgView)
        textProfile?.text = data.textProfile

    }
}