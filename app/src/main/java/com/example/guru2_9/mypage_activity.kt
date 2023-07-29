package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class mypage_activity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var bookmarksRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage)

        // Firebase 초기화
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        bookmarksRef = database.getReference("bookmarks")

        val profileEditButton = findViewById<TextView>(R.id.profileedit_black)
        val logoutButton = findViewById<TextView>(R.id.logout_black)
        val quitButton = findViewById<TextView>(R.id.quit_black)
        val backButton = findViewById<ImageView>(R.id.backicon8)

        // 사용자 이름 불러오기
        val userId = auth.currentUser?.uid
        if (userId != null) {
            val userRef = database.getReference("users").child(userId)
            userRef.child("name").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val name = snapshot.value as? String
                    if (!name.isNullOrEmpty()) {
                        val helloText = findViewById<TextView>(R.id.hello_my)
                        helloText.text = "$name 님 안녕하세요!"

                        // 사용자 이름을 SharedPreferences에 저장
                        saveUserNameToSharedPreferences(name)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // 오류 처리
                }
            })
        }

        // SharedPreferences에서 저장된 사용자 이름 불러오기
        val userName = getUserNameFromSharedPreferences()
        if (!userName.isNullOrEmpty()) {
            val helloText = findViewById<TextView>(R.id.hello_my)
            helloText.text = "$userName 님 안녕하세요!"
        }

        // 나머지 코드는 그대로 유지합니다...

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
            val intent = Intent(this, mainpage_x_activity::class.java)
            startActivity(intent) // 뒤로 가기 기능 실행
        }
    }

    private fun saveUserNameToSharedPreferences(userName: String) {
        val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("user_name", userName)
        editor.apply()
    }

    private fun getUserNameFromSharedPreferences(): String? {
        val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        return sharedPref.getString("user_name", "")
    }
}
