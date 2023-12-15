package com.example.foodiepal_culinarycompanion.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.databinding.FragmentRecipesBinding
import com.example.foodiepal_culinarycompanion.fragments.adapter.RecipeAdapter
import com.example.foodiepal_culinarycompanion.fragments.data.RecipeRepository
import com.example.foodiepal_culinarycompanion.fragments.model.Recipe

class RecipesFragment: Fragment() {

    private lateinit var binding: FragmentRecipesBinding
    private val recipes = RecipeRepository.recipes
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        binding = FragmentRecipesBinding.bind(view)

        adapter = RecipeAdapter(recipes)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        binding.fab.setOnClickListener(::onFabButtonClickListener)

        return binding.root
    }

    private fun onFabButtonClickListener(view: View){
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        builder.setTitle("Add a new Recipe")
        val dialogLayout = inflater.inflate(R.layout.dialog_to_save_a_new_receipe, null)
        val title  = dialogLayout.findViewById<EditText>(R.id.recipeName)
        val shortDes = dialogLayout.findViewById<EditText>(R.id.description)
        val instruction = dialogLayout.findViewById<EditText>(R.id.instruction)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { _, _ ->
            recipes.add(0, Recipe(title.text.toString(), shortDes.text.toString(), instruction.text.toString(), R.drawable.chicken))
            adapter.notifyItemInserted(0)
            binding.recyclerView.scrollToPosition(0)
        }
        builder.show()
    }
}