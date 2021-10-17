package com.example.bonuspractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ThreeButtonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_buttons)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Three Buttons"

        val toastEditText = findViewById<EditText>(R.id.edt_toast)
        val textviewEditText = findViewById<EditText>(R.id.edt_textview)
        val activityEditText = findViewById<EditText>(R.id.edt_activity)

        val toastButton = findViewById<Button>(R.id.btn_toast)
        val textviewButton = findViewById<Button>(R.id.btn_textview)
        val activityButton = findViewById<Button>(R.id.btn_activity)

        val textView = findViewById<TextView>(R.id.tv_textview)

        toastButton.setOnClickListener {
            Toast.makeText(this,toastEditText.text, Toast.LENGTH_SHORT).show()
        }

        textviewButton.setOnClickListener {
            textView.text = textviewEditText.text
        }

        activityButton.setOnClickListener {
            val intent = Intent(this,EditTextTextActivity::class.java)
            val text = activityEditText.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}