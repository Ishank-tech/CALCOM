package com.example.projectphasei

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class PhoneAuth : AppCompatActivity() {
    lateinit var login: Button
    lateinit var register: TextView
    lateinit var numberLayout:TextInputLayout
    lateinit var number: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_auth)
        login = findViewById(R.id.login);
        register = findViewById(R.id.move_to_signUp)
        numberLayout = findViewById(R.id.phn_no_for_otp)
        number = findViewById(R.id.number)

        login.setOnClickListener {
            val usernumber: String = number.getText().toString()
            if (TextUtils.isEmpty(usernumber)) {
                numberLayout.error = "Enter an Valid Number"
                return@setOnClickListener
            }

//            if (!GlobalFunction.validateNumber(usernumber)) {
//                numberLayout.error = "Enter an Valid Number"
//                return@setOnClickListener
//            }
//            if (!GlobalFunction.isNetworkConnected(this@PhoneAuth)) {
//                Toast.makeText(applicationContext, "No Internet Connection", Toast.LENGTH_SHORT)
//                    .show()
//                return@setOnClickListener
//            }
            isUserAvaliable(usernumber)
        }

        register.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, UserRegister::class.java)
            startActivity(intent)
            finish()
        })

    }

    fun isUserAvaliable(number: String?) {
        val intent = Intent(this, OTPActivity::class.java)
        intent.putExtra("phoneNo", number)
        startActivity(intent)
        finish()
//        showProgressDialog()
//        val database: FirebaseDatabase
//        database = FirebaseDatabase.getInstance()
//        var reference: DatabaseReference = database.getReference()
//        reference = FirebaseDatabase.getInstance().getReference("UserData2021").child(number)
//        reference.addListenerForSingleValueEvent(object : ValueEventListener() {
//            fun onDataChange(dataSnapshot: DataSnapshot) {
//                var data: UserBeen? = null
//                try {
//                    for (ayush in dataSnapshot.getChildren()) {
//                        data = ayush.getValue(UserBeen::class.java)
//                    }
//                } catch (e: Exception) {
//                    val a = e.toString()
//                    val a1 = e.toString()
//                }
//                hideProgressDialog()
//
//                //otpVeriication(number);
//                if (data == null) {
//                    Toast.makeText(this@PhoneAuth, "User is Not Registered ", Toast.LENGTH_SHORT)
//                        .show()
//                    uploadData()
//                } else {
//                    val intent = Intent(this@PhoneAuth, OTPActivity::class.java)
//                    intent.putExtra("phoneNo", number)
//                    startActivity(intent)
//                    finish()
//                    //                    otpVeriication(number);
//                }
//            }
//
//            fun onCancelled(databaseError: DatabaseError?) {
//                uploadData()
//            }
//        })
    }

}

