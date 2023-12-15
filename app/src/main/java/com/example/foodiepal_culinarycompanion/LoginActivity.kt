package com.example.foodiepal_culinarycompanion

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiepal_culinarycompanion.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = binding.username.text
        val password = binding.password.text

        binding.login.setOnClickListener {
            if(!username.isNullOrEmpty() || !password.isNullOrEmpty()){
                login(username.toString(),password.toString())
            }else{
                Toast.makeText(this,"All information are required.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signup.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
    }

    private fun login(username: String, password: String){
        // Retrieving the value using its keys the file name
        val sharedPreferences = getSharedPreferences("FoodiePalCulinary", MODE_PRIVATE)
        val usernameSh = sharedPreferences.getString("email","")
        val passwordSh = sharedPreferences.getString("password","")

        if ( !usernameSh.isNullOrEmpty() && !passwordSh.isNullOrEmpty() && usernameSh == username && passwordSh == password){
            redirectToHome()
        }
    }

    private fun redirectToHome(){
        val homeIntent = Intent(this,MainActivity::class.java)
        startActivity(homeIntent)
    }
}