package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    //any time you need what would have been a "static" variable in java, you use companion object in Kotlin.
    //You access with ClassName.VARIABLE_NAME like Math.PI
    companion object {
        //keys for the key-value pairs for the intent extras
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }


    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result : ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data

                binding.editTextTextUserName.setText(intent?.getStringExtra(EXTRA_USERNAME))
                binding.editTextTextPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewCreateAccount.setOnClickListener {
            //launch the registration activity
            //pass the values of the username and password to the new activity
            // 1. extract any information you might need from edit texts
            val username = binding.editTextTextUserName.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            // 2. create the intent and package the extras
            //the context is the activity you are in (here we can use this)
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }

            // 3. start the activity
//            startActivity(registrationIntent)

            //3b. Alternate: could launch the activity for a result instead
            startRegistrationForResult.launch(registrationIntent)
        }
    }
}