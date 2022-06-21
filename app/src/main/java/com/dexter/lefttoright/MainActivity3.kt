package com.dexter.lefttoright

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val top_animation = AnimationUtils.loadAnimation(this,R.anim.top)
        ed_1.startAnimation(top_animation)
        btn_continue.startAnimation(top_animation)

        btn_continue.setOnClickListener {
            image_1.animate()
                .translationX(image_1.height.toFloat())
                .alpha(1.0f)
                .setDuration(600)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        image_1.setVisibility(View.GONE)
                    }
                })
            startActivity(Intent(this,MainActivity4::class.java))
            overridePendingTransition(R.anim.enter_1,R.anim.exit)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.lest_to_rigth,R.anim.rigth_to_left)
    }

}