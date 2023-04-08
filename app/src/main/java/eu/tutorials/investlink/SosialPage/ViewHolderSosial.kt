package eu.tutorials.investlink.SosialPage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.R

class ViewHolderSosial(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
    R.layout.sosial_template,parent,false)) {
    private var imgIcon: ImageView? = null
    private var textCompany: TextView? = null
    private var imgContex: ImageView? = null
    private var textFollow: TextView? = null

    init {
        imgIcon = itemView.findViewById(R.id.img_view)
        textCompany = itemView.findViewById(R.id.company_name)
        imgContex = itemView.findViewById(R.id.context_image)
        textFollow = itemView.findViewById(R.id.following)
    }

    fun binding(data: ListItemSosial){
        imgIcon?.setImageResource(data.imgIcon)
        textCompany?.text = data.textCompany
        textFollow?.text = data.textFollow
        imgContex?.setImageResource(data.imgContex)
    }
}