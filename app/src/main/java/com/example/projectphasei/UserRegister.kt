package com.example.projectphasei

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class UserRegister : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var name:EditText
        lateinit var emailId: EditText
        lateinit var number:EditText
        lateinit var register: Button
        lateinit var loginPage: TextView
        lateinit var nameLayout: TextInputLayout
        lateinit var emailLayout: TextInputLayout
        lateinit var numberLayout: TextInputLayout

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        //Initialization all UI variable
        name = findViewById(R.id.editTextName)
        emailId = findViewById(R.id.editTextEmail)
        number = findViewById(R.id.editTextNumber)
        register = findViewById(R.id.signup_btn)
        loginPage = findViewById(R.id.move_to_Login)

        nameLayout = findViewById(R.id.textInputName)
        emailLayout = findViewById(R.id.textInputEmail)
        numberLayout = findViewById(R.id.textInputNumber)


        //clicKlistiner
        register.setOnClickListener(View.OnClickListener { v ->
//            if (!GlobalFunction.isNetworkConnected(this@UserResister)) {
//                Toast.makeText(applicationContext, "No Internet Connection", Toast.LENGTH_SHORT)
//                    .show()
//                return@OnClickListener
//            }
            val userEmail = emailId.text.toString()
            val userName = name.text.toString()
            val userNumber = number.text.toString()
//            var s = ""
//            if (chip1.isChecked()) s += chip1.getText().toString() + "/ "
//            if (chip2.isChecked()) s += chip2.getText().toString() + "/ "
//            if (chip3.isChecked()) s += chip3.getText().toString() + "/ "
//            if (chip4.isChecked()) s += chip4.getText().toString() + "/ "
//            if (chip5.isChecked()) s += chip5.getText().toString() + "/ "
//            if (chip6.isChecked()) s += chip6.getText().toString() + "/ "
//            if (chip7.isChecked()) s += chip7.getText().toString() + "/ "
            if (TextUtils.isEmpty(userEmail)) {
                emailLayout.error = "Enter an email"
                return@OnClickListener
            }
            if (TextUtils.isEmpty(userName)) {
                nameLayout.error = "Enter an Name"
                return@OnClickListener
            }
            if (TextUtils.isEmpty(userNumber)) {
                numberLayout.error = "Enter an Number"
                return@OnClickListener
            }
//            if (!GlobalFunction.validateEmailId(userEmail)) {
//                emailLayout.error = "Enter a correct email"
//                return@OnClickListener
//            }
//            if (!GlobalFunction.validateNumber(userNumber)) {
//                numberLayout.error = "Enter a correct Number"
//                return@OnClickListener
//            }
//            if (s.length == 0) {
//                Snackbar.make(v, "Select AtLeast One Course", Snackbar.LENGTH_SHORT).show()
//                return@OnClickListener
//            }
            resister(userName, userEmail, userNumber)
        })

        loginPage.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, PhoneAuth::class.java)
            startActivity(intent)
            finish()
        })

        name.setOnTouchListener { v, event ->
            nameLayout.error = null
            false
        }
        emailId.setOnTouchListener { v, event ->
            emailLayout.error = null
            false
        }
        number.setOnTouchListener { v, event ->
            numberLayout.error = null
            false
        }

    }

    private fun resister(userName: String, userEmail: String, userNumber: String): Boolean {
        val intent = Intent(this, OTPActivity::class.java)
        intent.putExtra("name", userName)
        intent.putExtra("email", userEmail)
        intent.putExtra("phoneNo", userNumber)
        startActivity(intent)
        finish()
        //        otpVeriication(userNumber);
        return true
    }

}