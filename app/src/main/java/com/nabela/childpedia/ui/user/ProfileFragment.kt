package com.nabela.childpedia.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nabela.childpedia.R
import com.nabela.childpedia.ui.home.UserSectionPagerAdapter
import com.nabela.childpedia.databinding.FragmentUserProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding as FragmentUserProfileBinding
    private lateinit var viewPager: ViewPager2

    companion object {
        @StringRes private val TAB_TITLES = intArrayOf(
            R.string.title_post,
            R.string.tab_title_achievement
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabs = binding.tabUser
        val pagerAdapter = UserSectionPagerAdapter(this)
        viewPager = binding.viewpagerUser
        viewPager.adapter = pagerAdapter
        viewPager.isSaveEnabled = false
        TabLayoutMediator(tabs, viewPager) {tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }
}