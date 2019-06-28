package com.apps.myapplication.mvvm.mainabout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.myapplication.base.BaseFragment
import com.apps.myapplication.databinding.AboutFragmentBinding

class AboutFragment : BaseFragment(){

    companion object {
        fun newInstance() = AboutFragment().apply {

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = AboutFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}