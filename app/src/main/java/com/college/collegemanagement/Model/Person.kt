package com.college.collegemanagement.Model

class Person {
    var id: Int=0
    var name:String?=null
    var mname:String?=null
    var lname:String?=null
    var gender:String?=null
    var dob:String?=null
    var mobile:String?=null
    var email:String?=null


    constructor(){}
//    ,m_name:String,l_name:String,gender:String,dob:String,mobile:String
    constructor(id:Int,name:String,mname:String,lname:String,gender:String,dob:String,mobile:String,email:String){
        this.id=id
        this.name=name
        this.mname=mname
        this.lname=lname
        this.gender=gender
        this.dob=dob
        this.mobile=mobile
        this.email=email


    }
//    fun setId(var id:Int){
//
//    }
}