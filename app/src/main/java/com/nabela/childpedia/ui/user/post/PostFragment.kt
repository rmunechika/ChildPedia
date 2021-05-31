package com.nabela.childpedia.ui.user.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nabela.childpedia.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    private lateinit var postFragmentBinding: FragmentPostBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        postFragmentBinding = FragmentPostBinding.inflate(layoutInflater, container, false)
        return postFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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