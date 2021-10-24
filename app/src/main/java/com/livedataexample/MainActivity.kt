package com.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout : TabLayout
    private lateinit var tabViewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var root : View =  getLayoutInflater().inflate(R.layout.activity_main, null);
        tabLayout = root.findViewById(R.id.tabLayout)
        setContentView(root)

        val numTabs : Int = 7
        val adapter : TabsPagerAdapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numTabs)
        tabViewPager2 = root.findViewById(R.id.tabViewPager2)
        tabViewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, tabViewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "LiveData & Coroutines"
                }
                1 -> {
                    tab.text = "ViewBinding & DataBinding"
                }
                2 -> {
                    tab.text = "Compose Layouts1"
                }
                3 -> {
                    tab.text = "Compose Layouts2"
                }
                4 -> {
                    tab.text = "Compose Layouts3"
                }
                5 -> {
                    tab.text = "Compose Layouts4"
                }
                6 -> {
                    tab.text = "Compose Layouts5"
                }
                else -> "0"
            }
        }.attach()

    }

}