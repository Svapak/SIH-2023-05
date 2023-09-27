package com.example.waterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton

class SignUp1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)
        val btnauth=findViewById<RadioButton>(R.id.rbAuthority)
        val btnresident=findViewById<RadioButton>(R.id.rbResident)
        btnauth.setOnClickListener {
            val intent1=Intent(this,SignUpautho::class.java)
            startActivity(intent1)
            btnresident.isChecked=false
        }

    }

    override fun onBackPressed() {

        super.onBackPressed()
        finishAffinity()
        val intent1=Intent(this,SignIn::class.java)
        startActivity(intent1)
    }
}