package com.example.foodiepal_culinarycompanion.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.fragments.model.Chef

class ChefFragmentAdapter(private val chefs: List<Chef>, val sendMail: (Int) -> Unit, val callChef: (Int) -> Unit): RecyclerView.Adapter<ChefFragmentAdapter.ChefItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChefItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chef_card, parent, false)
        return ChefItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chefs.size
    }

    override fun onBindViewHolder(holder: ChefItemViewHolder, position: Int) {
        holder.tvName.text = chefs[position].name
        holder.tvBio.text = chefs[position].bio
        holder.tvEmail.text = chefs[position].email
        holder.tvPhone.text = chefs[position].phone
        holder.imageView.setImageResource(chefs[position].imageId)

        holder.tvEmail.setOnClickListener {
            sendMail(position)
        }

        holder.tvPhone.setOnClickListener {
            callChef(position)
        }
    }

    inner class ChefItemViewHolder(item: View): RecyclerView.ViewHolder(item){
        val tvName: TextView = item.findViewById(R.id.nameTextView)
        val tvBio: TextView = item.findViewById(R.id.bioTextView)
        val tvEmail: TextView = item.findViewById(R.id.emailTextView)
        val tvPhone: TextView = item.findViewById(R.id.phoneTextView)
        val imageView: ImageView = item.findViewById(R.id.profileImageView)
    }
}