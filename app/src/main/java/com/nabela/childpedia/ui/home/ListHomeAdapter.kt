package com.nabela.childpedia.ui.home

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

class ListHomeAdapter : RecyclerView.Adapter<ListHomeAdapter.ListViewHolder>() {
    private val mData = ArrayList<EncyclopediaEntity>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(items: ArrayList<EncyclopediaEntity>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemHomeBinding.bind(itemView)
        fun bind (item: EncyclopediaEntity) {
            binding.tvTitle.text = item.title
            binding.tvContext.text = item.description
            Glide.with(itemView.context)
                .load(item.image)
                .transform(CenterInside(),RoundedCorners(24))
                .into(binding.ivItem)
            itemView.setOnClickListener { onItemClickCallback?.onItemClicked(item) }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(item: EncyclopediaEntity)
    }
}