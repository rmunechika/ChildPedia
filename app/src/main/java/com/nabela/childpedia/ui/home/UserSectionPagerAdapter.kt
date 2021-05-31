package com.nabela.childpedia.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nabela.childpedia.ui.user.UserProfileFragment
import com.nabela.childpedia.ui.user.achievement.UserAchievementFragment
import com.nabela.childpedia.ui.user.post.PostFragment

class UserSectionPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> PostFragment()
            1 -> UserAchievementFragment()
            else -> UserProfileFragment()
        }
    }
}