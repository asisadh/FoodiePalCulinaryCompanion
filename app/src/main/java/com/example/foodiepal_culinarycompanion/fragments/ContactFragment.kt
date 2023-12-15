package com.example.foodiepal_culinarycompanion.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.databinding.FragmentContactBinding
import com.example.foodiepal_culinarycompanion.fragments.adapter.ChefFragmentAdapter
import com.example.foodiepal_culinarycompanion.fragments.model.Chef

class ContactFragment: Fragment() {

    private lateinit var binding: FragmentContactBinding
    val chefs = ArrayList<Chef>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_contact,container, false)
        binding = FragmentContactBinding.bind(view)


        chefs.add(Chef("Willy Wonka", "Famous for sushi", "202-793-2132", "willy_wonka@gmail.com", R.drawable.another))
        chefs.add(Chef("Gordon Ramsay", "Michelin-starred chef", "555-1234", "gordon_ramsay@gmail.com",  R.drawable.gordon))
        chefs.add(Chef("Julia Child", "French cuisine expert", "555-5678", "julia_child@gmail.com", R.drawable.alex))
        chefs.add(Chef("Bobby Flay", "Grilling and BBQ master", "555-9012", "bobby_flay@gmail.com", R.drawable.antonia))
        chefs.add(Chef("Nigella Lawson", "Queen of home cooking", "555-3456", "nigella_lawson@gmail.com", R.drawable.gordon))
        chefs.add(Chef("Anthony Bourdain", "Culinary adventurer", "555-7890", "anthony_bourdain@gmail.com", R.drawable.another))
        chefs.add(Chef("Ina Garten", "Barefoot Contessa", "555-2345", "ina_garten@gmail.com", R.drawable.alex))
        chefs.add(Chef("Jamie Oliver", "The Naked Chef", "555-6789", "jamie_oliver@gmail.com", R.drawable.gordon))
        chefs.add(Chef("Emeril Lagasse", "Bam! Flavorful cooking", "555-1235", "emeril_lagasse@gmail.com", R.drawable.alex))
        chefs.add(Chef("Giada De Laurentiis", "Italian cuisine expert", "555-6780", "giada_de_laurentiis@gmail.com", R.drawable.another))
        chefs.add(Chef("Heston Blumenthal", "Experimental gastronomy", "555-8901", "heston_blumenthal@gmail.com", R.drawable.antonia))

        val adapter = ChefFragmentAdapter(chefs, ::sendMail, ::callChef)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }

    private fun sendMail(position: Int){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse(chefs[position].email ?: "")
        intent.type = ("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT, chefs[position].bio)
        if(intent.resolveActivity(requireActivity().packageManager) != null){
            startActivity(intent)
        }
    }

    private fun callChef(position: Int){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:${chefs[position].phone}")
        if(intent.resolveActivity(requireActivity().packageManager) != null){
            startActivity(intent)
        }
    }
}