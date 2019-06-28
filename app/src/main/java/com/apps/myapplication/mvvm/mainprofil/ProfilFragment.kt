package com.apps.myapplication.mvvm.mainprofil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.myapplication.base.BaseFragment
import com.apps.myapplication.data.model.Profile
import com.apps.myapplication.data.source.remote.ApiClient
import com.apps.myapplication.data.source.remote.ApiInterfaces
import com.apps.myapplication.databinding.ProfileFragmentBinding
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.R.id
import android.R.attr.data
import android.util.Log
import com.apps.myapplication.data.source.remote.response.NewsResponse
import com.apps.myapplication.utils.ConstantUtils
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ProfilFragment : BaseFragment(){

    companion object {
        fun newInstance() = ProfilFragment().apply {

        }
    }
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ProfileFragmentBinding.inflate(inflater, container, false)
         return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}