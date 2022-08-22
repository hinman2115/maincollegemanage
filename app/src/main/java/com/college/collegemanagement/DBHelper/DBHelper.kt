package com.college.collegemanagement.DBHelper

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.college.collegemanagement.Model.Person

class DBHelper(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {



    companion object{
        private val DATABASE_VER=2
        private val DATABASE_NAME="EDMTDB.db"

        private val TABLE_NAME="Person"
        private val COL_ID="Id"
        private val COL_NAME="Name"
        private val COL_M_NAME="M_Name"
        private val COL_L_NAME="L_Name"
        private val COL_GENDER="Gender"
        private val COL_DOB="Dob"
        private val COL_MOBILE="Mobile"
        private val COL_EMAIL="Email"
    }
//    $COL_M_NAME TEXT,$COL_L_NAME TEXT , $COL_GENDER TEXT ,$COL_DOB TEXT,$COL_MOBILE TEXT,
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE_QUERY:String = ("CREATE TABLE $TABLE_NAME ($COL_ID  INTEGER PRIMARY KEY, $COL_NAME  TEXT , $COL_M_NAME TEXT, $COL_L_NAME TEXT, $COL_GENDER TEXT, $COL_DOB TEXT, $COL_MOBILE TEXT, $COL_EMAIL TEXT )")
        db!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val allPeron:List<Person>
    @SuppressLint("Range")
    get() {
        val lstPersons= ArrayList<Person>()
        val SelectQuery= "SELECT * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor:Cursor = db.rawQuery(SelectQuery,null)
        if (cursor.moveToFirst())
        {
            do{
                val person= Person()
                person.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                person.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                person.mname = cursor.getString(cursor.getColumnIndex(COL_M_NAME))
                person.lname = cursor.getString(cursor.getColumnIndex(COL_L_NAME))
                person.gender = cursor.getString(cursor.getColumnIndex(COL_GENDER))
                person.dob = cursor.getString(cursor.getColumnIndex(COL_DOB))
                person.mobile = cursor.getString(cursor.getColumnIndex(COL_MOBILE))
                person.email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))

                lstPersons.add(person)

            }while (cursor.moveToNext())

        }
        db.close()
        return lstPersons
    }

    fun addPerson(person: Person){

        val db=this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,person.id)
        values.put(COL_NAME,person.name)
        values.put(COL_M_NAME,person.mname)
        values.put(COL_L_NAME,person.lname)
        values.put(COL_GENDER,person.gender)
        values.put(COL_DOB,person.dob)
        values.put(COL_MOBILE,person.mobile)
        values.put(COL_EMAIL,person.email)

        db.insert(TABLE_NAME,null,values)
        db.close()
    }

    fun updatePerson(person: Person):Int{

        val db = this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,person.id)
        values.put(COL_NAME,person.name)
        values.put(COL_M_NAME,person.mname)
        values.put(COL_L_NAME,person.lname)
        values.put(COL_GENDER,person.gender)
        values.put(COL_DOB,person.dob)
        values.put(COL_MOBILE,person.mobile)
        values.put(COL_EMAIL,person.email)

        return db.update(TABLE_NAME,values,"$COL_ID=?", arrayOf(person.id.toString()))

    }
    fun deletePerson(person: Person){

        val db = this.writableDatabase

         db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(person.id.toString()))
        db.close()

    }
    fun userPresent(name:String,pass:String):Boolean{
        val db = this.writableDatabase
        val query="select * from Person where name == '$name' and  email == '$pass'"
        val cursor =db.rawQuery(query,null)
        if(cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    @SuppressLint("Range")
    fun getDetails(name: String):ArrayList<Person>{
        val db = this.writableDatabase
        val detailsall= ArrayList<Person>()
        val SelectQuery= "select * from Person where name == '$name' "

        val cursor:Cursor = db.rawQuery(SelectQuery,null)
        if (cursor.moveToFirst())
        {
//            do{
                val person= Person()
                person.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                person.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                person.mname = cursor.getString(cursor.getColumnIndex(COL_M_NAME))
                person.lname = cursor.getString(cursor.getColumnIndex(COL_L_NAME))
                person.gender = cursor.getString(cursor.getColumnIndex(COL_GENDER))
                person.dob = cursor.getString(cursor.getColumnIndex(COL_DOB))
                person.mobile = cursor.getString(cursor.getColumnIndex(COL_MOBILE))
                person.email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))

                detailsall.add(person)

//            }while (cursor.moveToNext())

        }
        db.close()
        return detailsall
    }


}