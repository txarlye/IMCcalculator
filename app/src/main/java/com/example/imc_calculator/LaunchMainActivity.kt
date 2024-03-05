package com.example.imc_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class LaunchMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_main)

        val btnGo = findViewById<AppCompatButton>(R.id.btn_Go)



        btnGo.setOnClickListener {
            val et_name = findViewById<AppCompatEditText>(R.id.editTextUser)
            val name = et_name.text.toString()
            navigateToImcApp(name)
        }
    }

    private fun navigateToImcApp(name: String) {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        if (name.isNotEmpty()) {
            intent.putExtra("Name", name)
        }
        startActivity(intent)
    }
}
