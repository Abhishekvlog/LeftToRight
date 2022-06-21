package com.dexter.lefttoright

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val top_animation = AnimationUtils.loadAnimation(this,R.anim.top)
        img_1.animate()
            .translationX(img_1.height.toFloat())
            .alpha(1.0f)
            .setDuration(600)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    img_1.setVisibility(View.GONE)
                }
            })
        this.btn_continue_1.visibility = View.GONE
        this.ed_11.visibility = View.GONE
        this.ed_2.visibility = View.VISIBLE
        this.btn_back.visibility = View.VISIBLE

        this.btn_submit.visibility = View.VISIBLE
        ed_2.startAnimation(top_animation)
        btn_submit.startAnimation(top_animation)
        btn_back.startAnimation(top_animation)

        btn_back.setOnClickListener {
            this.apply {
                img_1.animate()
                    .translationXBy(-img_1.height.toFloat())
                    .alpha(1.0f)
                    .setDuration(600)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationStart(animation)
                        }
                    })
                img_1.visibility = View.VISIBLE
                ed_2.visibility = View.GONE
                btn_back.visibility = View.GONE
                btn_continue_1.visibility = View.VISIBLE
                ed_11.visibility = View.VISIBLE

                btn_submit.visibility = View.GONE
                ed_11.startAnimation(top_animation)
                btn_continue_1.startAnimation(top_animation)

                btn_back.setOnClickListener {
                    startActivity(Intent(this,MainActivity3::class.java))
                    overridePendingTransition(R.anim.exit_1,R.anim.enter_1)
                }
            }
        }

    }

}
