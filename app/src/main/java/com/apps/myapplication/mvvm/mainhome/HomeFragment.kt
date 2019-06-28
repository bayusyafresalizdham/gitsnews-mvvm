package com.apps.myapplication.mvvm.mainhome

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.myapplication.base.BaseActivity
import com.apps.myapplication.base.BaseFragment
import com.apps.myapplication.data.model.Profile
import com.apps.myapplication.data.source.remote.ApiClient
import com.apps.myapplication.data.source.remote.ApiInterfaces
import com.apps.myapplication.data.source.remote.response.NewsResponse
import com.apps.myapplication.databinding.HomeFragmentBinding
import com.apps.myapplication.databinding.ProfileFragmentBinding
import com.apps.myapplication.utils.ConstantUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : BaseFragment(){
    private lateinit var viewBinding: HomeFragmentBinding
    private lateinit var mainAdapter: HomeAdapter
    private  lateinit var viewModel : HomeViewModel

    companion object {
        private val ARG_CAUGHT = "myFragment_caught"

        fun newInstance(caught: String) : HomeFragment{
            val args: Bundle = Bundle()
            Log.d("cekstring",""+caught)
            args.putSerializable(ARG_CAUGHT, caught)
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = HomeFragmentBinding.inflate(inflater, container, false)
        viewModel = HomeViewModel(activity?.applicationContext as Application, activity!!)
        viewBinding.viewModel = viewModel
        var category = arguments?.getSerializable(ARG_CAUGHT) as String
        viewBinding.let {
            it.viewModel = viewBinding.viewModel
            it.setLifecycleOwner(this@HomeFragment)
        }

        viewModel.start(category)
        return viewBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupNews()
    }


    override fun onResume() {
        super.onResume()
    }


    private fun setupNews() {
        val viewModel = viewBinding.viewModel

        if (viewModel != null) {
            mainAdapter = HomeAdapter(ArrayList(), activity!!, viewModel)

            viewBinding.recyclerviewMain.adapter = mainAdapter
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}