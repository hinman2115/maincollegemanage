package com.college.collegemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class FirstAnimation : AppCompatActivity() {
    val SPLASH_SCREEN = 4000

    private  lateinit var topAnimatio: Animation
    private  lateinit var bottomAnimatio: Animation

    private lateinit var st_image: ImageView
    private lateinit var tittle: TextView
    private lateinit var des: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags((WindowManager.LayoutParams.FLAG_FULLSCREEN), WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_first_animation)

        topAnimatio = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomAnimatio = AnimationUtils.loadAnimation(this,R.anim.buttom_animation)

        st_image = findViewById(R.id.st_image)
        tittle = findViewById(R.id.tittle)
        des = findViewById(R.id.des)

        st_image.animation = topAnimatio
        tittle.animation = bottomAnimatio
        des.animation = bottomAnimatio

        Handler().postDelayed({
            val intent = Intent(this,selection_layout::class.java)
            startActivity(intent)
            finish()
        },SPLASH_SCREEN.toLong()
        )

    }
}