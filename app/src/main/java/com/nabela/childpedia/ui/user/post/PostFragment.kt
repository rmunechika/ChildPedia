package com.nabela.childpedia.ui.user.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nabela.childpedia.databinding.FragmentUserPostBinding

class PostFragment : Fragment() {

    private lateinit var postFragmentBinding: FragmentUserPostBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        postFragmentBinding = FragmentUserPostBinding.inflate(layoutInflater, container, false)
        return postFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[PostViewModel::class.java]
        val encyclopedia = viewModel.getEncyclopedia()

        val posAdapter = PostAdapter()
        posAdapter.setEncyclopedia(encyclopedia)

        with(postFragmentBinding.rvUserPost){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = posAdapter
        }
    }

}