package com.nabela.childpedia.ui.user.achievement

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nabela.childpedia.data.entity.AchievementEntity
import com.nabela.childpedia.databinding.ItemRowUserAchievementBinding
import java.util.ArrayList

class AchievementAdapter : RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {
    private var listAchievement = ArrayList<AchievementEntity>()

    fun setAchievement(tropy: List<AchievementEntity>?) {
        if (tropy == null) return
        this.listAchievement.clear()
        this.listAchievement.addAll(tropy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val itemAchievement = ItemRowUserAchievementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AchievementViewHolder(itemAchievement)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        val achievement = listAchievement[position]
        holder.bind(achievement)
    }

    override fun getItemCount(): Int = listAchievement.size

    class AchievementViewHolder(private val binding: ItemRowUserAchievementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(achievement: AchievementEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(achievement.image)
                    .centerCrop()
                    .into(imgAchievement)
                tvAchievement.text = achievement.name
                tvAchievementDesc.text = achievement.description
            }
        }
    }
}