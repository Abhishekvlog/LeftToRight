package com.dexter.lefttoright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn_2.setOnClickListener {
            startActivity(Intent(this,MainActivity3::class.java))
            overridePendingTransition(R.anim.enter,R.anim.exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.lest_to_rigth,R.anim.rigth_to_left)
    }
}