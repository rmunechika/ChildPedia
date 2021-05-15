package com.nabela.childpedia.user.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nabela.childpedia.R
import com.nabela.childpedia.databinding.FragmentUserPostBinding

class UserPostFragment : Fragment() {

    private var _binding: FragmentUserPostBinding? = null
    private val binding get() = _binding as FragmentUserPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserPostBinding.inflate(inflater, container, false)
        return binding.root
    }
}