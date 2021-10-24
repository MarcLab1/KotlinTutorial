package com.livedataexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.livedataexample.Binding.BindingFragment
import com.livedataexample.Composite.*
import com.livedataexample.Lifecycle.LifecycleFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0-> {
                return LifecycleFragment()
            }
            1 -> {
                return BindingFragment()
            }
            2 -> {
                return ComposeFragment()
            }
            3 -> {
                return ComposeFragmentTwo()
            }
            4 -> {
                return ComposeFragmentThree()
            }
            5 -> {
                return ComposeFragmentFour()
            }
            6 -> {
                return ComposeFragmentFive()
            }
            else -> return LifecycleFragment() //do I even need this?
        }
    }

    override fun getItemCount(): Int {
        return numTabs
    }
}