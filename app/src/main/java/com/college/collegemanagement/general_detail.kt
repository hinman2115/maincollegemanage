package com.college.collegemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.college.collegemanagement.DBHelper.DBHelper
import com.college.collegemanagement.Model.Person

class general_detail : AppCompatActivity() {
    var DetailList:ArrayList<Person>? = ArrayList<Person>()
    var newal = ArrayList<Person>()
    var fir_n:String = ""
    var mid_n:String = ""
    var last_n:String = ""
    var gen:String = ""
    var dofb:String = ""
    var mob:String = ""
    var ema:String = ""
    var iid:String = ""
    val db: DBHelper? = this?.let { DBHelper(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_detail)

        var fname=findViewById<TextView>(R.id.m_name)
        var mname=findViewById<TextView>(R.id.m_middle)
        var lname=findViewById<TextView>(R.id.m_last)
        var gender=findViewById<TextView>(R.id.m_gender)
        var dob=findViewById<TextView>(R.id.m_dob)
        var mobile=findViewById<TextView>(R.id.m_mobile)
        var email=findViewById<TextView>(R.id.m_email)
        var idof=findViewById<TextView>(R.id.m_id)





        var id:String? =intent.getStringExtra("NameOF")

         DetailList = intent.getSerializableExtra("list") as? ArrayList<Person>

        if (db != null) {

            newal = db.getDetails(id.toString())
        }
            fir_n = newal?.get(0)?.name.toString()
            mid_n = newal?.get(0)?.mname.toString()
            last_n = newal?.get(0)?.lname.toString()
            gen = newal?.get(0)?.gender.toString()
            dofb = newal?.get(0)?.dob.toString()
            mob = newal?.get(0)?.mobile.toString()
            ema = newal?.get(0)?.email.toString()
            iid = newal?.get(0)?.id.toString()



            fname.setText(fir_n)
            mname.setText(mid_n)
            lname.setText(last_n)
            gender.setText(gen)
            dob.setText(dofb)
            mobile.setText(mob)
            email.setText(ema)
            idof.setText(iid)


        }

    }
