package eu.tutorials.investlink.HomePage.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.HomePage.Model.BusinessView
import eu.tutorials.investlink.R

class BusinessAdapter(private val businessList: List<BusinessView>) : RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.business_layout, parent, false)
        return BusinessViewHolder(view)
    }

    inner class BusinessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val businessImage: ImageView = itemView.findViewById(R.id.businessFoto)
        val businessDays : TextView = itemView.findViewById(R.id.businessDays)
        val businessTitle: TextView = itemView.findViewById(R.id.businessJudul)
        val businessValue : TextView = itemView.findViewById(R.id.businessValue)
        val businessMoney : TextView = itemView.findViewById(R.id.businessMoney)
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.businessImage.setImageResource(businessList[position].getImage())
        holder.businessDays.text = businessList[position].getDays()
        holder.businessTitle.text = businessList[position].getJudul()
        holder.businessValue.text = businessList[position].getValue()
        holder.businessMoney.text = businessList[position].getMoney()
    }

    override fun getItemCount(): Int {
        return businessList.size
    }
}