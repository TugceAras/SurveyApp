package com.tugcearas.surveyapp_thirdhomework.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tugcearas.surveyapp_thirdhomework.databinding.ActivityMainBinding
import com.tugcearas.surveyapp_thirdhomework.ui.informations.InformationScreen

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        clickButton()
    }

    private fun clickButton(){
        binding.btnHome.setOnClickListener {
            val getNameSurname = binding.etNameSurname.text.toString()

            if (getNameSurname.isEmpty()){
                Toast.makeText(this@MainActivity, "Please fill in the blank!", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this@MainActivity,InformationScreen::class.java)
                intent.putExtra("nameSurname",getNameSurname)
                startActivity(intent)
                Toast.makeText(this@MainActivity, "Successfully!", Toast.LENGTH_SHORT).show()
                binding.etNameSurname.setText("")
            }
        }
    }

}