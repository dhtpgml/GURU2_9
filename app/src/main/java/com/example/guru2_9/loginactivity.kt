package com.example.guru2_9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class loginactivity : AppCompatActivity() {

    //로그인, 회원가입 관리 -> firebase이용
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = FirebaseAuth.getInstance()

        //선언(아이디 등록)
        val editTextEmail = findViewById<EditText>(R.id.t3ttt)
        val editTextPassword = findViewById<EditText>(R.id.t2ttt)
        val buttonLogin = findViewById<Button>(R.id.rectangle_3)
        val buttonjoin = findViewById<Button>(R.id.t4ttt)


        //리스너 등록
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // 로그인
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 로그인 성공한 경우
                        Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()

                        //토스트 메시지 띄우고, 메인페이지(홈)으로 화면 전환
                        val intent = Intent(this, mainpage_x_activity::class.java)
                        startActivity(intent)
                    }
                    else {
                        // 로그인 실패한 경우
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // 회원가입 화면으로 전환
        buttonjoin.setOnClickListener {
            val intent = Intent(this, memberjoinactivity1::class.java)
            startActivity(intent)
        }

    }
}