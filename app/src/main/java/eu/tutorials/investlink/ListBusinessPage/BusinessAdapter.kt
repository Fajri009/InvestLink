package eu.tutorials.investlink.ListBusinessPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.R

class BusinessAdapter(private val businessList: List<BusinessView>) : RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.investment_layout, parent, false)
        return BusinessViewHolder(view)
    }

    inner class BusinessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val businessImage: ImageView = itemView.findViewById(R.id.businessFoto)
        val businessDays: TextView = itemView.findViewById(R.id.businessDay)
        val businessJudul: TextView = itemView.findViewById(R.id.businessJudul)
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.businessImage.setImageResource(businessList[position].getImage())
        holder.businessDays.text = businessList[position].getDays()
        holder.businessJudul.text = businessList[position].getJudul()
    }

    override fun getItemCount(): Int {
        return businessList.size
    }
}