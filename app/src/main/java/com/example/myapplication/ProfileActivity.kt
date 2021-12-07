package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var buttonLogout : Button
    private lateinit var buttonPasswordChange : Button
    private lateinit var textView : TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()

        registrationListeners()

        textView.text = FirebaseAuth.getInstance().currentUser?.uid
    }

    private fun init(){
        buttonLogout = findViewById(R.id.buttonLogout)
        buttonPasswordChange = findViewById(R.id.buttonPasswordChange)
        textView = findViewById(R.id.textView)
    }

    private fun registrationListeners(){
        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }

}