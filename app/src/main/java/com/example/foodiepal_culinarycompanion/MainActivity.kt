package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiepal_culinarycompanion.databinding.ActivityMainBinding
import com.example.foodiepal_culinarycompanion.fragments.adapter.FoodiePalFragmentAdapter
import com.example.foodiepal_culinarycompanion.fragments.data.RecipeRepository
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val fragmentAdapter = FoodiePalFragmentAdapter(this)
        binding.viewpager.adapter = fragmentAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager, ::setupTabLayout).attach()

        binding.bottomNavigationView.setOnItemSelectedListener(::setOnButtonNavigationItemClickListener)

        // bind the recipe dataSource
        RecipeRepository.intializeData()
    }

    private fun setupTabLayout(tab: TabLayout.Tab, position: Int){
        tab.text = FoodiePalFragmentAdapter.fragmentsName[position]
    }

    private fun setOnButtonNavigationItemClickListener(menuItem: MenuItem): Boolean{
        when (menuItem.itemId){
            R.id.menuReceipe -> changeTheCurrentViewPager(0)
            R.id.menuMealPlanner -> changeTheCurrentViewPager(1)
            R.id.menuBlog -> changeTheCurrentViewPager(2)
        }
        return true
    }

    private fun changeTheCurrentViewPager(page: Int){
        binding.viewpager.setCurrentItem(page, true)
    }
}