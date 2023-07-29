package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class memberjoinactivity1 : AppCompatActivity() {

    //로그인, 회원가입 관리 -> firebase이용
    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memberjoin1)

        auth = Firebase.auth

        //선언(아이디 등록)
        val editTextName = findViewById<EditText>(R.id.t9ttt)
        val editTextBirth = findViewById<EditText>(R.id.t8ttt)
        val editTextEmail = findViewById<EditText>(R.id.t7ttt)
        val editTextPassword = findViewById<EditText>(R.id.t6ttt)
        val buttonNext = findViewById<Button>(R.id.__img___nexticon1)
        val backicon1 = findViewById<ImageView>(R.id.backicon1)

        //리스너 등록
        buttonNext.setOnClickListener {
            val name = editTextName.text.toString()
            val birth = editTextBirth.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // 계정 생성 버튼
            createAccount(email, password, name)
        }

        //상단의 뒤로가기 아이콘 클릭시 로그인 화면으로 되돌아간다
        backicon1.setOnClickListener {
            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String, name: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 회원가입 성공 메시지 토스트로 출력
                        Toast.makeText(this, "계정 생성 완료.", Toast.LENGTH_SHORT).show()

                        // Firebase Realtime Database에 이름 저장
                        val userId = auth?.currentUser?.uid
                        if (userId != null) {
                            val userRef =
                                FirebaseDatabase.getInstance().getReference("users").child(userId)
                            userRef.child("name").setValue(name)

                            // 회원가입 성공 시 사용자 이름을 SharedPreferences에 저장
                            saveUserNameToSharedPreferences(name)

                            val intent = Intent(this, memberjoinsuccesactivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "계정 생성 실패", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }

    // 회원가입 성공 시 호출되는 함수
    private fun saveUserNameToSharedPreferences(userName: String) {
        val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("user_name", userName)
        editor.apply()
    }
}
