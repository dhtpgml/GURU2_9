
package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class recipebook1activity : AppCompatActivity() {

    fun onBackIconClick(view: View) {
        onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipebook1)



        // 이미지뷰를 찾아서 클릭 리스너 설정
        val categoryImageView1 = findViewById<ImageView>(R.id.__img___food1)
        categoryImageView1.setOnClickListener {
            // 클릭 이벤트
            // 다른 액티비티로 전환
            val intent = Intent(this, recipeactivity1::class.java)
            intent.putExtra("category", "Category 1")
            startActivity(intent)
        }

        val categoryImageView2 = findViewById<ImageView>(R.id.__img___food2)
        categoryImageView2.setOnClickListener {
            val intent = Intent(this, recipeactivity2::class.java)
            intent.putExtra("category", "Category 2")
            startActivity(intent)
        }

        val categoryImageView3 = findViewById<ImageView>(R.id.__img___food3)
        categoryImageView3.setOnClickListener {
            val intent = Intent(this, recipeactivity3::class.java)
            intent.putExtra("category", "Category 3")
            startActivity(intent)
        }

        val categoryImageView4 = findViewById<ImageView>(R.id.__img___food4)
        categoryImageView4.setOnClickListener {
            val intent = Intent(this, recipeactivity4::class.java)
            intent.putExtra("category", "Category 4")
            startActivity(intent)
        }

        val categoryImageView5 = findViewById<ImageView>(R.id.__img___food5)
        categoryImageView5.setOnClickListener {
            val intent = Intent(this, recipeactivity5::class.java)
            intent.putExtra("category", "Category 5")
            startActivity(intent)
        }

        val categoryImageView6 = findViewById<ImageView>(R.id.__img___food6)
        categoryImageView6.setOnClickListener {
            val intent = Intent(this, recipeactivity6::class.java)
            intent.putExtra("category", "Category 6")
            startActivity(intent)
        }

        val categoryImageView7 = findViewById<ImageView>(R.id.__img___food7)
        categoryImageView7.setOnClickListener {
            val intent = Intent(this, recipeactivity7::class.java)
            intent.putExtra("category", "Category 7")
            startActivity(intent)
        }

        val categoryImageView8 = findViewById<ImageView>(R.id.__img___food8)
        categoryImageView8.setOnClickListener {
            val intent = Intent(this, recipeactivity8::class.java)
            intent.putExtra("category", "Category 8")
            startActivity(intent)
        }

        val categoryImageView9 = findViewById<ImageView>(R.id.__img___food9)
        categoryImageView9.setOnClickListener {
            val intent = Intent(this, recipeactivity9::class.java)
            intent.putExtra("category", "Category 9")
            startActivity(intent)
        }

        val categoryImageView10 = findViewById<ImageView>(R.id.__img___food10)
        categoryImageView10.setOnClickListener {
            val intent = Intent(this, recipeactivity10::class.java)
            intent.putExtra("category", "Category 10")
            startActivity(intent)
        }

        val categoryImageView11 = findViewById<ImageView>(R.id.__img___food11)
        categoryImageView11.setOnClickListener {
            val intent = Intent(this, recipeactivity11::class.java)
            intent.putExtra("category", "Category 11")
            startActivity(intent)
        }

        val categoryImageView12 = findViewById<ImageView>(R.id.__img___food12)
        categoryImageView12.setOnClickListener {
            val intent = Intent(this, recipeactivity12::class.java)
            intent.putExtra("category", "Category 12")
            startActivity(intent)
        }






    }
}

