package com.example.feature.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature.home.HomeRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

const val EMPTY_ARG = "empty_arg"

class HomeViewModel @AssistedInject constructor(
    private val homeRepository: HomeRepository,
    @Assisted private val testData: String
) : ViewModel() {

    fun logData() {
        Log.d("HomeViewModel", testData)
    }

    @AssistedFactory
    interface Factory {
        fun create(testData: String): HomeViewModel
    }
}

class HomeViewModelAssistedFactory @Inject constructor(
    private val assistedFactory: HomeViewModel.Factory
) : ViewModelProvider.Factory {

    var argument: String = EMPTY_ARG

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(argument) as T
    }
}