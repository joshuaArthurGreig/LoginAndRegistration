package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginandregistration.databinding.ActivityRegistration1Binding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistration1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistration1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //access any values that were sent to us from the intent that launched this activity
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user:$username pwd $password", Toast.LENGTH_SHORT).show()

        binding.buttonRegisterRegister.setOnClickListener {

            if(!RegistrationUtil.validateName(binding.editTextRegisterName.text.toString())) {
                Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show()
            } else {

                var returnToLoginIntent = Intent().apply {
                    putExtra(
                        LoginActivity.EXTRA_USERNAME,
                        binding.editTextRegisterUsername.text.toString()
                    )
                    putExtra(
                        LoginActivity.EXTRA_PASSWORD,
                        binding.editTextRegisterPassword.text.toString()
                    )
                }
                setResult(Activity.RESULT_OK, returnToLoginIntent)
                finish()
            }
        }
    }
}