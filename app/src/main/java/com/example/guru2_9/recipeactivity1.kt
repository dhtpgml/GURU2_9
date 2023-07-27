package com.example.guru2_9
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class recipeactivity1 : AppCompatActivity() {

    fun onBackIconClick(view: View) {
        onBackPressed() // 뒤로가기

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook2_1x)

        val milk1ImageView = findViewById<ImageView>(R.id.milk1)
        milk1ImageView.setOnClickListener {
            // 레시피 링크로 이동하는 코드
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167189856"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val milk2ImageView = findViewById<ImageView>(R.id.milk2)
        milk2ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167189498"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val milk3ImageView = findViewById<ImageView>(R.id.milk3)
        milk3ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167189263"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }





    }
}




