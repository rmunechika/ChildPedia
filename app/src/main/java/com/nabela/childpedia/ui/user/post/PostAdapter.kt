package com.nabela.childpedia.ui.user.post

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
        val film = listPost[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = listPost.size

    class PostViewHolder(private val binding: ItemRowUserPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: EncyclopediaEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(film.image)
                    .centerCrop()
                    .into(img)
                tvTitle.text = film.title
                tvDescription.text = film.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_IMG,film.image)
                    intent.putExtra(DetailActivity.EXTRA_TITLE,film.title)
                    intent.putExtra(DetailActivity.EXTRA_DESCRIPTION,film.description)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}