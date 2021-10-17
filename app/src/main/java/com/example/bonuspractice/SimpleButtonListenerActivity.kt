package com.example.bonuspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SimpleButtonListenerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_button_listener)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "setOnClickListener vs onClick"

        val codingButton = findViewById<Button>(R.id.btn_coding)
        codingButton.setOnClickListener {
            Toast.makeText(this,"Coding setOnClickListener", Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(view: View?) {
        Toast.makeText(applicationContext,"Xml onClick", Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}