package com.example.guru2_9
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class recipeactivity10 : AppCompatActivity() {

    fun onBackIconClick(view: View) {
        onBackPressed()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook2_10x)

        val eggImageView = findViewById<ImageView>(R.id.egg1)
        eggImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167206672"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val egg2ImageView = findViewById<ImageView>(R.id.egg2)
        egg2ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167206799"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }

        val egg3ImageView= findViewById<ImageView>(R.id.egg3)
        egg3ImageView.setOnClickListener {
            val recipeLinkUrl = "https://blog.naver.com/hz__00/223167206910"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeLinkUrl))
            startActivity(linkIntent)
        }





    }
}
