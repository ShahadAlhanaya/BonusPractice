package com.example.bonuspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class EditTextTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_text)
        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "EditText Text"

        val textView = findViewById<TextView>(R.id.tv_editTextText)

        val savedText = intent.extras!!.getString("text").toString()
        textView.text = savedText
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}