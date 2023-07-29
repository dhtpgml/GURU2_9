package com.example.guru2_9

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream

class profileeditactivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var imageViewProfile: ImageView
    private lateinit var spinnerCookingLevel: Spinner
    private lateinit var spinnerFavorFood: Spinner
    private lateinit var preferences: SharedPreferences

    // 스피너에서 선택된 항목들을 저장하기 위한 변수들
    private var selectedCookingLevel: String? = null
    private var selectedFavorFood: String? = null
    private var imageByteArray: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profileedit_x)

        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // 뒤로 가기 아이콘을 클릭했을 때 처리하는 메서드
        val backicon9 = findViewById<ImageView>(R.id.backicon9)
        backicon9.setOnClickListener {
            saveData()
            val intent = Intent(this, mypage_activity::class.java)
            startActivity(intent)
        }

        // 수정 버튼을 눌렀을 때 이벤트 처리
        val editButton = findViewById<TextView>(R.id.t57ttt)
        editButton.setOnClickListener {
            saveData()
            // 수정 버튼을 누르면 토스트 메시지가 뜨도록 처리
            showToast("수정 되었습니다!")
        }

        imageViewProfile = findViewById(R.id.myicon2)
        imageViewProfile.setOnClickListener {
            openGalleryForProfileImage()
        }

        val profileImageEditButton = findViewById<TextView>(R.id.profileimage_edit)
        profileImageEditButton.setOnClickListener {
            openGalleryForProfileImage() // 프로필 사진 관리 버튼을 누르면 전자 앨범이 열리도록 설정
        }



        spinnerCookingLevel = findViewById(R.id.spinner_cookinglevel)
        spinnerFavorFood = findViewById(R.id.spinner_favor_food)

        // 스피너 어댑터 설정과 arrays.xml의 배열 연결
        val cookingLevelAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.cook_level,
            android.R.layout.simple_spinner_item
        )
        cookingLevelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCookingLevel.adapter = cookingLevelAdapter

        val favorFoodAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.foodfavor_choose,
            android.R.layout.simple_spinner_item
        )
        favorFoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFavorFood.adapter = favorFoodAdapter

        // 스피너에서 저장된 값을 불러오기
        val savedCookingLevel = preferences.getString("COOKING_LEVEL", "")
        val savedFavorFood = preferences.getString("FAVOR_FOOD", "")
        val savedImageByteArray = preferences.getString("IMAGE_BYTE_ARRAY", null)
        spinnerCookingLevel.setSelection(cookingLevelAdapter.getPosition(savedCookingLevel))
        spinnerFavorFood.setSelection(favorFoodAdapter.getPosition(savedFavorFood))
        savedImageByteArray?.let {
            imageByteArray = it
            val imageBitmap = decodeImageFromString(imageByteArray!!)
            imageViewProfile.setImageBitmap(imageBitmap)
        }

        // 스피너에서 선택된 값을 저장하는 리스너 설정
        spinnerCookingLevel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCookingLevel = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 선택이 해제된 경우 처리할 내용 (아무것도 하지 않음)
            }
        }

        spinnerFavorFood.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedFavorFood = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 선택이 해제된 경우 처리할 내용 (아무것도 하지 않음)
            }
        }
    }

    // 토스트 메시지를 띄우는 함수
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    //앨범 접근 관련
    private fun openGalleryForProfileImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            val imageBitmap = getBitmapFromUri(imageUri)
            imageViewProfile.setImageBitmap(imageBitmap)
            imageByteArray = encodeImageToString(imageBitmap)
        }
    }

    // 데이터를 저장하는 함수
    private fun saveData() {
        val editor = preferences.edit()
        editor.putString("COOKING_LEVEL", selectedCookingLevel)
        editor.putString("FAVOR_FOOD", selectedFavorFood)
        editor.putString("IMAGE_BYTE_ARRAY", imageByteArray)
        editor.apply()
    }

    // Bitmap to Base64 String
    private fun encodeImageToString(image: Bitmap): String {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val byteArrayImage = baos.toByteArray()
        return Base64.encodeToString(byteArrayImage, Base64.DEFAULT)
    }

    // Base64 String to Bitmap
    private fun decodeImageFromString(imageString: String): Bitmap {
        val imageBytes = Base64.decode(imageString, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    // Get Bitmap from Uri
    private fun getBitmapFromUri(uri: Uri?): Bitmap {
        return MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
    }
}
