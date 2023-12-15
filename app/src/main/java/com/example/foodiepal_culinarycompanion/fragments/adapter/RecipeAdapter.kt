package com.example.foodiepal_culinarycompanion.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.fragments.model.Recipe

class RecipeAdapter(private val recipeList: List<Recipe>): RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_card_view,parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.tvTitle.text = recipeList[position].title
        holder.tvChef.text = recipeList[position].chef
        holder.tvDescription.text = recipeList[position].description
        holder.imageView.setImageResource(recipeList[position].imageId)
    }

    inner class RecipeViewHolder(item: View): RecyclerView.ViewHolder(item){
        var tvTitle: TextView = item.findViewById<TextView>(R.id.title)
        var tvChef: TextView = item.findViewById(R.id.chef)
        var tvDescription: TextView = item.findViewById(R.id.shortDescription)
        var imageView: ImageView = item.findViewById(R.id.coverImageView)
    }
}