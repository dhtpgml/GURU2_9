package com.example.guru2_9

import android.content.Intent
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

        //뒤로가기(메인페이지로 이동)
        val backicon7 = findViewById<ImageView>(R.id.backicon7)

        backicon7.setOnClickListener {
            val intent = Intent(this, mainpage_x_activity::class.java)
            startActivity(intent)
        }

        rouletteImageView = findViewById(R.id.__img___roulette2)
        menuImageView = findViewById(R.id.__img___roulette1)

        menuImageView.setOnClickListener {
            if (!isSpinning) {
                startSpinAnimation()
            }
        }

        // 이미지뷰를 찾아서 클릭 리스너 설정
        val iconImageView1 = findViewById<ImageView>(R.id.homeicon_black1)
        iconImageView1.setOnClickListener {
            // 클릭 이벤트가 발생했을 때 실행될 코드
            // 다른 액티비티로 전환하는 코드 작성
            val intent = Intent(this, mainpage_x_activity::class.java)
            startActivity(intent)
        }

        val iconImageView2: ImageView = findViewById<ImageView>(R.id.recipebookicon_black1)
        iconImageView2.setOnClickListener {
            val intent = Intent(this, recipebook1activity::class.java)
            startActivity(intent)
        }

        val iconImageView3: ImageView = findViewById<ImageView>(R.id.shoppinglisticon_black1)
        iconImageView3.setOnClickListener {
            val intent = Intent(this, shoppinglist_xactivity::class.java)
            startActivity(intent)
        }

        val iconImageView4: ImageView = findViewById<ImageView>(R.id.mypageicon_black1)
        iconImageView4.setOnClickListener {
            val intent = Intent(this, mypage_activity::class.java)
            startActivity(intent)
        }

        val iconImageView5: ImageView = findViewById<ImageView>(R.id.rouletteicon_black1)
        iconImageView5.setOnClickListener {
            val intent = Intent(this, foodrouletteactivity::class.java)
            startActivity(intent)
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