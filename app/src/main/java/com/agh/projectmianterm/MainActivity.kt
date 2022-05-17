package com.agh.projectmianterm

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent: Intent = Intent(this@MainActivity,information::class.java)
        val btnlog = findViewById<Button>(R.id.btnlog)
        val chkgh = findViewById<CheckBox>(R.id.chkgh)
        btnlog.isEnabled = false
        val txtid : String
        txtid = "2"

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val sharedIdValue = sharedPreferences.getString("id_key", "0")

        chkgh.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                btnlog.isEnabled = true
            }else{
                btnlog.isEnabled = false
            }
        }

        btnlog.setOnClickListener {

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("id_key", txtid)
            editor.apply()
            editor.commit()
            startActivity(intent)
            this.finish()
        }

        if(sharedIdValue.equals("2")) {
            startActivity(intent)
            this.finish()
        }

    }

}
