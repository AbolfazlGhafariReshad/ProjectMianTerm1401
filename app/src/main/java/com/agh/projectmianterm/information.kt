package com.agh.projectmianterm

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val btnalertinput = findViewById<Button>(R.id.btnalertinput)

        btnalertinput.setOnClickListener {

            val builder = AlertDialog.Builder(this).create()
            val view =layoutInflater.inflate(R.layout.activity_inputalert, null)
            builder.setView(view)
            builder.show()

        }


    }
}