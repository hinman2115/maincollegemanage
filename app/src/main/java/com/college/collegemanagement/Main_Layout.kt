package com.college.collegemanagement

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.college.collegemanagement.DBHelper.DBHelper
import com.college.collegemanagement.Model.Person
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_admin_layout.*
import kotlinx.android.synthetic.main.activity_general_detail.*
import kotlinx.android.synthetic.main.fragment_signin.*

class Main_Layout : AppCompatActivity() {
    private val information = com.college.collegemanagement.fragnment.info()
    private val dash = com.college.collegemanagement.fragnment.dashboard()
    private val mess = com.college.collegemanagement.fragnment.message()

        var id:String? =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        replaceFragment(com.college.collegemanagement.fragnment.info())

        id =intent.getStringExtra("id")
        Toast.makeText(this,id.toString(),Toast.LENGTH_SHORT).show()

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
            val mBundle = Bundle()
            mBundle.putString("id2",id.toString())
            fragment.arguments = mBundle
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}