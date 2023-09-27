package com.example.waterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton

class SignUpautho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_upautho)
        val btnauth=findViewById<RadioButton>(R.id.rbAuthority)
        val btnresident=findViewById<RadioButton>(R.id.rbResident)
        btnresident.setOnClickListener {
            val intent= Intent(this,SignUp1::class.java)
            startActivity(intent)
            btnauth.isChecked=false
        }

    }
    override fun onBackPressed() {

        super.onBackPressed()
        finishAffinity()
        val intent1=Intent(this,SignIn::class.java)
        startActivity(intent1)
    }
}