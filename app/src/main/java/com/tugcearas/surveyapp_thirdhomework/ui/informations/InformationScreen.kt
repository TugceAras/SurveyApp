package com.tugcearas.surveyapp_thirdhomework.ui.informations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tugcearas.surveyapp_thirdhomework.data.PersonalInfo
import com.tugcearas.surveyapp_thirdhomework.databinding.ActivityInformationScreenBinding
import com.tugcearas.surveyapp_thirdhomework.ui.custom.CustomScreen

class InformationScreen : AppCompatActivity() {

    private lateinit var binding: ActivityInformationScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickButton()
    }

    private fun clickButton(){

        val getNameSurnameFromHome = intent.getStringExtra("nameSurname")
        binding.tvNameSurnameInfo.text = getNameSurnameFromHome

        binding.btnInfo.setOnClickListener {
            val getMail = binding.etMail.text.toString()
            val getPhone = binding.etPhone.text.toString()
            val getCity = binding.etCity.text.toString()

            if (getMail.isEmpty() || getPhone.isEmpty() || getCity.isEmpty()){
                Toast.makeText(this@InformationScreen, "Please enter your informations!", Toast.LENGTH_SHORT).show()
            }
            else{
                val personalInfo = PersonalInfo(getNameSurnameFromHome,getMail,getPhone,getCity)
                val intent = Intent(this@InformationScreen, CustomScreen::class.java)
                intent.putExtra("personalInfo",personalInfo)
                finish()
                startActivity(intent)
                Toast.makeText(this@InformationScreen, "Successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}