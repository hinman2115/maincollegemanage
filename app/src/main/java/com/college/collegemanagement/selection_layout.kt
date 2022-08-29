package com.college.collegemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class selection_layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_layout)

        val admin = findViewById<Button>(R.id.admin_button);
        val student = findViewById<Button>(R.id.Student_button);
        val context = this

        admin.setOnClickListener{
            val intent =Intent(context,MainActivity::class.java)
            intent.putExtra("Ad",11)
            startActivity(intent)
        }

        student.setOnClickListener{
            val intent =Intent(context,MainActivity::class.java)
            intent.putExtra("Ad",12)
            startActivity(intent)

        }
    }
}