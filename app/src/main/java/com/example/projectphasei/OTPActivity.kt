package com.example.projectphasei

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaos.view.PinView

class OTPActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var verify: Button
        lateinit var pinFromUser: PinView
        lateinit var codeBySystem: String
        lateinit var phoneText: TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        verify = findViewById(R.id.verify_btn)
        pinFromUser = findViewById(R.id.pin_view)
        phoneText = findViewById(R.id.phoneText)

        val phone = intent.getStringExtra("phoneNo")

        phoneText.text = "Enter one time password sent on $phone"

//        sendVerificationCodeToUser(phone)

        verify.setOnClickListener {
//            val code = pinFromUser.text.toString()
//            if (!code.isEmpty()) {
//                verifyCode(code)
//            }

            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }

    }
}