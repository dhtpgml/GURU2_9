package com.example.guru2_9
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class recipeactivity2 : AppCompatActivity() {

    fun onBackIconClick(view: View) {
        onBackPressed() // 뒤로가기

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook2_2x)

        val cheese1ImageView = findViewById<ImageView>(R.id.cheese1)
        cheese1ImageView.setOnClickListener {
            // 레시피 링크로 이동하는 코드
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167193734"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val cheese2ImageView = findViewById<ImageView>(R.id.cheese2)
        cheese2ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167193567"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val cheese3ImageView= findViewById<ImageView>(R.id.cheese3)
        cheese3ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167193418"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }
    }
}




