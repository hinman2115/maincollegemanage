package com.college.collegemanagement


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.college.collegemanagement.Adapter.ListPersonAdapter
import com.college.collegemanagement.DBHelper.DBHelper
import com.college.collegemanagement.Model.Person
import kotlinx.android.synthetic.main.activity_admin_layout.*


class admin_layout : AppCompatActivity() {


    internal lateinit var db: DBHelper
    internal var lstPersons: List<Person> = ArrayList<Person>()

    var list: ListView? = null

    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_layout)
        list = findViewById<ListView>(R.id.list_person)
        var add = findViewById<Button>(R.id.btn_add)
        var update = findViewById<Button>(R.id.btn_update)
        var delete = findViewById<Button>(R.id.btn_delete)
        var edt_id = findViewById<EditText>(R.id.edt_id)
        var edt_name = findViewById<EditText>(R.id.edt_name)
        var edt_m_name = findViewById<EditText>(R.id.edt_m_name)
        var edt_l_name = findViewById<EditText>(R.id.edt_l_name)
        var edt_gender = findViewById<EditText>(R.id.edt_gender)
        var edt_dob = findViewById<EditText>(R.id.edt_dob)
        var edt_mobile = findViewById<EditText>(R.id.edt_mobile)
        var edt_email = findViewById<EditText>(R.id.edt_email)
        var btnclick = findViewById<Button>(R.id.Clickbtn)


        btnclick.setOnClickListener {
            val isVisible = hidething.visibility
            if (isVisible == View.VISIBLE) {
                hidething.visibility = View.GONE
            } else {
                hidething.visibility = View.VISIBLE
            }
        }



        db = DBHelper(this)

        refershData()





        add.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_m_name.text.toString(),
                edt_l_name.text.toString(),
                edt_gender.text.toString(),
                edt_dob.text.toString(),
                edt_mobile.text.toString(),
                edt_email.text.toString()
            )

            db.addPerson(person)
            refershData()
            edt_id.setText("")
            edt_name.setText("")
            edt_m_name.setText("")
            edt_l_name.setText("")
            edt_gender.setText("")
            edt_dob.setText("")
            edt_mobile.setText("")
            edt_email.setText("")

        }
        update.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_m_name.text.toString(),
                edt_l_name.text.toString(),
                edt_gender.text.toString(),
                edt_dob.text.toString(),
                edt_mobile.text.toString(),
                edt_email.text.toString()
            )
            db.updatePerson(person)
            refershData()
            edt_id.setText("")
            edt_name.setText("")
            edt_m_name.setText("")
            edt_l_name.setText("")
            edt_gender.setText("")
            edt_dob.setText("")
            edt_mobile.setText("")
            edt_email.setText("")
        }
        delete.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_m_name.text.toString(),
                edt_l_name.text.toString(),
                edt_gender.text.toString(),
                edt_dob.text.toString(),
                edt_mobile.text.toString(),
                edt_email.text.toString()
            )
            db.deletePerson(person)
            refershData()
            edt_id.setText("")
            edt_name.setText("")
            edt_m_name.setText("")
            edt_l_name.setText("")
            edt_gender.setText("")
            edt_dob.setText("")
            edt_mobile.setText("")
            edt_email.setText("")
        }

    }

    private fun refershData() {
        lstPersons = db.allPeron
        val adapter = ListPersonAdapter(
            this@admin_layout,
            lstPersons,
            edt_id,
            edt_name,
            edt_m_name,
            edt_l_name,
            edt_gender,
            edt_dob,
            edt_mobile,
            edt_email
        )
        list?.adapter = adapter

    }
}