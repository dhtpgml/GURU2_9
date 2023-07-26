package com.example.guru2_9

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class foodrouletteactivity : AppCompatActivity() {

    private lateinit var rouletteImageView: ImageView
    private lateinit var menuImageView: ImageView
    private var isSpinning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foodroulette)

        rouletteImageView = findViewById(R.id.__img___roulette2)
        menuImageView = findViewById(R.id.__img___roulette1)

        menuImageView.setOnClickListener {
            if (!isSpinning) {
                startSpinAnimation()
            }
        }
    }

    private fun startSpinAnimation() {
        val randomAngle = Random.nextDouble(0.0, 360.0)
        val animation = RotateAnimation(0F, randomAngle.toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5F,
            Animation.RELATIVE_TO_SELF, 0.5F)

        animation.duration = 5000
        animation.fillAfter = true

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isSpinning = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                isSpinning = false
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        rouletteImageView.startAnimation(animation)
    }
}