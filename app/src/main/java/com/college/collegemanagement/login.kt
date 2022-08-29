package com.college.collegemanagement

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.college.collegemanagement.DBHelper.DBHelper
import com.college.collegemanagement.Model.Person
import hinl.kotlin.database.helper.Database
import hinl.kotlin.database.helper.SQLiteDatabaseHelper
import java.io.Serializable

class login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_login, container, false)

        val db: DBHelper? = context?.let { DBHelper(it) }

        val login=view.findViewById<Button>(R.id.student_login)
        val user=view.findViewById<EditText>(R.id.email)
        val pass=view.findViewById<EditText>(R.id.password)

        login.setOnClickListener{
            var check_user= user.text.toString()
            var check_pass= pass.text.toString()
            
            if (db != null) {
                if(db.userPresent(user.text.toString(),pass.text.toString())){
                    val intent = Intent(context, Main_Layout::class.java)
                    intent.putExtra("id",user.text.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(context,"Invalid Details",Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}