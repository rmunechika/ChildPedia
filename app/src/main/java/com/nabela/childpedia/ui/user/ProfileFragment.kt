package com.nabela.childpedia.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nabela.childpedia.databinding.FragmentProfileBinding
import com.nabela.childpedia.ui.user.achievement.AchievementFragment
import com.nabela.childpedia.ui.user.post.PostFragment

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout()
    }

    private fun tabLayout(){
        val adapter = ViewPagerAdapter(childFragmentManager)

        adapter.addFragment(PostFragment(),"Post")
        adapter.addFragment(AchievementFragment(),"Achievement")
        _binding?.viewpagerUser?.adapter = adapter
        _binding?.tabUser?.setupWithViewPager(_binding?.viewpagerUser)
    }
}