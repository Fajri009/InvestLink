package eu.tutorials.investlink.SosialPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.investlink.ProfilePage.ViewHolderProfile

class SosialAdapter(private val data:ArrayList<ListItemSosial>): RecyclerView.Adapter<ViewHolderSosial>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSosial {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolderSosial(inflater,parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolderSosial, position: Int) {
        holder.binding(data[position])
    }
}