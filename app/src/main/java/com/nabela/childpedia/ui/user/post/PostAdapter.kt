package com.nabela.childpedia.ui.user.post

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.databinding.ItemRowUserPostBinding
import com.nabela.childpedia.ui.detail.DetailActivity
import java.util.ArrayList

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var listPost = ArrayList<EncyclopediaEntity>()

    fun setEncyclopedia(encyclopedia: List<EncyclopediaEntity>?) {
        if (encyclopedia == null) return
        this.listPost.clear()
        this.listPost.addAll(encyclopedia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemSmallBinding = ItemRowUserPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(itemSmallBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val ency = listPost[position]
        holder.bind(ency)
    }

    override fun getItemCount(): Int = listPost.size

    class PostViewHolder(private val binding: ItemRowUserPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ency: EncyclopediaEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(ency.image)
                    .centerCrop()
                    .into(imgPost)
                tvTitlePost.text = ency.title
                tvDescriptionPost.text = ency.description
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