package com.dexter.lefttoright

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.transition.Scene
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val top_animation = AnimationUtils.loadAnimation(this,R.anim.top)
        ed_1.startAnimation(top_animation)
        btn_continue.startAnimation(top_animation)
        val transition: Transition = Slide(Gravity.BOTTOM)
        transition.apply {
            setDuration(600)
            addTarget(img_1)
        }
//        TransitionManager.beginDelayedTransition()

        btn_back.setOnClickListener {
            this.apply {
                img_1.animate()
                    .translationYBy(img_1.height.toFloat())
                    .alpha(0.0f)
                    .setDuration(500)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)

                        }
                    })
                img_1.visibility = View.VISIBLE
                ed_2.visibility = View.GONE
                btn_back.visibility = View.GONE
                btn_continue.visibility = View.VISIBLE
                ed_1.visibility = View.VISIBLE

                btn_submit.visibility = View.GONE
                ed_1.startAnimation(top_animation)
                btn_continue.startAnimation(top_animation)
            }
        }

        btn_continue.setOnClickListener {

            img_1.animate()
                .translationY(- img_1.height.toFloat())
                .alpha(1.0f)
                .setDuration(600)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        img_1.setVisibility(View.GONE)
                    }
                })
            this.btn_continue.visibility = View.GONE
            this.ed_1.visibility = View.GONE
            this.ed_2.visibility = View.VISIBLE
            this.btn_back.visibility = View.VISIBLE

            this.btn_submit.visibility = View.VISIBLE
            ed_2.startAnimation(top_animation)
            btn_submit.startAnimation(top_animation)
            btn_back.startAnimation(top_animation)

        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.lest_to_rigth,R.anim.rigth_to_left)
    }
}