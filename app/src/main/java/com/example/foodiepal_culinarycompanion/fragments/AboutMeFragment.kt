package com.example.foodiepal_culinarycompanion.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.databinding.FragmentAboutMeBinding

class AboutMeFragment: Fragment() {

    private lateinit var binding: FragmentAboutMeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_about_me, container, false)
        binding = FragmentAboutMeBinding.bind(view)

        val sharedPreferences = requireActivity().getSharedPreferences("FoodiePalCulinary",
            AppCompatActivity.MODE_PRIVATE
        )
        val username = sharedPreferences.getString("email","")
        val name = sharedPreferences.getString("name","")

        binding.nameTextView.text = name
        binding.emailTextView.text = username

        binding.emailTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:${username}")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "send from intent")
            intent.putExtra(Intent.EXTRA_EMAIL,"Content of email is here")
            if(intent.resolveActivity(requireActivity().packageManager) != null){
                startActivity(intent)
            }
        }

        binding.logout.setOnClickListener {
            requireActivity().finish()
        }

        return binding.root
    }
}