package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class mypage_activity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage)

        val profileEditButton = findViewById<TextView>(R.id.profileedit_black)
        val logoutButton = findViewById<TextView>(R.id.logout_black)
        val quitButton = findViewById<TextView>(R.id.quit_black)
        val backButton = findViewById<ImageView>(R.id.backicon8)

        //auth 변수 초기화(필수)
        auth = FirebaseAuth.getInstance()

        // 프로필 편집 버튼 클릭 시 이벤트 처리
        profileEditButton.setOnClickListener {
            // 프로필 편집 화면으로 이동하는 코드
            val intent = Intent(this, profileeditactivity::class.java)
            startActivity(intent)
        }

        // 로그아웃 버튼 클릭 시 이벤트 처리
        logoutButton.setOnClickListener {
            // Firebase 로그아웃 처리
            auth.signOut()

            // 로그아웃 후 로그인 화면으로 이동
            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
            finish() // 현재 액티비티를 종료하여 뒤로 가기 시 마이페이지 화면으로 돌아오지 않도록 함
        }


        // 탈퇴하기 버튼 클릭 시 이벤트 처리
        quitButton.setOnClickListener {
            // Firebase 회원 탈퇴 처리
            val user = auth.currentUser
            user?.delete()?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // 회원 탈퇴 성공한 경우
                    Toast.makeText(this, "회원 탈퇴 완료.", Toast.LENGTH_SHORT).show()

                    // 로그인 화면으로 이동
                    val intent = Intent(this, loginactivity::class.java)
                    startActivity(intent)
                    finish() // 현재 액티비티를 종료하여 뒤로 가기 시 마이페이지 화면으로 돌아오지 않도록 함
                } else {
                    // 회원 탈퇴 실패한 경우
                    Toast.makeText(this, "회원 탈퇴 실패", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // 뒤로 가기 버튼 클릭 시 이벤트 처리
        backButton.setOnClickListener {
            onBackPressed() // 뒤로 가기 기능 실행
        }
    }
}