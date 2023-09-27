package com.example.waterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val intent= Intent(this,SignUpautho::class.java)
        val signup=findViewById<TextView>(R.id.txtNewHereSign)
        signup.setOnClickListener {
            startActivity(intent)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}