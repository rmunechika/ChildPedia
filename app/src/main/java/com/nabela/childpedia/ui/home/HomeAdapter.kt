package com.nabela.childpedia.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.nabela.childpedia.R
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.databinding.ItemHomeBinding
import java.util.ArrayList

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var listEcyclopedia = ArrayList<EncyclopediaEntity>()

    fun setEncyclopedia(encyclopedia: List<EncyclopediaEntity>?) {
        if (encyclopedia == null) return
        this.listEcyclopedia.clear()
        this.listEcyclopedia.addAll(encyclopedia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBigBinding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBigBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val film = listEcyclopedia[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = listEcyclopedia.size


    class HomeViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ency: EncyclopediaEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(ency.image)
                    .centerCrop()
                    .into(img)
                tvTitle.text = ency.title
                tvDescription.text = ency.description
                tvCategory.text=ency.category
            }
        }
    }
}