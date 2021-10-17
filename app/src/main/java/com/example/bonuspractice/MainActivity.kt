package com.example.bonuspractice

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleButtonListenerButton = findViewById<Button>(R.id.btn_simpleButtonListener)
        val singleButtonButton = findViewById<Button>(R.id.btn_singleButton)
        val threeButtonsButton = findViewById<Button>(R.id.btn_3Buttons)

        simpleButtonListenerButton.setOnClickListener {
            startActivity(Intent(this,SimpleButtonListenerActivity::class.java))
        }
        singleButtonButton.setOnClickListener {
            startActivity(Intent(this,SingleButtonActivity::class.java))
        }
        threeButtonsButton.setOnClickListener {
            startActivity(Intent(this,ThreeButtonsActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_alertDialog -> {
                showDialog()
                return true
            }
            R.id.menu_sharedPreferences -> {
                startActivity(Intent(this,SharedPreferencesActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
        val dialogEditText = dialogView.findViewById<EditText>(R.id.edt_dialog)
        val dialogTextView = dialogView.findViewById<TextView>(R.id.tv_dialog)
        val tvButton = dialogView.findViewById<Button>(R.id.btn_dialogTv)
        val goButton = dialogView.findViewById<Button>(R.id.btn_dialogGo)

        val alert = builder.create()
        alert.setView(dialogView)

        tvButton.setOnClickListener {
            dialogTextView.text = dialogEditText.text
        }
        goButton.setOnClickListener {
            val intent = Intent(this,EditTextTextActivity::class.java)
            val text = dialogEditText.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
            alert.dismiss()
        }
        alert.show()
    }
}