package com.example.foodiepal_culinarycompanion

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiepal_culinarycompanion.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.name.text
        val email = binding.email.text
        val password = binding.password.text

        binding.signup.setOnClickListener {
            if(!name.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty()){
                saveUser(name.toString(), email.toString(), password.toString())
                redirectToHome()
            }else{
                Toast.makeText(this,"All information are required.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.login.setOnClickListener {
            finish()
        }
    }

    private fun saveUser(name: String, email: String, password: String){
        val sharedPreferences = getSharedPreferences("FoodiePalCulinary", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putString("name", name)
        myEdit.putString("email", email)
        myEdit.putString("password", password)
        myEdit.commit()
    }

    private fun redirectToHome(){
        val homeIntent = Intent(this,MainActivity::class.java)
        startActivity(homeIntent)
    }
}