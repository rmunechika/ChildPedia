package com.nabela.childpedia.ui.user.achievement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nabela.childpedia.databinding.FragmentAchievementBinding
import com.nabela.childpedia.databinding.FragmentPostBinding
import com.nabela.childpedia.ui.user.post.PostAdapter
import com.nabela.childpedia.ui.user.post.PostViewModel

class AchievementFragment : Fragment() {

    private lateinit var fragmentAchievementBinding: FragmentAchievementBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentAchievementBinding = FragmentAchievementBinding.inflate(layoutInflater, container, false)
        return fragmentAchievementBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AchevementViewModel::class.java]
        val achievement = viewModel.getAchievement()

        val achievementAdapter = AchievementAdapter()
        achievementAdapter.setAchievement(achievement)

        with(fragmentAchievementBinding.rvUserAchievement){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = achievementAdapter
        }
    }

}