package com.example.projectphasei.Utilities

import android.content.Context
import android.net.ConnectivityManager
import java.util.regex.Pattern

class GlobalFunction {

    private val REGEX = "^(.+)@(.+)$"

    fun validateEmailId(email: String?): Boolean {
        val pattern = Pattern.compile(REGEX)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun validateNumber(userNumber: String): Boolean {
        val p = Pattern.compile("(0/91)?[6-9][0-9]{9}")

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        val m = p.matcher(userNumber)
        return m.find() && m.group() == userNumber
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

}