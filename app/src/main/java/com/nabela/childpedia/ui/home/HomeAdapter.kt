package com.nabela.childpedia.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.databinding.ItemHomeBinding
import com.nabela.childpedia.ui.detail.DetailActivity
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
                    .into(imgHome)
                tvTitleHome.text = ency.title
                tvDescriptionHome.text = ency.description
                tvCategoryHome.text=ency.category
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_IMG,ency.image)
                    intent.putExtra(DetailActivity.EXTRA_TITLE,ency.title)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY,ency.category)
                    intent.putExtra(DetailActivity.EXTRA_DESCRIPTION,ency.description)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}