package com.college.collegemanagement

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class signin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_signin, container, false)

        val login=view.findViewById<Button>(R.id.admin_login)
        val uname=view.findViewById<EditText>(R.id.name)
        val pass=view.findViewById<EditText>(R.id.c_password)

        login.setOnClickListener{
            if(uname.text.toString().equals("Admin") && pass.text.toString().equals("12345")){
                val intent = Intent(context, admin_layout::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context,"Please enter valid username and password",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}