package com.example.foodiepal_culinarycompanion.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodiepal_culinarycompanion.fragments.AboutMeFragment
import com.example.foodiepal_culinarycompanion.fragments.BlogFragment
import com.example.foodiepal_culinarycompanion.fragments.ContactFragment
import com.example.foodiepal_culinarycompanion.fragments.MealPlannerFragment
import com.example.foodiepal_culinarycompanion.fragments.RecipesFragment

class FoodiePalFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    companion object{
        val fragmentsName = arrayListOf<String>("Recipes","Meal Planner", "Blog", "Contact" ,"About Me")
    }
    private val fragments = arrayListOf<Fragment>( RecipesFragment(), MealPlannerFragment(),  BlogFragment(), ContactFragment(), AboutMeFragment() )
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}