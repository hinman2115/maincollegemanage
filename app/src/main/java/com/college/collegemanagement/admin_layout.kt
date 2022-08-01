package com.college.collegemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.college.collegemanagement.Adapter.ListPersonAdapter
import com.college.collegemanagement.DBHelper.DBHelper
import com.college.collegemanagement.Model.Person

class admin_layout : AppCompatActivity() {

    internal lateinit var db:DBHelper
//    internal var lstPersons:List<Person> = ArrayList<Person>()
    var list=findViewById<ListView>(R.id.list_person)
    var add=findViewById<Button>(R.id.btn_add)
    var update=findViewById<Button>(R.id.btn_update)
    var delete=findViewById<Button>(R.id.btn_delete)
    var edt_id=findViewById<EditText>(R.id.edt_id)
    var edt_name=findViewById<EditText>(R.id.edt_name)
    var edt_email=findViewById<EditText>(R.id.edt_email)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_layout)

        db = DBHelper(this)

        refershData()

        add.setOnClickListener{
            val person= Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.addPerson(person)
            refershData()
        }
        update.setOnClickListener{
            val person= Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.updatePerson(person)
            refershData()
        }
        delete.setOnClickListener{
            val person= Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.deletePerson(person)
            refershData()
        }

        }


    private fun refershData() {
//         lstPersons =db.allPeron
//        val adapter =ListPersonAdapter(this@admin_layout,lstPersons,edt_id,edt_name,edt_email)
//        list.adapter=adapter
    }
}