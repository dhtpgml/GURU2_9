package com.example.guru2_9

import android.content.Intent
import android.os.Bundle

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class mainpage_x_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage_x)

        // 이미지뷰를 찾아서 클릭 리스너 설정
        val iconImageView1 = findViewById<ImageView>(R.id.homeicon_black)
        iconImageView1.setOnClickListener {
            // 클릭 이벤트가 발생했을 때 실행될 코드
            // 다른 액티비티로 전환하는 코드 작성
            val intent = Intent(this, mainpage_x_activity::class.java)
            startActivity(intent)
        }

        val iconImageView2: ImageView = findViewById<ImageView>(R.id.recipebookicon_black)
        iconImageView2.setOnClickListener {
            val intent = Intent(this, recipebook1activity::class.java)
            startActivity(intent)
        }

        val iconImageView3: ImageView = findViewById<ImageView>(R.id.shoppinglisticon_black)
        iconImageView3.setOnClickListener {
            val intent = Intent(this, shoppinglist_xactivity::class.java)
            startActivity(intent)
        }

        val iconImageView4: ImageView = findViewById<ImageView>(R.id.mypageicon_black)
        iconImageView4.setOnClickListener {
            val intent = Intent(this, mypage_activity::class.java)
            startActivity(intent)
        }

        val iconImageView5: ImageView = findViewById<ImageView>(R.id.rouletteicon_black)
        iconImageView5.setOnClickListener {
            val intent = Intent(this, foodrouletteactivity::class.java)
            startActivity(intent)
        }




    }
}










