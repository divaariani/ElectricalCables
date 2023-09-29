package com.divaariani.electricalcables.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.divaariani.electricalcables.R
import com.divaariani.electricalcables.data.Cable

class FavoriteAdapter(
    private var cableFavoriteList: List<FavoriteCable>,
    private val onItemClick: (Cable) -> Unit
) : RecyclerView.Adapter<FavoriteAdapter.CableViewHolder>() {

    inner class CableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleCable: TextView = itemView.findViewById(R.id.title_cable)
        val photoCable: ImageView = itemView.findViewById(R.id.image_cable)

        fun bind(cable: Cable) {
            titleCable.text = cable.name
            Glide.with(itemView)
                .load(cable.photoUrl)
                .into(photoCable)
            itemView.setOnClickListener {
                onItemClick(cable)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CableViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite, parent, false)
        return CableViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CableViewHolder, position: Int) {
    }

    override fun getItemCount() = cableFavoriteList.size
}