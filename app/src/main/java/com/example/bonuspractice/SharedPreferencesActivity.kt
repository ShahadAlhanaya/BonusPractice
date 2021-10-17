package com.example.bonuspractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.SharedPreferences
import android.widget.TextView


class SharedPreferencesActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Shared Preferences"

        prefs = getSharedPreferences("com.example.bonuspractice", Context.MODE_PRIVATE)

        val editText1 = findViewById<EditText>(R.id.edt_1)
        val editText2 = findViewById<EditText>(R.id.edt_2)

        val getSHPFsTextView = findViewById<TextView>(R.id.tv_getSHPFS)

        val shareIntentButton = findViewById<Button>(R.id.btn_sharingIntent)
        val saveSHPFsButton = findViewById<Button>(R.id.btn_saveSHPFS)
        val getSHPFsButton = findViewById<Button>(R.id.btn_getSHPFS)

        val text = prefs.getString("text", "");
        getSHPFsTextView.text = text

        shareIntentButton.setOnClickListener {
            val intent = Intent(this, EditTextTextActivity::class.java)
            val text = editText1.text.toString() +" "+ editText2.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }

        saveSHPFsButton.setOnClickListener {
            val text = editText1.text.toString() +" "+ editText2.text.toString()
            prefs.edit().putString("text", text).apply()
        }

        getSHPFsButton.setOnClickListener {
            val text = prefs.getString("text", "");
            getSHPFsTextView.text = text
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}