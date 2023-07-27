package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class recipebook1activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook1)

        val imageViewCategory1 = findViewById<ImageView>(R.id.__img___food12)
        val imageViewCategory2 = findViewById<ImageView>(R.id.__img___food11)
        val imageViewCategory3 = findViewById<ImageView>(R.id.__img___food10)
        val imageViewCategory4 = findViewById<ImageView>(R.id.__img___food9)
        val imageViewCategory5 = findViewById<ImageView>(R.id.__img___food8)
        val imageViewCategory6 = findViewById<ImageView>(R.id.__img___food7)
        val imageViewCategory7 = findViewById<ImageView>(R.id.__img___food6)
        val imageViewCategory8 = findViewById<ImageView>(R.id.__img___food5)
        val imageViewCategory9 = findViewById<ImageView>(R.id.__img___food4)
        val imageViewCategory10 = findViewById<ImageView>(R.id.__img___food3)
        val imageViewCategory11 = findViewById<ImageView>(R.id.__img___food2)
        val imageViewCategory12 = findViewById<ImageView>(R.id.__img___food1)

        imageViewCategory1.setOnClickListener {
            val intent = Intent(this, recipebook2activity::class.java)
            startActivity(intent)
        }
    }
}