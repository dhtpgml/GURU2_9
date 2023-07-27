package com.example.guru2_9
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class recipeactivity8 : AppCompatActivity() {

    fun onBackIconClick(view: View) {
        onBackPressed()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook2_8x)

        val sweetImageView = findViewById<ImageView>(R.id.sweet1)
       sweetImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167205569"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val sweet2ImageView = findViewById<ImageView>(R.id.sweet2)
        sweet2ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167205746"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val sweet3ImageView= findViewById<ImageView>(R.id.sweet3)
        sweet3ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167205918"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

    }
}




