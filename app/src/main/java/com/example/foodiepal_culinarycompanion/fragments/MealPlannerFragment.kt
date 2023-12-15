package com.example.foodiepal_culinarycompanion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.databinding.FragmentMealPlannerBinding
import com.example.foodiepal_culinarycompanion.fragments.adapter.MealPlannerAdapter
import com.example.foodiepal_culinarycompanion.fragments.data.RecipeRepository
import com.example.foodiepal_culinarycompanion.fragments.model.MealPlan
import com.example.foodiepal_culinarycompanion.fragments.model.Recipe

class MealPlannerFragment: Fragment() {

    private lateinit var binding: FragmentMealPlannerBinding
    private var mealPlans = ArrayList<MealPlan>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = layoutInflater.inflate(R.layout.fragment_meal_planner, container, false)
        binding = FragmentMealPlannerBinding.bind(view)

        mealPlans.add(MealPlan("9/10/12", RecipeRepository.recipes[0]))
        mealPlans.add(MealPlan("9/11/12", RecipeRepository.recipes[1]))

        val adapter = MealPlannerAdapter(mealPlans)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        binding.fab.setOnClickListener(::onFabButtonClickListener)

        return binding.root
    }

    private fun onFabButtonClickListener(view: View){
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        builder.setTitle("Plan a meal")
        val dialogLayout = inflater.inflate(R.layout.dialog_to_save_a_new_meal_plan, null)
        val datePicker  = dialogLayout.findViewById<DatePicker>(R.id.datePicker)
        val recipeSpinner = dialogLayout.findViewById<Spinner>(R.id.recipe)
        val recipeName = RecipeRepository.recipes.map { it.title }
        recipeSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, recipeName)
        builder.setView(dialogLayout)

        var recipe: Recipe? = null

        recipeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                recipe = RecipeRepository.recipes[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        builder.setPositiveButton("OK") { _, _ ->
            val date = "${datePicker.month}/${datePicker.dayOfMonth}/${datePicker.year}"
            mealPlans.add(MealPlan(date, recipe!!))
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
        builder.show()
    }
}