package com.example.guru2_9

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class mainpage_x_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage_x)

        val thumb1ImageView = findViewById<ImageView>(R.id.thumbnailtop1_)
        thumb1ImageView.setOnClickListener {
            val recipeLinkUrl = "https://www.youtube.com/watch?v=iRzCgfhj5sA"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val thumb2ImageView = findViewById<ImageView>(R.id.thumbnailtop2_)
        thumb2ImageView.setOnClickListener {
            val recipeLinkUrl = "https://www.youtube.com/watch?v=-BYPCJNm5uo"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val thumb3ImageView = findViewById<ImageView>(R.id.thumbnailtop3_)
        thumb3ImageView.setOnClickListener {
            val recipeLinkUrl = "https://www.youtube.com/watch?v=vaj2TSPe5_4"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val thumb4ImageView = findViewById<ImageView>(R.id.thumbnailtop4_)
        thumb4ImageView.setOnClickListener {
            val recipeLinkUrl = "https://www.youtube.com/watch?v=-p7YMtvYvSM"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val thumb5ImageView = findViewById<ImageView>(R.id.thumbnailtop5_2)
        thumb5ImageView.setOnClickListener {
            val recipeLinkUrl = "https://www.youtube.com/watch?v=QNipXG5LPik"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

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
