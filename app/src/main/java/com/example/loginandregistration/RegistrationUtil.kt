package com.example.loginandregistration

object RegistrationUtil {



    var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")

    fun validateUsername(username : String) : Boolean {
        return true
    }

    fun validatePassword(password : String, confirmPassword : String) : Boolean {
        if(password != confirmPassword) return false
        return true
    }

    fun validateName(name : String) : Boolean {
        return true
    }

    fun validateEmail(email : String) : Boolean {
        return true
    }
}