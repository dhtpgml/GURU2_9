package com.example.guru2_9
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class recipeactivity3 : AppCompatActivity() {


    fun onBackIconClick(view: View) {
        onBackPressed()

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook2_3x)

        val chickenImageView = findViewById<ImageView>(R.id.chicken1)
        chickenImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167194276"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val chicken2ImageView = findViewById<ImageView>(R.id.chicken2)
        chicken2ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167194440"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val chicken3ImageView= findViewById<ImageView>(R.id.chicken3)
        chicken3ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167194566"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }


    }
}




