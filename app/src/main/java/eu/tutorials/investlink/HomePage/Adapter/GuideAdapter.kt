package eu.tutorials.investlink.HomePage.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.HomePage.Model.GuideView
import eu.tutorials.investlink.R

class GuideAdapter(private val guideList: List<GuideView>) : RecyclerView.Adapter<GuideAdapter.GuideViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guide_layout, parent, false)
        return GuideViewHolder(view)
    }

    inner class GuideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val guideImage: ImageView = itemView.findViewById(R.id.guideFoto)
        val guideTitle: TextView = itemView.findViewById(R.id.guideJudul)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.guideImage.setImageResource(guideList[position].getImage())
        holder.guideTitle.text = guideList[position].getJudul()
    }

    override fun getItemCount(): Int {
        return guideList.size
    }
}