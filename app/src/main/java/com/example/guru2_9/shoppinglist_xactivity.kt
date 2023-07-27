package com.example.guru2_9

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class shoppinglist_xactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoppinglist_x)

        // 이미지뷰를 찾아서 클릭 리스너 설정
        val iconImageView1 = findViewById<ImageView>(R.id.homeicon_black2)
        iconImageView1.setOnClickListener {
            // 클릭 이벤트가 발생했을 때 실행될 코드
            // 다른 액티비티로 전환하는 코드 작성
            val intent = Intent(this, mainpage_x_activity::class.java)
            startActivity(intent)
        }

        val iconImageView2: ImageView = findViewById<ImageView>(R.id.recipebookicon_black2)
        iconImageView2.setOnClickListener {
            val intent = Intent(this, recipebook1activity::class.java)
            startActivity(intent)
        }

        val iconImageView3: ImageView = findViewById<ImageView>(R.id.shoppinglisticon_black2)
        iconImageView3.setOnClickListener {
            val intent = Intent(this, shoppinglist_xactivity::class.java)
            startActivity(intent)
        }

        val iconImageView4: ImageView = findViewById<ImageView>(R.id.mypageicon_black2)
        iconImageView4.setOnClickListener {
            val intent = Intent(this, mypage_activity::class.java)
            startActivity(intent)
        }

        val iconImageView5: ImageView = findViewById<ImageView>(R.id.rouletteicon_black2)
        iconImageView5.setOnClickListener {
            val intent = Intent(this, foodrouletteactivity::class.java)
            startActivity(intent)
        }

        val imageView1 = findViewById<ImageView>(R.id.__img___t39)
        val backicon4 = findViewById<ImageView>(R.id.backicon4)

        // 이미지뷰를 클릭하면 메모 수정 다이얼로그를 띄우는 리스너 설정
        imageView1.setOnClickListener {
            showEditDialog()
        }

        //뒤로가기(메인페이지로 이동)
        backicon4.setOnClickListener {
            val intent = Intent(this, mainpage_x_activity::class.java)
            startActivity(intent)
        }
    }

    // 메모를 수정할 수 있는 다이얼로그 표시
    private fun showEditDialog() {
        // 다이얼로그에 표시될 EditText 생성 및 기존 메모 내용으로 초기화
        val editTextDialog = EditText(this)
        val textView1 = findViewById<EditText>(R.id.textView1).text.toString()
        editTextDialog.setText(textView1)

        // AlertDialog 빌더를 사용하여 다이얼로그 생성
        val dialog = AlertDialog.Builder(this)
            .setTitle("메모 수정") // 다이얼로그 제목 설정
            .setView(editTextDialog) // 다이얼로그에 EditText 추가
            .setPositiveButton("저장") { _, _ ->
                // "저장" 버튼 클릭 시 실행되는 리스너
                // EditText에 입력된 메모를 가져와서 원래 TextView에 업데이트하고 토스트 메시지를 표시
                val updatedText = editTextDialog.text.toString()
                findViewById<EditText>(R.id.textView1).setText(updatedText)
                Toast.makeText(this, "메모 수정 완료", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("취소", null) // "취소" 버튼 클릭 시 아무 동작 없음
            .create()

        // 다이얼로그를 화면에 표시
        dialog.show()
    }
}