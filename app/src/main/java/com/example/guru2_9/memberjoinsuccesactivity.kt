package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
// 회원가입 완료하면 회원 가입을 축하하는 이미지를 띄움
class memberjoinsuccesactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memberjoinsucces)

        val loginback = findViewById<Button>(R.id.loginback)

        //리스너 등록, 버튼 클릭시 로그인 화면으로 이동한다
        loginback.setOnClickListener {
            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        }

    }
}