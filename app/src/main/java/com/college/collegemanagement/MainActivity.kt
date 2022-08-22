package com.college.collegemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val login = findViewById<Button>(R.id.main);
        val viewPager =findViewById<ViewPager>(R.id.viewPager);
//        val log=findViewById<Button>(R.id.main)
        val admin_name=findViewById<EditText>(R.id.name)
        val admin_password=findViewById<EditText>(R.id.c_password)
//        val text=findViewById<TextView>(R.id.sign_text)


        val a =intent.getIntExtra("Ad",0)


       

//        if(a == 11){
////            if(admin_name.text.equals("Admin") && admin_password.text.equals("12345")) {
//                log.setOnClickListener() {
//
//                    intent = Intent(this, admin_layout::class.java)
//                    startActivity(intent)
//                }
////            }else{
////                Toast.makeText(this, "Please Enter Valid Username and Password", Toast.LENGTH_SHORT).show()
////            }
//        }else{
//            log.setOnClickListener(){
//                intent= Intent(this,Main_Layout::class.java)
//                startActivity(intent)
//            }
//        }




        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(login(), title = " One ")
        adapter.addFragment(signin(), title = " Two ")
        viewPager.adapter = adapter

        if( a == 11){
            viewPager.setCurrentItem(1,true)
        }else{
            viewPager.setCurrentItem(0 ,true )
        }


//        text.setOnClickListener(){
//            viewPager.setCurrentItem(1,true)
//            text.setText("Already have Account? Login")
//        }




//        login.setOnClickListener(){
//            Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
//        }
    }



    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){
        private  val fragmentList: MutableList<Fragment> = ArrayList()
        private  val titleList: MutableList<String> = ArrayList()

        override fun getCount(): Int{
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }


}