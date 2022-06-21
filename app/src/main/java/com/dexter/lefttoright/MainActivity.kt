package com.dexter.lefttoright

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       btn_1.setOnClickListener {
           startActivity(Intent(this,MainActivity2::class.java))
           overridePendingTransition(R.anim.enter,R.anim.exit)
       }
    }
}
