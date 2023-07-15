package com.tugcearas.surveyapp_thirdhomework.ui.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.tugcearas.surveyapp_thirdhomework.data.Info
import com.tugcearas.surveyapp_thirdhomework.databinding.ActivityResultScreenBinding
import com.tugcearas.surveyapp_thirdhomework.ui.home.MainActivity

class ResultScreen : AppCompatActivity() {

    private lateinit var binding: ActivityResultScreenBinding
    private var backPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        bindInfo()
        clickButton()
        backPressed()
    }

    private fun bindInfo(){

        val getAllInfo = intent.getParcelableExtra("allInfos") as Info?

        with(binding){
            tvResultNameSurname.text = getAllInfo?.personalInfo?.nameSurname.toString()
            tvResultMail.text = getAllInfo?.personalInfo?.mail.toString()
            tvResultPhone.text = getAllInfo?.personalInfo?.phoneNumber.toString()
            tvResultCity.text = getAllInfo?.personalInfo?.city.toString()
            tvResultBookName.text = getAllInfo?.bookName.toString()
            tvResultSongName.text = getAllInfo?.songName.toString()
            tvResultMovieName.text = getAllInfo?.movieName.toString()
        }
    }

    private fun clickButton(){

        binding.btnResult.setOnClickListener {
            val intent = Intent(this@ResultScreen, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    private fun backPressed(){
        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (backPressedOnce) {
                    val intent = Intent(this@ResultScreen, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@ResultScreen, "Press back button again to return to home screen!", Toast.LENGTH_SHORT).show()
                    backPressedOnce = true
                }
            }
        })
    }
}