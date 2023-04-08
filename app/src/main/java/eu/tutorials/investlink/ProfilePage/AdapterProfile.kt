package eu.tutorials.investlink.ProfilePage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterProfile(private val data: ArrayList<ListItemProfil>): RecyclerView.Adapter<ViewHolderProfile>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProfile {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolderProfile(inflater,parent)
    }

    override fun onBindViewHolder(holder: ViewHolderProfile, position: Int) {
        holder.binding(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }
}
