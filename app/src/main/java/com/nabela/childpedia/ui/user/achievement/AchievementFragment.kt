package com.nabela.childpedia.ui.user.achievement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nabela.childpedia.databinding.FragmentUserAchievementBinding

class AchievementFragment : Fragment() {

    private var _binding: FragmentUserAchievementBinding? = null
    private val binding get() = _binding as FragmentUserAchievementBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserAchievementBinding.inflate(inflater, container, false)
        return binding.root
    }
}