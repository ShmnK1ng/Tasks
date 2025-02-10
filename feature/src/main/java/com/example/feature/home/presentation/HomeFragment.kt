package com.example.feature.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.core.di.CoreComponentProvider
import com.example.feature.R
import com.example.feature.home.di.DaggerHomeComponent
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var assistedViewModelFactory: HomeViewModelAssistedFactory
    private val homeViewModel by viewModels<HomeViewModel> {
        assistedViewModelFactory.apply {
            argument = "Test Argument"
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val provider = requireActivity().application as? CoreComponentProvider
            ?: error("CoreComponentProvider not found")
        val coreComponent = provider.coreComponent
        val homeComponent = DaggerHomeComponent.factory().create(coreComponent)
        homeComponent.inject(this)
        homeViewModel.logData()
    }
}