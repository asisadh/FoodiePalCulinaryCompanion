package com.example.foodiepal_culinarycompanion.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.fragments.model.MealPlan

class MealPlannerAdapter(private val plans: List<MealPlan>): RecyclerView.Adapter<MealPlannerAdapter.MealPlannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_planner_item_view, parent, false)
        return MealPlannerViewHolder(view)
    }

    override fun getItemCount(): Int = plans.size

    override fun onBindViewHolder(holder: MealPlannerViewHolder, position: Int) {
        holder.dateTV.text = plans[position].date
        holder.mealNameTv.text = plans[position].recipe.title
    }

    inner class MealPlannerViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val dateTV: TextView = item.findViewById(R.id.date)
        val mealNameTv: TextView = item.findViewById(R.id.mealName)
    }
}