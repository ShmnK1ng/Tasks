package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Router(private val fragmentManager: FragmentManager, private val containerId: Int) {


    fun navigateTo(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = fragmentManager.beginTransaction()
            .replace(containerId, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    fun navigateBack() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        }
    }

    fun canNavigateBack(): Boolean {
        return fragmentManager.backStackEntryCount > 0
    }
}