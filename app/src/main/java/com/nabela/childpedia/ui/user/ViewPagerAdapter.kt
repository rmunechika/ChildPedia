package com.nabela.childpedia.ui.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.data.entity.UserEntity
import java.util.ArrayList

class ViewPagerAdapter(childFragmentManager: FragmentManager) : FragmentPagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentListTitleList = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmentList.size
    }


    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentListTitleList[position]
    }
    fun addFragment(fragment: Fragment, title:String){
        mFragmentList.add(fragment)
        mFragmentListTitleList.add(title)
    }
}