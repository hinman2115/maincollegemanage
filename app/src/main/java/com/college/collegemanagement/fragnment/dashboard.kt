package com.college.collegemanagement.fragnment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.college.collegemanagement.*
import com.college.collegemanagement.DBHelper.DBHelper
import com.college.collegemanagement.Model.Person
import kotlinx.android.synthetic.main.fragment_dashboard.view.*


class dashboard : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_dashboard, container, false)

        val timeTable = view.findViewById<CardView>(R.id.card2)
        val general = view.findViewById<CardView>(R.id.card1)
        val holiday = view.findViewById<CardView>(R.id.card3)
        val lerning = view.findViewById<CardView>(R.id.card4)
        val result = view.findViewById<CardView>(R.id.card5)
        val feePayment = view.findViewById<CardView>(R.id.card6)
        var text= view.findViewById<TextView>(R.id.s_name)
        var id:String? =""
        val bundle = arguments
        id = bundle!!.getString("id2")

        text.setText(id.toString())

//        Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show()


        timeTable.setOnClickListener {
           val intent = Intent(context,time_table::class.java)
            startActivity(intent)
//            Toast.makeText((activity as Main_Layout?),"done",Toast.LENGTH_SHORT).show()
        }
        general.setOnClickListener {
            val intent = Intent(context,general_detail::class.java)
            intent.putExtra("NameOF",id.toString())

            startActivity(intent)
//            Toast.makeText((activity as Main_Layout?),"done",Toast.LENGTH_SHORT).show()
        }
        holiday.setOnClickListener {
            val intent = Intent(context,com.college.collegemanagement.holiday::class.java)
            startActivity(intent)
//            Toast.makeText((activity as Main_Layout?),"done",Toast.LENGTH_SHORT).show()
        }
        result.setOnClickListener {
            val intent = Intent(context,com.college.collegemanagement.result::class.java)
            startActivity(intent)
//            Toast.makeText((activity as Main_Layout?),"done",Toast.LENGTH_SHORT).show()
        }
        feePayment.setOnClickListener {
            val intent = Intent(context,fee_payment::class.java)
            startActivity(intent)
//            Toast.makeText((activity as Main_Layout?),"done",Toast.LENGTH_SHORT).show()
        }
        lerning.setOnClickListener {
            val intent = Intent(context,lerning_material::class.java)
            startActivity(intent)
//            Toast.makeText((activity as Main_Layout?),"done",Toast.LENGTH_SHORT).show()
        }
        // Return the fragment view/layout
        return view
    }


}