package com.college.collegemanagement

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main_Layout : AppCompatActivity() {
    private val information = com.college.collegemanagement.fragnment.info()
    private val dash = com.college.collegemanagement.fragnment.dashboard()
    private val mess = com.college.collegemanagement.fragnment.message()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        replaceFragment(com.college.collegemanagement.fragnment.info())

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.menu)
        bottom_navigation.setOnNavigationItemSelectedListener() {
            when (it.itemId){
                R.id.info -> replaceFragment(information)
                R.id.dashboard -> replaceFragment(dash)
                R.id.mes -> replaceFragment(mess)

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}