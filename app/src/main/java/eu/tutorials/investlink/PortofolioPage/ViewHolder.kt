package eu.tutorials.investlink.PortofolioPage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.R

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.portofolio_template,parent,false)) {
        private var imgView: ImageView? = null
        private var value: TextView? = null
        private var profit: TextView? = null

    init {
        imgView = itemView.findViewById(R.id.img_icon)
        value= itemView.findViewById(R.id.portofolio_value)
        profit = itemView.findViewById(R.id.profit)

    }
    fun bind(data : ListItem){
        imgView?.setImageResource(data.imgView)
        value?.text = data.value
        profit?.text = data.profit
    }
}